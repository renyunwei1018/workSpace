package com.test.day02;

public class YellowPeople extends People implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
