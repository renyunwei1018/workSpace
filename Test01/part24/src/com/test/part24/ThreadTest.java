package com.test.part24;

public class ThreadTest {


    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                for (int i =0;i<100;i++){
                    System.out.println("1分支"+i);
                }
            }
        }.start();

     new Thread(new Runnable() {
         @Override
         public void run() {
             for (int i=1;i<100;i++){
                 System.out.println("2分支"+i);
             }
         }
     }).start();
     
        for (int i = 0;i<100;i++){
            System.out.println("主"+i);
        }
    }
}
