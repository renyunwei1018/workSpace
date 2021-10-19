package dao;

import Utils.DBUtils;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作user表的类
 */
public class UserDao {


    private JdbcTemplate template = new JdbcTemplate(DBUtils.getDataSource());
    /**
     * 登录方法
     * @param loginUser 登录用户名和密码
     * @return 返回用户
     */
    public User login(User loginUser){
        try {

            String sql = "select * from user where user_name=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUser_name(),loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {

            e.printStackTrace();//后期会在这里记录日志
            return null;
        }

    }
}
