package day_01.web.unitls;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Druid {
    public static DataSource ds;

    static {
        Properties pro = new Properties();
        InputStream is = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
