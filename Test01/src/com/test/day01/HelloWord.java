package com.test.day01;

public class HelloWord {

    public static void main(String[] args) {
//        System.out.println("Hello Word");
//
//        User user = new User();
//        System.out.println(user);
//        User user1 = new User("小明",7);
//        System.out.println(user1);
//
//        Account account = new Account("103");
//
//        int i = 20;
//        add(i);//输出21
//        System.out.println(i);//输出20
//        userTemp userTemp = new userTemp();
//
//        userTemp.age=15;
//        change(userTemp);//输出16
//        System.out.println(userTemp.age);//输出16

        Date date = new Date();
        System.out.println(date);

        HelloWord helloWord = new HelloWord();
        //static 方法也可以使用引用便变量来调用，但是使用中会使用类，而不是对象。
        //即，采用引用调用其内部逻辑依然是使用的类调用，所以引用变量即使为空依然能调用。
        helloWord.add(3);

    }

    public static void add(int i){
        i++;
        System.out.println(i);

    }
    public static void change(userTemp user){
        user.age++;
        System.out.println(user.age);
    }
}
class userTemp{
    int age;
}