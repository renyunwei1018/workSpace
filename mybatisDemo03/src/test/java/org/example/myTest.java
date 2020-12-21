package org.example;

import com.test01.dao.StudentDao;
import com.test01.domain.Student;
import com.test01.impl.StudentImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myTest {
    @org.junit.Test
    public void test01() throws IOException {
        //访问mybatis读取student的信息
        //定义mybatis著配置文件的名称
        String config="mybatis.xml";
        //读取config表示的文件
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        //指定执行的sql语句规则：映射文件中的namespace+"."+标签id
        String id = "com.test01.dao.StudentDao"+"."+"addStu";
        Student student = new Student(12,28,"赵云","zzl@sanguo.com");
        //在执行Dml之后需要手动提交事务
        int insert = sqlSession.insert(id, student);
        sqlSession.commit();
        System.out.println(insert);
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
        String id = "com.test01.dao.StudentDao"+"."+"queryAll";
        List<Student> list = sqlSession.selectList(id);
        for (Student stu:list) {
            System.out.println(stu);
        }
    }
    @Test
    public void tes03(){
        StudentDao studentDao = new StudentImpl();
        int stu = studentDao.addStu(new Student(13, 25, "阿斗", "liuchan@sanguo.com"));
        System.out.println(stu);
    }
    @Test
    public void test04(){
        //dao全限定名称即是命名空间名称
        //dao方法即是id
        //执行insert/select/delete/uptate靠标签
        //mybatis动态代理，通过以上方法进行代理，这样就不需要写实现类了。
        StudentDao studentDao = new StudentImpl();
        List<Student> list = studentDao.queryAll();
        for (Student stu:list) {
            System.out.println(stu);
        }
    }

}
