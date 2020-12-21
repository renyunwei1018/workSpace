package com.deadLock;

public class MyThread extends Thread{

    private Object o1;
    private Object o2;
    public MyThread(Object o1,Object o2){
        this.o1=o1;
        this.o2=o2;
    }
    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }
    }
}
class MyThread2 extends Thread{

    public MyThread2(Object o1,Object o2){
        this.o1=o1;
        this.o2=o2;
    }
    private Object o1;
    private Object o2;
    @Override
    public void run() {
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){

            }
        }
    }
}
