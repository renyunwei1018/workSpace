package com.deamThread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        SimpleDateFormat sd = new SimpleDateFormat("yy-MM-dd HH:mm:ss:sss");
        Date date = sd.parse("20-10-31 17:12:00:000");
        timer.schedule(new logTimerTask(),date,1000*10);
    }
}
class logTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("定时执行语句");
    }
}