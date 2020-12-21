package com.test.part24;

public class Tested {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.setName("mm");
        t.sleep(10000);
        t.interrupt();
        System.out.println(t.getName());


    }

}
class MyThread extends Thread{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("分支"+i);
        }
    }
}