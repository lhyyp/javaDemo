package day_01.web.test;

import day_01.web.dao.UserDao;
import day_01.web.domain.User;
import jdk.jfr.StackTrace;
import org.junit.Test;

public class LoginTest {
    @Test
    public void loginTest(){
        User user = new User();
        user.setName("lhyyp");
        user.setPassword("123456");
        User login = new UserDao().login(user);
        System.out.println(login);
    }
}
