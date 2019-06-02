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

            //根据论文ID搜索评论
            {
                String thesisId = "10.1002/ejic.2014029";
                List<Comment> l = sqlDealer.searchCommentByThesisId(thesisId);
                System.out.println(l.size());
            }

            //根据科技专家ID搜索论文
            {
                //根据科技专家ID搜索专家拥有论文
                String professorId = "CN-BF73U50J";
                int limitStart = 0;
                int limitEnd = 3;
                List<ProfessorOwnThesis> professorOwnTheses = sqlDealer.searchProfessorOwnThesisByProfessorId(professorId, limitStart, limitEnd);
                List<Thesis> theses = new ArrayList<>();
                for (ProfessorOwnThesis professorOwnThesis : professorOwnTheses)
                    professorOwnThesis.display();
                //根据论文ID搜索论文
                for (ProfessorOwnThesis professorOwnThesis : professorOwnTheses)
                {
                    Thesis thesis = sqlDealer.searchThesisById(professorOwnThesis.thesisId);
                    theses.add(thesis);
                }
                for (Thesis thesis : theses)
                    thesis.display();
            }

            //根据科技专家ID搜索关系网络
            {
                String professorId = "CN-BT74TVCJ";
                int limitStart = 0;
                int limitEnd = 2;
                List<Relationship> relationships = sqlDealer.searchRelationshipByProfessorId(professorId, limitStart, limitEnd);
                for (Relationship relationship : relationships)
                    relationship.display();
            }

            //高级搜索论文（标旗、作者、关键词、年份），显示区间 [limitStart, limitEnd)
//            {
//                List<String> titles = new ArrayList<>(Arrays.asList("slow"));
//                List<String> authors = new ArrayList<>(Arrays.asList("Lei", "Chen"));
//                List<String> keywords = null;   //为null时，代表匹配内容任意
//                String yearStart = "2010";
//                String yearEnd = "2020";
//                SqlDealer.Order order = SqlDealer.Order.REFERENCE_COUNT;
//                int limitStart = 0;
//                int limitEnd = 5;
//                List<Thesis> theses = sqlDealer.advancedSearchThesisAnd(titles, authors, keywords, yearStart, yearEnd, order, limitStart, limitEnd);
//                for (Thesis thesis : theses)
//                    thesis.display();
//            }

//            //搜索论文
//            {
//                List<String> keywords = new ArrayList<>(Arrays.asList("slow", "mag"));
//                SqlDealer.Order order = SqlDealer.Order.REFERENCE_COUNT;
//                int limitStart = 0;
//                int limitEnd = 20;
//                List<Thesis> theses = sqlDealer.searchThesisAnd(keywords, "2010", order, limitStart, limitEnd);
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
