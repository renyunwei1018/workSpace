package com.test.day01;

/**
 * 用户类
 */
public class User {

    private String name;
    private int age;

    public User(){
    }

    /**
     * 构造方法创建
     * @param name 名字
     * @param age 年龄
     */
    public User(String name,int age){
        this.age=age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
