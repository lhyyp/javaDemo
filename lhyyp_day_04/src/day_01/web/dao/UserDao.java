package day_01.web.dao;

import day_01.web.domain.User;
import day_01.web.unitls.Druid;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid.getDataSource());



    public User login(User loginUser){
        try{
            String sql = "select * from login where name=? and password =?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getName(), loginUser.getPassword());
            return user;
        }catch (Exception e){
            return null;
        }





    }
}
