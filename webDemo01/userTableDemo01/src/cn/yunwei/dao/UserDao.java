package cn.yunwei.dao;

import cn.yunwei.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<User> findAll();
    public User findUserByUserNameAndPassword(String userName,String password);

    int findTotalCount(Map<String,String[]> conditionMap);

    List<User> queryUserByPage(int currentPage, int rows,Map<String,String[]> conditionMap);
    int addUser(User user);
    int deleteUser(String id);
}
