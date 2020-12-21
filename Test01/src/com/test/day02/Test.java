package com.test.day02;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
//        String s = "aa";
//        String s1 = new String("aa");
        YellowPeople yellowPeople = new YellowPeople();
        yellowPeople.setAge(10);

        YellowPeople yellowPeople1 = new YellowPeople();
        yellowPeople1.setAge(10);
        System.out.println(yellowPeople.equals(yellowPeople1));
        System.out.println(yellowPeople.hashCode());
//        Integer.toBinaryString();
//        String s = Integer.toHexString();
//        Integer.toOctalString()
//        System.out.println(yellowPeople.toString());
//        int[][] a = new int[3][];
//        List list = new ArrayList();
    }

}
