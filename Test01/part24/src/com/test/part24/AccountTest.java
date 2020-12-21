package com.test.part24;

public class AccountTest {

    public static void main(String[] args) {
        Account a = new Account();
        a.setAno("ano-0001");
        a.setMoney(10000);

        Thread t1 = new AccountThread(a,5000);
        t1.setName("t1");
        Account a1 = new Account();
        a1.setAno("ano-0001");
        a1.setMoney(10000);
        Thread t2 = new AccountThread(a1,5000);
        t2.setName("t2");
        t2.start();
        t1.start();

    }
}
