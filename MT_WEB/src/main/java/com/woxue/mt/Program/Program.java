package com.woxue.mt.Program;

import com.woxue.mt.sqldealer.*;
import java.util.*;

public class Program
{
    public static void main(String[] args)
    {
        try
        {
            SqlDealer sqlDealer = new SqlDealer();

            //高级搜索专利（专利名、申请人、发明人、申请号），显示区间 [limitStart, limitEnd)
//            {
//                List<String> names = new ArrayList<>(Arrays.asList("花生"));
//                List<String> applicants = null;   //为null时，代表匹配内容任意
//                List<String> inventors = null;   //为null时，代表匹配内容任意
//                List<String> ids = null;   //为null时，代表匹配内容任意
//                String dateStart = "2013-07-01";    //必须有前导0
//                String dateEnd = "2013-08-01";
//                int limitStart = 0;
//                int limitEnd = 3;
//                List<Patent> patents = sqlDealer.advancedSearchPatent(names, applicants, inventors, ids, dateStart, dateEnd, limitStart, limitEnd);
//                for (Patent patent : patents)
//                    patent.display();
//            }

            //搜索专利
//            {
//                List<String> keywords = new ArrayList<>(Arrays.asList("毛豆"));
//                int limitStart = 0;
//                int limitEnd = 3;
//                List<Patent> patents = sqlDealer.searchPatent(keywords, limitStart, limitEnd);
//                for (Patent patent : patents)
//                    patent.display();
//            }

            //高级搜索科技专家（专家姓名、机构、领域），显示区间 [limitStart, limitEnd)
//            {
//                List<String> names = new ArrayList<>(Arrays.asList("钟"));
//                List<String> organizations = new ArrayList<>(Arrays.asList("广州"));
//                List<String> areas = null;   //为null时，代表匹配内容任意
//                int limitStart = 0;
//                int limitEnd = 3;
//                List<Professor> professors = sqlDealer.advancedSearchProfessor(names, organizations, areas, limitStart, limitEnd);
//                for (Professor professor : professors)
//                    professor.display();
//            }

            //搜索科技专家
//            {
//                List<String> keywords = new ArrayList<>(Arrays.asList("钟", "广州"));
//                int limitStart = 0;
//                int limitEnd = 5;
//                List<Professor> professors = sqlDealer.searchProfessor(keywords, limitStart, limitEnd);
//                for (Professor professor : professors)
//                    professor.display();
//            }

            //根据论文ID搜索评论
//            {
//                String thesisId = "10.1002/ejic.2014029";
//                List<Comment> comments = sqlDealer.searchCommentByThesisId(thesisId);
//                for (Comment comment : comments)
//                    comment.display();
//            }

            //根据科技专家ID搜索论文
//            {
//                //根据科技专家ID搜索专家拥有论文
//                String professorId = "CN-BF73U50J";
//                int limitStart = 0;
//                int limitEnd = 3;
//                List<ProfessorOwnThesis> professorOwnTheses = sqlDealer.searchProfessorOwnThesisByProfessorId(professorId, limitStart, limitEnd);
//                List<Thesis> theses = new ArrayList<>();
//                for (ProfessorOwnThesis professorOwnThesis : professorOwnTheses)
//                    professorOwnThesis.display();
//                //根据论文ID搜索论文
//                for (ProfessorOwnThesis professorOwnThesis : professorOwnTheses)
//                {
//                    Thesis thesis = sqlDealer.searchThesisById(professorOwnThesis.thesisId);
//                    theses.add(thesis);
//                }
//                for (Thesis thesis : theses)
//                    thesis.display();
//            }

            //根据科技专家ID搜索关系网络
//            {
//                String professorId = "CN-BT74TVCJ";
//                int limitStart = 0;
//                int limitEnd = 2;
//                List<Relationship> relationships = sqlDealer.searchRelationshipByProfessorId(professorId, limitStart, limitEnd);
//                for (Relationship relationship : relationships)
//                    relationship.display();
//            }

            //插入论文
//            {
//                Thesis thesis = new Thesis();
//                thesis.title = "test";
//                thesis.author = "me";
//                thesis.keyword = "ppp";
//                thesis.url = "www.baidu.com";
//                thesis.summary = "try";
//                thesis.professorId = "123";
//                thesis.score = 9;
//                sqlDealer.insertThesis(thesis);
//            }

            //高级搜索论文（标旗、作者、关键词、年份），显示区间 [limitStart, limitEnd)
            {
                List<String> titles = new ArrayList<>(Arrays.asList("test"));
//                List<String> authors = new ArrayList<>(Arrays.asList("Lei", "Chen"));
                List<String> authors = null;
                List<String> keywords = null;   //为null时，代表匹配内容任意
                String yearStart = "2010";
                String yearEnd = "2020";
                SqlDealer.Order order = SqlDealer.Order.REFERENCE_COUNT;
                int limitStart = 0;
                int limitEnd = 5;
                List<Thesis> theses = sqlDealer.advancedSearchThesis(titles, authors, keywords, yearStart, yearEnd, order, limitStart, limitEnd);
                for (Thesis thesis : theses)
                    thesis.display();
            }

            //搜索论文
//            {
//                List<String> keywords = new ArrayList<>(Arrays.asList("test"));
//                SqlDealer.Order order = SqlDealer.Order.REFERENCE_COUNT;
//                int limitStart = 0;
//                int limitEnd = 5;
//                List<Thesis> theses = sqlDealer.searchThesis(keywords, "2010", order, limitStart, limitEnd);
//                for (Thesis thesis : theses)
//                    thesis.display();
//            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
