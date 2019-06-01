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
    public enum Order { DEFAULT, REFERENCE_COUNT, RECENT }

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
     * 搜索论文，与关系
     * @param keywords 关键词，null代表任意
     * @param yearStart 起始年份（包括），范围("0000"~"9999")
     * @param order 排序方式
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Thesis> searchThesisAnd(List<String> keywords, String yearStart, Order order, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("keywords", keywords != null ? keywords : new ArrayList<>(Arrays.asList(".")));
        args.put("yearStart", yearStart);
        args.put("yearEnd", "9999");
        args.put("order", order.toString());
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchThesisAnd", args);
    }

    /**
     * 搜索论文，或关系
     * @param keywords 关键词，null代表任意
     * @param yearStart 起始年份（包括），范围("0000"~"9999")
     * @param order 排序方式
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束索引（不包括）
     * @return 搜索结果
     */
    public List<Thesis> searchThesisOr(List<String> keywords, String yearStart, Order order, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("keywords", keywords != null ? keywords : new ArrayList<>(Arrays.asList(".")));
        args.put("yearStart", yearStart);
        args.put("yearEnd", "9999");
        args.put("order", order.toString());
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchThesisOr", args);
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
     * 高级搜索论文，与关系
     * @param titles 主题，null代表任意
     * @param authors 作者，null代表任意
     * @param keywords 关键词，null代表任意
     * @param yearStart 起始年份（包括），范围("0000"~"9999")
     * @param yearEnd 结束年份（不包括），范围("0000"~"9999")
     * @param order 排序方式
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束年份（不包括）
     * @return 搜索结果
     */
    public List<Thesis> advancedSearchThesisAnd(List<String> titles, List<String> authors, List<String> keywords, String yearStart, String yearEnd, Order order, int limitStart, int limitEnd)
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
        return sqlSession.selectList("mapper.advancedSearchThesisAnd", args);
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
     * 搜索科技专家
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束年份（不包括）
     * @return 搜索结果
     */
    public List<Professor> searchProfessor(int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchProfessor", args);
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
     * @param limitEnd 结束年份（不包括）
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
     * @param limitEnd 结束年份（不包括）
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
     * 专家数量
     * @return 专家数量
     */
    public int countProfessor()
    {
        return sqlSession.selectOne("mapper.countProfessor");
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
     * 搜索用户
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束年份（不包括）
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
     * @param limitEnd 结束年份（不包括）
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

    /**
     * 根据论文ID搜索评论
     * @param thesisId 论文ID
     * @return 搜索结果
     */
    public Comment searchCommentByThesisId(String thesisId)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("thesisId", thesisId);
        return sqlSession.selectOne("mapper.searchCommentByThesisId", args);
    }

    /**
     * 根据科技专家ID搜索关系网络
     * @param professorId 科技专家ID
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束年份（不包括）
     * @return 搜索结果
     */
    public List<Relationship> searchRelationshipByProfessorId(String professorId, int limitStart, int limitEnd)
    {
        HashMap<String, Object> args = new HashMap<>();
        args.put("professorId", professorId);
        args.put("limit1", limitStart);
        args.put("limit2", limitEnd - limitStart);
        return sqlSession.selectList("mapper.searchRelationshipByProfessorId", args);
    }

    /**
     * 根据科技专家ID搜索专家拥有论文
     * @param professorId 科技专家ID
     * @param limitStart 起始索引（包括）
     * @param limitEnd 结束年份（不包括）
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

    //析构函数
    protected void finalize()
    {
        sqlSession.close();
    }
}
