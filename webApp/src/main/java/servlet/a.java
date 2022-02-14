package servlet;

import java.util.ArrayList;
import java.util.List;

public class a {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread a = new MyThread();
            a.start();
        }


    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        List list = new ArrayList();
        while(true){
            int a = 1;
            list.add(a);

        }
    }
}