package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库工具类
 */
public class DBUtils {

    private static DataSource dataSource;

    static {

        try {
            /**
             * 创建数据库连接池
             */
            Properties properties = new Properties();
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        return dataSource.getConnection();
    }

}
