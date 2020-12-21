package com.test01;

import com.test01.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取student的信息
        //定义mybatis著配置文件的名称
        String config="mybatis.xml";
        //读取config表示的文件
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        //指定执行的sql语句规则：映射文件中的namespace+"."+标签id
        String id = "com.test01.dao.StudentDao"+"."+"queryAll";
        List<Student> students = sqlSession.selectList(id);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }
}
