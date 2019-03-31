package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static Connection conn() {
        //定义地址
        String url = "jdbc:mysql://127.0.0.1:3306/webtest?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8";
        //定义连接初始值
        Connection connection = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection(url, "root", "zzzzzz");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connection;

    }

}

