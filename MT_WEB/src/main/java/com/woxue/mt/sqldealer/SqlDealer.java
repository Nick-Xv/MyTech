package com.woxue.mt.sqldealer;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SqlDealer
{
    public enum Order { DEFAULT, REFERENCE_COUNT, RECENT, WORK_NUM }

    private SqlSession sqlSession;

    //构造函数
    public SqlDealer() throws Exception
    {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 搜索未审核论文
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Thesis> searchThesisUnverified(int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchThesisUnverified", args);
    }

    /**
     * 搜索论文
     * @param keywords 关键词，null代表任意
     * @param yearStart 起始年份（包括），范围("0000"~"9999")
     * @param order 排序方式
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Thesis> searchThesis(List<String> keywords, String yearStart, Order order, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("keywords", keywords != null ? keywords : new ArrayList<>(Arrays.asList(".")));
        args.put("yearStart", yearStart);
        args.put("yearEnd", "9999");
        args.put("order", order.toString());
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchThesis", args);
    }

    /**
     * 根据ID搜索论文
     */
    public Thesis searchThesisById(String id)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return sqlSession.selectOne("mapper.searchThesisById", args);
    }

    /**
     * 高级搜索论文
     * @param titles 主题，null代表任意
     * @param authors 作者，null代表任意
     * @param keywords 关键词，null代表任意
     * @param yearStart 起始年份（包括），范围("0000"~"9999")
     * @param yearEnd 结束年份（不包括），范围("0000"~"9999")
     * @param order 排序方式
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Thesis> advancedSearchThesis(List<String> titles, List<String> authors, List<String> keywords, String yearStart, String yearEnd, Order order, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("titles", titles != null ? titles : new ArrayList<>(Arrays.asList(".")));
        args.put("authors", authors != null ? authors : new ArrayList<>(Arrays.asList(".")));
        args.put("keywords", keywords != null ? keywords : new ArrayList<>(Arrays.asList(".")));
        args.put("yearStart", yearStart);
        args.put("yearEnd", yearEnd);
        args.put("order", order.toString());
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.advancedSearchThesis", args);
    }

    /**
     * 根据最多引用推荐论文
     * @param number 推荐论文的数量
     * @return 搜索结果
     */
    public List<Thesis> searchThesisRecommandedByReferenceCount(int number)
    {
        if (number <= 0)
            return null;
        HashMap<String, Object> args = new HashMap<>();
        args.put("number", number);
        args.put("limit", number * 3);
        return sqlSession.selectList("mapper.searchThesisRecommandedByReferenceCount", args);
    }

    /**
     * 根据科技专家ID搜索论文
     * @param professorId 科技专家ID
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Thesis> searchThesisByProfessorId(String professorId, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("professorId", professorId);
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchThesisByProfessorId", args);
    }

    /**
     * 更新论文
     * @param thesis 更新后的论文，以ID为目标
     */
    public void updateThesis(Thesis thesis)
    {
        sqlSession.update("mapper.updateThesis", thesis);
        sqlSession.commit();
    }

    /**
     * 插入论文
     * @param thesis 插入的论文
     */
    public void insertThesis(Thesis thesis)
    {
        sqlSession.insert("mapper.insertThesis", thesis);
        sqlSession.commit();
    }

    /**
     * 根据ID删除论文
     * @param id 删除的ID
     */
    public void deleteThesisById(String id)
    {
        sqlSession.delete("mapper.deleteThesisById", id);
        sqlSession.commit();
    }

    /**
     * 搜索科技专家
     * @param keywords 关键词，null代表任意
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Professor> searchProfessor(List<String> keywords, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("keywords", keywords != null ? keywords : new ArrayList<>(Arrays.asList(".")));
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchProfessor", args);
    }

    /**
     * 高级搜索科技专家
     * @param names 专家姓名，null代表任意
     * @param organizations 所属机构，null代表任意
     * @param areas 领域，null代表任意
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Professor> advancedSearchProfessor(List<String> names, List<String> organizations, List<String> areas, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("names", names != null ? names : new ArrayList<>(Arrays.asList(".")));
        args.put("organizations", organizations != null ? organizations : new ArrayList<>(Arrays.asList(".")));
        args.put("areas", areas != null ? areas : new ArrayList<>(Arrays.asList(".")));
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.advancedSearchProfessor", args);
    }

    /**
     * 根据ID搜索科技专家
     * @param id 科技专家ID
     * @return 搜索结果
     */
    public Professor searchProfessorById(String id)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return sqlSession.selectOne("mapper.searchProfessorById", id);
    }

    /**
     * 搜索未审核科技专家
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Professor> searchProfessorUnverified(int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchProfessorUnverified", args);
    }

    /**
     * 根据领域搜索专家
     * @param area 领域
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Professor> searchProfessorByArea(String area, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("area", area);
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchProfessor", args);
    }

    /**
     * 更新专家
     * @param professor 更新后的专家，以ID为目标
     */
    public void updateProfessor(Professor professor)
    {
        sqlSession.update("mapper.updateProfessor", professor);
        sqlSession.commit();
    }

    /**
     * 根据ID删除科技专家
     * @param id 删除的ID
     */
    public void deleteProfessorById(String id)
    {
        sqlSession.delete("mapper.deleteProfessorById", id);
        sqlSession.commit();
    }

    /**
     * 搜索用户
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<User> searchUser(int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchUser", args);
    }

    /**
     * 根据ID搜索用户
     * @param id 用户ID
     * @return 搜索结果
     */
    public User searchUserById(String id)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return sqlSession.selectOne("mapper.searchUserById", args);
    }

    /**
     * 更新用户
     * @param user 更新后的用户，以ID为目标
     */
    public void updateUser(User user)
    {
        sqlSession.update("mapper.updateUser", user);
        sqlSession.commit();
    }

    /**
     * 插入用户
     * @param user 插入的用户
     */
    public void insertUser(User user)
    {
        sqlSession.insert("mapper.insertUser", user);
        sqlSession.commit();
    }

    /**
     * 根据ID删除用户
     * @param id 删除的ID
     */
    public void deleteUserById(String id)
    {
        sqlSession.delete("mapper.deleteUserById", id);
        sqlSession.commit();
    }

    /**
     * 根据科技专家ID搜索动态
     * @param id 动态ID
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Trend> searchTrendByProfessorId(String id, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchTrendByProfessorId", args);
    }

    public List<Trend> searchTrendByUserId(String id)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return sqlSession.selectList("mapper.searchTrendByUserId", args);
    }

    public List<Trend> searchTrendByUserId2(String id)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return sqlSession.selectList("mapper.searchTrendByUserId2", args);
    }

    /**
     * 插入动态
     * @param trend 插入的动态
     */
    public void insertTrend(Trend trend)
    {
        sqlSession.insert("mapper.insertTrend", trend);
        sqlSession.commit();
    }

    /**
     * 根据ID删除动态
     * @param id 删除的ID
     */
    public void deleteTrendById(String id)
    {
        sqlSession.delete("mapper.deleteTrendById", id);
        sqlSession.commit();
    }

    /**
     * 根据ID更新动态
     * @param id 更新的ID
     */
    public void updateTrendById(String id,String content)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("content",content);
        sqlSession.update("mapper.updateTrendById", args);
        sqlSession.commit();
    }

    /**
     * 根据论文ID搜索评论
     * @param thesisId 论文ID
     * @return 搜索结果
     */
    public List<Comment> searchCommentByThesisId(String thesisId)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("thesisId", thesisId);
        return sqlSession.selectList("mapper.searchCommentByThesisId", args);
    }

    /**
     * 插入评论
     * @param comment 插入的评论
     */
    public void insertComment(Comment comment)
    {
        sqlSession.insert("mapper.insertComment", comment);
        sqlSession.commit();
    }

    /**
     * 根据科技专家ID搜索关系网络
     * @param professorId 科技专家ID
     * @return 搜索结果
     */
    public Relationship searchRelationshipByProfessorId(String professorId)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("professorId", professorId);
        return sqlSession.selectOne("mapper.searchRelationshipByProfessorId", args);
    }

    /**
     * 根据科技专家ID搜索专家拥有论文
     * @param professorId 科技专家ID
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<ProfessorOwnThesis> searchProfessorOwnThesisByProfessorId(String professorId, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("professorId", professorId);
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchProfessorOwnThesisByProfessorId", args);
    }

    /**
     * 根据科技专家ID搜索专家拥有论文数量
     * @param professorId 科技专家ID
     * @return 搜索结果
     */
    public int searchProfessorOwnThesisCountByProfessorId(String professorId)
    {
        return sqlSession.selectOne("mapper.searchProfessorOwnThesisCountByProfessorId", professorId);
    }

    /**
     * 搜索专利
     * @param keywords 关键词，null代表任意
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Patent> searchPatent(List<String> keywords, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("keywords", keywords);
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchPatent", args);
    }

    /**
     * 高级搜索专利
     * @param names 专利名字，null代表任意
     * @param applicants 申请人，null代表任意
     * @param inventors 发明人，null代表任意
     * @param ids 申请号，null代表任意
     * @param dateStart 起始日期（包括），范围（"0000-00-00"~"9999-99-99"）
     * @param dateEnd 结束日期（不包括），范围（"0000-00-00"~"9999-99-99"）
     * @param limitStart 起始索引
     * @param limitEnd 结束索引
     * @return 搜索结果
     */
    public List<Patent> advancedSearchPatent(List<String> names, List<String> applicants, List<String> inventors, List<String> ids, String dateStart, String dateEnd, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("names", names != null ? names : new ArrayList<>(Arrays.asList(".")));
        args.put("applicants", applicants != null ? applicants : new ArrayList<>(Arrays.asList(".")));
        args.put("inventors", inventors != null ? inventors : new ArrayList<>(Arrays.asList(".")));
        args.put("ids", ids != null ? ids : new ArrayList<>(Arrays.asList(".")));
        args.put("dateStart", dateStart);
        args.put("dateEnd", dateEnd);
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.advancedSearchPatent", args);
    }

    /**
     * 根据ID搜索专利
     */
    public Patent searchPatentById(String id)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return sqlSession.selectOne("mapper.searchPatentById", args);
    }

    /**
     * 根据用户ID搜索用户购买论文
     * @param userId 科技专家ID
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<UserBuyThesis> searchUserBuyThesisByUserId(String userId, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("userId", userId);
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchUserBuyThesisByUserId", args);
    }

    /**
     * 插入用户购买论文
     * @param userBuyThesis 插入的用户购买论文
     */
    public void insertUserBuyThesis(UserBuyThesis userBuyThesis)
    {
        sqlSession.insert("mapper.insertUserBuyThesis", userBuyThesis);
        sqlSession.commit();
    }

    /**
     * 更新论文平均分
     * @param t 更新后的论文
     */
    public void updateClick1(Thesis t)
    {
        sqlSession.update("mapper.updateThesisClick1", t);
        sqlSession.commit();
    }

    public void updateClick2(Thesis t)
    {
        sqlSession.update("mapper.updateThesisClick2", t);
        sqlSession.commit();
    }

    public void updateGrade1(Thesis t)
    {
        sqlSession.update("mapper.updateThesisGrade1", t);
        sqlSession.commit();
    }

    public void updateGrade2(Thesis t)
    {
        sqlSession.update("mapper.updateThesisGrade2", t);
        sqlSession.commit();
    }

    /**
     * 根据ID搜索关注关系
     * @param id1 用户ID
     * @param id2 专家ID
     * @return 搜索结果
     */
    public Watch searchWatchById(String id1, String id2)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id1", id1);
        args.put("id2", id2);
        return sqlSession.selectOne("mapper.searchWatchById", args);
    }

    /**
     * 根据ID搜索全部关注关系
     * @param id1 用户ID
     * @return 搜索结果
     */
    public List<Watch> searchWatchAllById(String id1)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id1", id1);
        return sqlSession.selectList("mapper.searchWatchAllById", args);
    }

    /**
     * 插入关注表
     * @param id1 用户ID
     * @param id2 专家ID
     * @return 搜索结果
     */
    public void insertWatch(String id1, String id2)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id1", id1);
        args.put("id2", id2);
        sqlSession.insert("mapper.insertWatch", args);
        sqlSession.commit();
    }

    /**
     * 根据ID删除关注
     * @param id1 删除的ID1
     * @param id2 删除的ID2
     */
    public void deleteWatchById(String id1,String id2)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id1", id1);
        args.put("id2", id2);
        sqlSession.delete("mapper.deleteWatchById", args);
        sqlSession.commit();
    }

    /**
     * 根据专家ID搜索本站论文
     * @param id 用户ID
     * @return 搜索结果
     */
    public List<Thesis> searchLocalThesisById(String id)
    {
        return sqlSession.selectList("mapper.searchLocalThesisById", id);
    }

    /**
     * 根据用户ID搜索已购资源
     * @param id 用户ID
     * @return 搜索结果
     */
    public List<Thesis> searchBoughtThesisById(String id)
    {
        return sqlSession.selectList("mapper.searchBoughtThesisById", id);
    }

    public List<Professor> searchProfessorRecommandedByReferenceCount(int number){
        if (number <= 0)
            return null;
        HashMap<String, Object> args = new HashMap<>();
        args.put("number", number);
        args.put("limit", number * 3);
        return sqlSession.selectList("mapper.searchProfessorRecommandedByReferenceCount", args);
    }
    //析构函数
    protected void finalize()
    {
        sqlSession.close();
    }
}
