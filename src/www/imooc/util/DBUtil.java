package www.imooc.util;

import java.sql.*;

/**
 * Created by iShu on 16/5/23.
 */
public class DBUtil {

    private static final String user = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/mytest";
    private static Connection conn;
    private static Statement stat;

    /**
     * 连接数据库
     */
    public static Connection getConnection() {
        try {
            // 1, 加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 2, 获取数据库连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接的资源
     */
    public void close() {
            try {
                if (conn != null)
                    conn.close();
                if (stat != null)
                    stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static Statement getStatment() {
        conn = getConnection();
        try {
            stat = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stat;
    }
}
