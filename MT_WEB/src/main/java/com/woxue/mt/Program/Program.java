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

            //高级搜索论文（标旗、作者、关键词、年份），显示区间 [limitStart, limitEnd)
            {
                List<String> titles = new ArrayList<>(Arrays.asList("slow"));
                List<String> authors = new ArrayList<>(Arrays.asList("Lei", "Chen"));
                List<String> keywords = null;   //为null时，代表匹配内容任意
                String yearStart = "2010";
                String yearEnd = "2020";
                SqlDealer.Order order = SqlDealer.Order.REFERENCE_COUNT;
                int limitStart = 0; //从0开始
                int limitEnd = 5;   //此时检索区间为[0,5)
                List<Thesis> theses = sqlDealer.advancedSearchThesisAnd(titles, authors, keywords, yearStart, yearEnd, order, limitStart, limitEnd);
                for (Thesis thesis : theses)
                    thesis.display();
            }

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
