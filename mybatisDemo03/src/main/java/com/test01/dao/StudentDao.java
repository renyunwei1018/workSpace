package com.test01.dao;

import com.test01.domain.Student;

import java.util.List;

//操作student的接口
public interface StudentDao {

    //查询,本方法对应一个sql的执行
    public List<Student> queryAll();

    //增加学生
    public int addStu(Student student);

}
