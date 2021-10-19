package loginTest;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void test1(){

        UserDao userDao = new UserDao();
        User user = userDao.login(new User(1, "zhangsan1", "123456"));
        System.out.println(user);

    }
}
