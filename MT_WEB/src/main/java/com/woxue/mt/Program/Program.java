package com.woxue.mt.Program;

import com.woxue.mt.sqldealer.Professor;
import com.woxue.mt.sqldealer.SqlDealer;
import com.woxue.mt.sqldealer.Thesis;
import com.woxue.mt.sqldealer.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program
{
    public static void main(String[] args)
    {
        try
        {
            SqlDealer sqlDealer = new SqlDealer();

            List<String> keywords = new ArrayList<String>(Arrays.asList("slow", "OCTAHEDRAL"));

            //根据关键词搜索论文
            {
                List<Thesis> theses;
                theses = sqlDealer.searchThesisAnd(keywords);  //与
                theses = sqlDealer.searchThesisOr(keywords);   //或
                for (Thesis thesis : theses)
                    thesis.display();
            }

            //更新科技专家（根据科技专家ID）
            {
                Professor professor = new Professor();
                professor.id = "test";
                sqlDealer.updateProfessor(professor);
            }

            //科技专家（limit：显示数量）
            {
                List<Professor> professors = sqlDealer.searchProfessor(1);
                for (Professor professor : professors)
                    professor.display();
            }

            //所有科技专家数量
            {
                int countProfessor = sqlDealer.countProfessor();
                System.out.println("--科技专家数量--\n" + countProfessor);
            }

            //插入用户
            {
                User user = new User();
                user.id = "test";
                user.nickname = "A";
                user.password = "123";
                sqlDealer.insertUser(user);
            }

            //更新用户（根据用户ID）
            {
                User user = new User();
                user.id = "test";
                user.nickname = "B";
                user.password = "456";
                sqlDealer.updateUser(user);
            }

            //所有用户
            {
                List<User> users = sqlDealer.searchUser();
                for (User user : users)
                    user.display();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
