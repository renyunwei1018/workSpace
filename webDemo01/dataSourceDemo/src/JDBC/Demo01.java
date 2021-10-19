package JDBC;

import domain.User;
import druid.Util.DBUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Demo01 {

    public static void main(String[] args) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
        String sql = "select * from tuser where id=?";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql, 2);

        String sql2 = "update tuser set name =? ,age=? where id = ?";
        int update = jdbcTemplate.update(sql2, "关羽","8",1);
        System.out.println(update);

    }

    @Test
    public void test1(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
        jdbcTemplate.update("insert into tuser(name,age,id) values ('AKA燕小六','20','6')");
    }
    @Test
    public void test2(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
        jdbcTemplate.update("delete from tuser where id=?",1);
    }
    @Test
    public void test3(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tuser");
        System.out.println(maps);
    }
    @Test
    public void test4(){
        String sql = "select * from tuser";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
        List<User> maps = jdbcTemplate.query(sql, new BeanPropertyRowMapper< User >(User.class));

        for (int i = 0; i <maps.size() ; i++) {
            System.out.println(maps.get(i));
        }
    }
    @Test
    public void test5(){
        String sql = "select count(id) from tuser";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DBUtils.getDataSource());
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
    @Test
    public void test6(){
        String sql = "insert into tuser(id,name,age) values(1,'张飞',23)";
        JdbcTemplate template = new JdbcTemplate(DBUtils.getDataSource());
        template.update(sql);

    }
}
