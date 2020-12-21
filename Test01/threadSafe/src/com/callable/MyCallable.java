package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable {
    int a;
    int b;
    public MyCallable(int a,int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public Object call() throws Exception {
        Thread.sleep(5*1000);
        return a+b;
    }
}
class testMain{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask ft = new FutureTask(new MyCallable(10,20));
        Thread thread = new Thread(ft);
        thread.start();
        //get方法会强制等待callable线程执行完并得到返回，当前线程才会继续执行。
        System.out.println(ft.get());
        System.out.println("当前线程被get方法阻塞");
    }
}