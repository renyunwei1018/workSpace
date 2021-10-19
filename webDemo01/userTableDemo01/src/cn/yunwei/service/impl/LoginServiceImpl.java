package cn.yunwei.service.impl;

import cn.yunwei.dao.UserDao;
import cn.yunwei.dao.impl.UserDaoImpl;
import cn.yunwei.domain.User;
import cn.yunwei.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public User login(String userName, String passWord) {
        //1.use dao to check login
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserByUserNameAndPassword(userName, passWord);
        return user;
    }
}
