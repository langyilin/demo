package cn.cloudtogo.ide.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author nero
 * @create 2018-01-29 20:16
 **/
public class DBHelper {

    public static final String MYSQLHOST = "localhost";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";


    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper(String sql) {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(String.format("jdbc:mysql://%s:3306/mysql?useSSL=false",null == System.getenv().get("MYSQL_HOST")? MYSQLHOST:System.getenv().get("MYSQL_HOST")),
                    null == System.getenv().get("MYSQL_USER")?USER:System.getenv().get("MYSQL_USER"),
                    null == System.getenv().get("PWD")?PASSWORD:System.getenv().get("PWD"));
            pst = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
