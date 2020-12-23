//package com.test01.impl;
//
//import com.test01.dao.StudentDao;
//import com.test01.domain.Student;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//public class StudentImpl implements StudentDao {
//    private static SqlSession sqlSession;
//
//    static {
//        try {
//            InputStream is = Resources.getResourceAsStream("mybatis.xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//            sqlSession = factory.openSession();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<Student> queryAll() {
//        String id = "com.test01.dao.StudentDao"+"."+"queryAll";
//        List<Student> stu = sqlSession.selectList(id);
//        sqlSession.close();
//        return stu;
//    }
//
//    @Override
//    public int addStu(Student student) {
//        String id = "com.test01.dao.StudentDao"+"."+"addStu";
//        int insert = sqlSession.insert(id, student);
//        sqlSession.commit();
//        sqlSession.close();
//        return insert;
//    }
//}
