package com.test.Day04;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {


    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("test.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.get("age"));
    }
}
