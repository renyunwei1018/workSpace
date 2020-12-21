package com.thread;

public class Account {

    private String actno;
    private double money;

    public Account() {
    }

    public Account(String actno, double money) {
        this.actno = actno;
        this.money = money;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 线程与同步   加锁当前锁锁住方法代码块。
     * 操作同同一个数据需要线程安全。
     * @param money
     * @throws InterruptedException
     */
    public synchronized static void withDraw(double money) throws InterruptedException, MoneyNotFountException {
//       double before = this.getMoney();
//       if (before==0){
//            throw new MoneyNotFountException("余额不足");
//       }
//       double after = before-money;
       Thread.sleep(2000);
//       this.setMoney(after);
       System.out.println("取款成功余");
    }

    public synchronized static void doSome(){
        System.out.println("doSome begin");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }
    public synchronized void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }
}
class account1 implements Runnable{

    @Override
    public void run() {

    }
}