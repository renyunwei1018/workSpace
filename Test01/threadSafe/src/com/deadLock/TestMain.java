package com.deadLock;

public class TestMain {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new MyThread(o1,o2);
        t1.start();
        Thread t2 = new MyThread2(o1,o2);
        t2.start();
    }
}
