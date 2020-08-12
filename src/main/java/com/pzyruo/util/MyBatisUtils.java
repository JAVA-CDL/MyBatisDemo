package com.pzyruo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory factory = null;
    static {
        //定义myBatis主配置文件，从类的根路径开始
        String config = "mybatis.xml";
        //2.读取这个文件
        try {
            InputStream in = Resources.getResourceAsStream(config);
             factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (factory != null){
            sqlSession = factory.openSession(true);
        }
        return sqlSession;
    }
}
