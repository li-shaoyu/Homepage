package com.lsy.dao;

import com.lsy.bean.User;
import com.lsy.util.DBUtil;

import java.sql.*;

/**
 * @ClassName UserDao
 * @Description 用户基本信息信息数据访问层
 * @date 2021/5/1 14:52
 * @Param
 * @return
 */
public class UserDaoImp implements BaseDao<User> {

    // 用于操作数据库存储的sql
    private static final String SQL_INSERT = "insert into " +
            "kkb_user(name,age,city,address,email,phone,niuke,github,CSDN,sex,description) " +
            "values(?,?,?,?,?,?,?,?,?,?,?)";

    // 用于操作数据库获取用户基本信息的sql
    private static final String SQL_FIND_BY_USERID = "select * from kkb_user where id=?";

    @Override
    public int insert(User user) {
        // 1. 获取数据库的连接 ： conn
        Connection conn =  DBUtil.getConn();

        // 2. 通过连接 conn 创建执行sql语句的环境： statemet, 并预编译SQL
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            // 3. 向执行环境中，填充？所表示的参数
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getCity());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getniuke());
            statement.setString(8, user.getgithub());
            statement.setString(9, user.getCSDN());
            statement.setString(10, user.getSex());
            statement.setString(11, user.getDescription());

            // 4. 执行SQL
            statement.executeLargeUpdate();

            // 5. 获取新增的用户的ID
            result = statement.getGeneratedKeys();
            if (result.next()) {
                // 6. 将新增的用户的标识（id），作为此段代码的执行结果 返回
                return result.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            // 7.把连接释放
            DBUtil.close(conn,statement,result);
        }
        return -1;
    }

    @Override
    public User findByUserId(int userId) {
        // 1. 获取数据库的连接 ： conn
        Connection conn = DBUtil.getConn();

        // 2. 通过连接 conn 创建执行sql语句的环境： statemet, 并预编译SQL
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = conn.prepareStatement(SQL_FIND_BY_USERID);
            // 3. 向执行环境中，填充？所表示的参数
            statement.setInt(1,userId);

            // 4. 执行SQL, 并获取执行的结果集
            result = statement.executeQuery();

            // 5. 取出结果集中的用户的各个信息，组装成一个user
            if (result.next()) {
                int age = result.getInt("age");
                String name = result.getString("name");
                String city = result.getString("city");
                String address = result.getString("address");
                String email = result.getString("email");
                String phone = result.getString("phone");
                String niuke = result.getString("niuke");
                String github = result.getString("github");
                String CSDN = result.getString("CSDN");
                String sex = result.getString("sex");
                String description = result.getString("description");

                User user = new User(userId, name, age, city, address, email, phone, niuke, github, CSDN, sex, description);

                // 6. 将组装完毕的user，作为此段代码的执行结果，返回给调用者
                return user;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            // 7. 释放资源
            DBUtil.close(conn,statement,result);
        }

        return null;
    }
}
