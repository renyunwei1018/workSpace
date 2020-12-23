package org.example;

import com.test01.Util;
import com.test01.dao.StudentDao;
import com.test01.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myTest {
    @Test
    public void test01(){
        //mybatis提供的动态代理方法，不需要实现dao接口
        //namespace可以通过接口的全限定类名得到
        //id即是执行的接口方法,以上两步可以获取到完整的sqlSession
        //执行的sqlSession的crud可以通过id所对应的执行标签来决定，使用动态代理生成一个临时对象来执行
        StudentDao mapper = Util.sqlSession.getMapper(StudentDao.class);
        List<Student> list = mapper.queryAll();
        for(Student stu : list){
            System.out.println(stu);
        }
    }
    //使用类对象作为传入参数
    @Test
    public void test02(){
        StudentDao mapper = Util.sqlSession.getMapper(StudentDao.class);
        mapper.addStu(new Student(2,65,"黄忠","huangzhong@sanguo.com"));
        Util.sqlSession.commit();
    }

    @Test
    public void test03(){
        StudentDao mapper = Util.sqlSession.getMapper(StudentDao.class);
        List<Student> list = mapper.selectById(12);
        for(Student stu:list){
            System.out.println(stu);
        }
    }

    //@Param方式传入多个基础数据类型或者String类型

    /**
     * 1、另外可以使用map方法传值，映射文件中使用key值作为占位符来接收
     * 2、也可以通过参数位置传值，映射文件中使用arg0，args1..来接收
     * 3、使用对象传值，映射文件中占位符可以是对象的属性名称
     *
     */
    @Test
    public void test04(){
        StudentDao mapper = Util.sqlSession.getMapper(StudentDao.class);
        List<Student> list = mapper.selectMulitParam("赵云", 26);
        for (Student student : list){
            System.out.println(student);
        }
    }

}
