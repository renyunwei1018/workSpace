package com.thread;

public class TestMain {

    public static void main(String[] args) {
        Account a = new Account("ano0001",2000);
        Account b = new Account("ano0002",21000);
        Thread t1 = new AccountThread(a,500);
        t1.setName("t1");
        t1.start();
        Thread t2 = new AccountThread(b,800);
        t2.setName("t2");
        t2.start();
    }
}
