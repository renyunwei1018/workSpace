package com.test.day01;

public class Date {

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public Date() {
        //重复调用构造方法，而不会重复创建对象,当前构造对象如下
        this(1970,1,1);
        //下面的代码会重复创建对象,且不会影响到整个无参构造方法的结果
//        new Date(1970,1,1);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int year;
    private int month;
    private int day;

}
