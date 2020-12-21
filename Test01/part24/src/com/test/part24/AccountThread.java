package com.test.part24;

public class AccountThread extends Thread {

    private Account account;
    private double money;
    public AccountThread(Account account,double money) {
        this.account = account;
        this.money=money;
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("t1")){
            account.takeMoney(money);
        }else {
            try {
                account.doSome();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
