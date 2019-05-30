package com.woxue.mt.sqldealer;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class SqlDealer
{
    private SqlSession sqlSession;

    public SqlDealer() throws Exception
    {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sqlSessionFactory.openSession();
    }

    public List<Thesis> searchThesis(int limit)
    {
        return sqlSession.selectList("mapper.searchThesis", limit);
    }

    public List<Thesis> searchThesisUnverified(int limit)
    {
        return sqlSession.selectList("mapper.searchThesisUnverified", limit);
    }

    public List<Thesis> searchThesisAnd(List<String> keywords)
    {
        return sqlSession.selectList("mapper.searchThesisAnd", keywords);
    }

    public List<Thesis> searchThesisOr(List<String> keywords)
    {
        return sqlSession.selectList("mapper.searchThesisOr", keywords);
    }

    public void updateThesis(Thesis thesis)
    {
        sqlSession.update("mapper.updateThesis", thesis);
        sqlSession.commit();
    }

    public List<Professor> searchProfessor(int limit)
    {
        return sqlSession.selectList("mapper.searchProfessor", limit);
    }

    public List<Professor> searchProfessorUnverified(int limit)
    {
        return sqlSession.selectList("mapper.searchProfessorUnverified", limit);
    }

    public List<Professor> searchProfessorByArea(String area)
    {
        return sqlSession.selectList("mapper.searchProfessor", area);
    }

    public int countProfessor()
    {
        return sqlSession.selectOne("mapper.countProfessor");
    }

    public void updateProfessor(Professor professor)
    {
        sqlSession.update("mapper.updateProfessor", professor);
        sqlSession.commit();
    }

    public List<User> searchUser()
    {
        return sqlSession.selectList("mapper.searchUser");
    }

    public User searchUserById(String Id)
    {
        return sqlSession.selectOne("mapper.searchUser", Id);
    }

    public void updateUser(User user)
    {
        sqlSession.update("mapper.updateUser", user);
        sqlSession.commit();
    }

    public void insertUser(User user)
    {
        sqlSession.insert("mapper.insertUser", user);
        sqlSession.commit();
    }

    public void deleteUserById(String Id)
    {
        sqlSession.delete("mapper.deleteUserById", Id);
        sqlSession.commit();
    }

    public List<Trend> searchTrendByProfessorId(String Id)
    {
        return sqlSession.selectList("mapper.searchTrendByProfessorId", Id);
    }

    protected void finalize()
    {
        sqlSession.close();
    }
}
