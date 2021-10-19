package cn.yunwei.service;

import cn.yunwei.domain.PageBean;
import cn.yunwei.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<User> findAll();

    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> conditionMap);

    int addUser(User user);

    int deleteUser(String id);
}
