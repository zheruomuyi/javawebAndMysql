package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static Connection conn() {
        //�����ַ
        String url = "jdbc:mysql://127.0.0.1:3306/webtest?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8";
        //�������ӳ�ʼֵ
        Connection connection = null;
        try {
            //��������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��������
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

