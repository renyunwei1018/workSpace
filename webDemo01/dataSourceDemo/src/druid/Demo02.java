package druid;

import druid.Util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            connection= DBUtils.getConnection();
//            connection.setAutoCommit(false);
//            String sql = "insert into tuser(id,age,name) Values(4,?,?)";
//            statement= connection.prepareStatement(sql);
//            statement.setInt(1,24);
//            statement.setString(2,"zhangsan");
//            statement.executeUpdate();
//            connection.commit();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }finally {
//            DBUtils.closeConnection(connection,statement);
//        }
        Demo02 demo02 = new Demo02();
        demo02.query();
    }

    public void query() throws SQLException {

        Connection connection = DBUtils.getConnection();
        connection.setAutoCommit(false);
        String sql = "select * from tuser where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,4);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            System.out.println(name);
        }



    }

}
