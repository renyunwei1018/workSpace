package cn.yunwei.dao.impl;

import cn.yunwei.dao.UserDao;
import cn.yunwei.domain.User;
import cn.yunwei.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;



public class UserDaoImpl implements UserDao {
    private DataSource dataSource = JDBCUtils.getDataSource();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    @Override
    public List<User> findAll() {
        //1.operate database
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUserNameAndPassword(String userName, String password) {
        String sql = "select * from user where userName=? and password=?";
        List<User> userList = jdbcTemplate.query(sql, new Object[]{userName, password}, new BeanPropertyRowMapper<User>(User.class));

        return userList.size()==1?userList.get(0):null;
    }

    @Override
    public int findTotalCount(Map<String,String[]> conditionMap) {
        String name = "";
        String email = "";
        String address = "";
        if (conditionMap!=null){
             name = StringUtils.isEmpty(conditionMap.get("name"))? "":conditionMap.get("name")[0];
             email = StringUtils.isEmpty(conditionMap.get("email"))?"":conditionMap.get("email")[0];
             address = StringUtils.isEmpty(conditionMap.get("address"))?"":conditionMap.get("address")[0];
        }

        String sql = "select count(id) from user where 1=1 ";
        if (!StringUtils.isEmpty(name)){
            sql = sql + "and name like '"+name+"%'";
        }
        if (!StringUtils.isEmpty(email)){
            sql = sql + "and email like '"+email+"%'";
        }
        if (!StringUtils.isEmpty(address)){
            sql = sql + "and address like '"+address +"%'";
        }
        int totalCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return totalCount;
    }

    @Override
    public List<User> queryUserByPage(int currentPage, int rows,Map<String,String[]> conditionMap) {
        String sql = "select * from user where 1=1 ";

        String name = "";
        String email = "";
        String address = "";
        String id = "";
        if (conditionMap!=null){
            id = StringUtils.isEmpty(conditionMap.get("id"))? "":conditionMap.get("id")[0];
            name = StringUtils.isEmpty(conditionMap.get("name"))? "":conditionMap.get("name")[0];
            email = StringUtils.isEmpty(conditionMap.get("email"))?"":conditionMap.get("email")[0];
            address = StringUtils.isEmpty(conditionMap.get("address"))?"":conditionMap.get("address")[0];
        }

        if (!StringUtils.isEmpty(name)){
            sql = sql + "and name like '"+name+"%'";
        }
        if (!StringUtils.isEmpty(email)){
            sql = sql + "and email like '"+email+"%'";
        }
        if (!StringUtils.isEmpty(address)){
            sql = sql + "and address like '"+address +"%'";
        }
        if (!StringUtils.isEmpty(id)){
            sql = sql + "and id = '"+id +"'";
        }
        System.out.println(sql);
        sql = sql + "limit ?,?";
        int startIndex = (currentPage-1)*rows;
        List<User> list = jdbcTemplate.query(sql, new Object[]{startIndex, rows}, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user(name,gender,age,address,QQ,email) value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1,user.getName());
                    ps.setString(2,user.getGender());
                    ps.setInt(3,user.getAge());
                    ps.setString(4,user.getAddress());
                    ps.setString(5,user.getQQ());
                    ps.setString(6,user.getEmail());
                    return ps;
                }
            },keyHolder);

            return keyHolder.getKey().intValue();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(String id) {
        String sql = "delete from user where id=?";
        System.out.println(sql + id);
        int update = jdbcTemplate.update(sql, id);
        return update;

    }

    @Override
    public int updateUser(String id, User user) {
        String sql ="update user set name=?,age=?,address=?,email=?,QQ=?,gender=? where id=?";
        int update = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(3, user.getAddress());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getQQ());
                preparedStatement.setString(6, user.getGender());
                preparedStatement.setInt(2, user.getAge());
                preparedStatement.setString(7, id);
            }

        });
        return update;
    }
}
