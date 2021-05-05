package com.lsy.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author lsy
 * @description:  数据库连接工具
 * @date: 2021/5/1 14:36
 * @param:  null
 * @return:
 * @version 1.0
 */
public class DBUtil {
    // 操作数据库的三要素
    private static String url = "";
    private static String user = "";
    private static String password = "";

    public DBUtil() {
    }

    /**
     * @author lsy
     * @description:  用于链接数据库，得到的结果是数据库的连接对象，连接对象具备了操作数据库的很多功能
     * @date: 2021/5/1 14:39
     * @param:
     * @return:  连接对象
     * @version 1.0
     */
    public static Connection getConn() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException var1) {
            var1.printStackTrace();
            return null;
        }
    }

    /**
     * @author lsy
     * @description:  断开数据库资源的链接，用于释放资源
     * @date: 2021/5/1 14:41
     * @param:  conn  要释放的链接
     *          statement  要释放的执行环境
     *          resultSet  要释放的结果集
     * @version 1.0
     *
     * 连接原则： 尽可能晚的连接数据库，尽可能早的释放资源
     */
    public static void close(Connection conn, Statement statement, ResultSet resultSet) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException var6) {
                var6.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException var5) {
                var5.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException var4) {
                var4.printStackTrace();
            }
        }

    }

    // 加载配置文件，获取文件中的三要素
    static {
        Properties ppt = new Properties();
        InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            ppt.load(is);
            url = ppt.getProperty("url");
            user = ppt.getProperty("user");
            password = ppt.getProperty("password");
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException var3) {
            var3.printStackTrace();
        }

    }
}
