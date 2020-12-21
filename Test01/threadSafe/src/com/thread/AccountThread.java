package com.thread;

public class AccountThread extends Thread {

    private Account account;
    private double money;
    public AccountThread(Account account,double money){
        this.account=account;
        this.money=money;
    }
    @Override
    public void run() {
//        try {
//            account.withDraw(money);
//        } catch (InterruptedException | MoneyNotFountException e) {
//            e.printStackTrace();
//        }
        if (currentThread().getName()=="t1"){
            Account.doSome();
        }
        if (currentThread().getName()=="t2"){
            account.doOther();
        }
    }
}
