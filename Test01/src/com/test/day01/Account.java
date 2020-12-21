package com.test.day01;

/**
 *  银行账户类
 * @author RenYunWei
 */
public class Account {

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public String getYue() {
        return yue;
    }

    public Account() {
    }
    public Account(String yue){
        this.yue=yue;
    }
    public void setYue(String yue) {
        this.yue = yue;
    }

    @Override
    public String toString() {
        return "Account{" +
                "actNo='" + actNo + '\'' +
                ", yue='" + yue + '\'' +
                '}';
    }

    private String actNo;
    private String yue;
}
