package com.test.part24;

public class PriorityThread {

    //线程优先级
    //优先级高的线程不绝对有优先权，只是抢到cpu时间碎片的概率较高。
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        Thread thread = new Thread(new MyThread01());
        thread.setPriority(Thread.MAX_PRIORITY);
    }
}
class MyThread01 implements Runnable{
    @Override
    public void run() {

    }
}