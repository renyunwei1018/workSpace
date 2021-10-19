package cn.yunwei.service;

import cn.yunwei.domain.User;

public interface LoginService {

    public User login(String userName,String passWord);
}
