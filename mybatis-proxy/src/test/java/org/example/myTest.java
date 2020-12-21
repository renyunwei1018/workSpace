package org.example;

import com.test01.Util;
import com.test01.dao.StudentDao;
import com.test01.domain.Student;
import com.test01.impl.StudentImpl;
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


}
