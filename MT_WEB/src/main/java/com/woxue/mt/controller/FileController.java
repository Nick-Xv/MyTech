package com.woxue.mt.controller;

import com.woxue.mt.dao.LocalEssayDao;
import com.woxue.mt.entity.LocalEssay;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Thesis;
import com.woxue.mt.sqldealer.User;
import com.woxue.mt.sqldealer.UserBuyThesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * ftp上传下载工具类
 */
@Controller("fileController")
public class FileController {

    @Autowired
    private LocalEssayDao localEssayDao;
    private static SqlDealer sqlDealer = null;

    static {
        try {
            sqlDealer =  new SqlDealer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //没搞定
    @RequestMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpSession session) throws Exception{

        com.woxue.mt.entity.User user = (com.woxue.mt.entity.User)session.getAttribute("user");
        String professorID = user.getId();
        //File file = new File(localPath.trim());

        String fileName = uploadFile.getName();
        System.out.println(fileName);
        /*Thesis thesis = new Thesis();
        thesis.title = request.getParameter("title");
        thesis.author = request.getParameter("author");
        thesis.publishTime = request.getParameter("publishTime");
        thesis.keyword = request.getParameter("keyword");
        thesis.summary = request.getParameter("summary");
        thesis.url = request.getParameter("/" + professorID + "/" + fileName);*/

        /*localEssay.setProfessorId(user.getId());
        localEssay.setLink("/" + professorID + "/" + fileName);
        localEssayDao.insert(localEssay);*/

        FileInputStream in = new FileInputStream(new File("localPath"));
        uploadFile(
                "94.191.112.232", 21, "ftpuser", "1234",
                "/ftpfile", "/" + professorID, fileName, in);

        /*thesis.professorId = professorID;
        sqlDealer.insertThesis(thesis);*/
        session.setAttribute("essayLink","/" + professorID + "/" + fileName);
        return "redirect:local_essay_add";
    }

    @RequestMapping("/download")
    public String download(HttpServletRequest request, Model model) {
        String localPath = request.getParameter("localPath");
        String userID = request.getParameter("userID");
        String professorID = request.getParameter("professorID");
        String thesisID = request.getParameter("thesisID");
        int score = Integer.parseInt(request.getParameter("score"));

        List<UserBuyThesis> thesises = sqlDealer.searchUserBuyThesisByUserId(userID, 0, 100);
        boolean contain = false;
        for (UserBuyThesis ubt : thesises) {
            if(ubt.thesisId.equals(thesisID)){
                contain = true;
                break;
            }
        }

         if(contain) {
           return "已拥有论文"; // TODO:
        } else {
            User user = sqlDealer.searchUserById(userID);
            if(user.score < score) {
                return "充值"; // TODO:
            }else{
                // 扣分
                user.score -= score;
                sqlDealer.updateUser(user);
                // 下载
                Thesis thesis = sqlDealer.searchThesisById(thesisID);
                String url = thesis.url;
                String thesisName = url.substring(professorID.length() + 2, url.length()); // 去掉两个斜杠
                downloadFile("94.191.112.232", 21, "ftpuser", "1234",
                        "/ftpfile/" + professorID,
                        thesisName, localPath);
                // 插入购买信息
                UserBuyThesis userBuyThesis = new UserBuyThesis();
                userBuyThesis.userId = userID;
                userBuyThesis.thesisId = thesisID;
                sqlDealer.insertUserBuyThesis(userBuyThesis);
                return "购买成功"; // TODO:
            }
        }
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    private static boolean uploadFile(String host, int port, String username, String password, String basePath,
                                     String filePath, String filename, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath+filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            ftp.enterLocalPassiveMode();
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                return result;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    /**
     * Description: 从FTP服务器下载文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param remotePath FTP服务器上的相对路径
     * @param fileName 要下载的文件名
     * @param localPath 下载后保存到本地的路径
     * @return
     */
    private static boolean downloadFile(String host, int port, String username, String password, String remotePath,
                                       String fileName, String localPath) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());

                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }

            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    //---------------测试--------------信息自己填写
    public static void main(String[] args) {
        try {
//            FileInputStream in=new FileInputStream(new File("C:\\Users\\asus\\Desktop\\1.PNG"));
//            uploadFile(
//                    "94.191.112.232", 21, "ftpuser", "1234", "/ftpfile", "c", "1.PNG", in);

//            FileInputStream in=new FileInputStream(new File("E:\\5.jpg"));
//            boolean flag = uploadFile("IP地址", 21, "用户名", "密码", "home/www/images","/2017/10/21", "1.PNG", in);
//            System.out.println(flag);

//            downloadFile("94.191.112.232", 21, "ftpuser", "1234", "/ftpfile/save/",
//                    "1.PNG", "C:\\Users\\asus\\Desktop\\SciTechResPlatform");
//            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}