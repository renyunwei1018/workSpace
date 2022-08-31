package cn.yunwei.service.impl;

import cn.yunwei.dao.UserDao;
import cn.yunwei.dao.impl.UserDaoImpl;
import cn.yunwei.domain.PageBean;
import cn.yunwei.domain.User;
import cn.yunwei.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    /*查找所有用户*/
    @Override
    public List<User> findAll() {
        //1.use dao to operate database
        UserDao userDao = new UserDaoImpl();
        List<User> users = userDao.findAll();
        return users;
    }


    /*分页查找用户*/
    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows, Map<String,String[]> conditionMap) {
        //1.current page
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrentPage(currentPage);
        //2.page rows
        pageBean.setRows(rows);
        //3.total count
        UserDao dao = new UserDaoImpl();
        int totalCount = dao.findTotalCount(conditionMap);
        pageBean.setTotalCount(totalCount);
        //4.data list
        List<User> list = dao.queryUserByPage(currentPage,rows,conditionMap);
        pageBean.setList(list);
        //5.page count
        int pageCount = totalCount%rows == 0 ? totalCount/rows : totalCount/rows + 1;
        pageBean.setTotalPage(pageCount);
        return pageBean;
    }
    /*添加用户*/
    @Override
    public int addUser(User user) {
        UserDao userDao =new UserDaoImpl();
        int i = userDao.addUser(user);
        return i;
    }
    /*根据id删除用户*/
    @Override
    public int deleteUser(String id) {
        UserDao userDao = new UserDaoImpl();
        return userDao.deleteUser(id);
    }
    /*根据用户id更新用户*/

    @Override
    public int updateUser(String id, User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.updateUser(id, user);
    }
}
