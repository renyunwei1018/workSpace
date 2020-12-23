package com.test01.dao;

import com.test01.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//操作student的接口
public interface StudentDao {

    //查询,本方法对应一个sql的执行
    public List<Student> queryAll();

    //增加学生
    public int addStu(Student student);

    public List<Student> selectById(int id);

    //多个基础数据类型或String的参数使用@Param("别名")方式来识别
    public List<Student> selectMulitParam(@Param("myName") String name, @Param("myAge") int age);
}
