package com.test.part24;

public class Account {
    private String ano;
    private double money;

    public String getAno() {
        return ano;
    }

    public double getMoney() {
        return money;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public synchronized void takeMoney(double money) {

        System.out.println("对象锁");
        double before = this.money;
        double now = before - money;
        this.setMoney(now);
        System.out.println(Thread.currentThread().getName() + "" + now);

    }

    public synchronized static void doSome() throws InterruptedException {
        System.out.println("类锁");
        Thread.sleep(5000);
        System.out.println("类锁结束");
    }
}