package com.test.part24;

import static java.lang.Thread.sleep;

public class StopThread {

    public static void main(String[] args) throws InterruptedException {
        MjyThread03 mjyThread03 = new MjyThread03();
        Thread t = new Thread(mjyThread03);
        t.start();
        sleep(5000);
        mjyThread03.run = false;
    }
}

class MjyThread03 implements Runnable {
    public boolean run = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (run) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("分支线程" + i);
            } else {
                System.out.println("分支线程终止");
                return;
            }
        }
    }
}
