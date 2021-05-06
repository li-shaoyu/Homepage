package com.lsy.dao;

import com.lsy.bean.Result;
import com.lsy.bean.Specialty;
import com.lsy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName SpecialtyDaoImp
 * @Description 特长信息数据访问层
 * @date 2021/5/5 11:34
 * @Param
 * @return
 */
public class SpecialtyDaoImp implements BaseDao<Specialty> {

    // 数据库操作语句,注意换行时into后面的空格，test时出现了SQL语句异常
    private static final String SQL_INSERT = "insert into " +
            "kkb_specialty(userid,name,description) values(?,?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from kkb_specialty where userid=?";


    @Override
    public int insert(Specialty specialty) {
        // 1.  获取数据库的连接 ： conn
        Connection conn = DBUtil.getConn();

        // 2. 通过连接 conn 创建执行sql语句的环境： statemet, 并预编译SQL
        PreparedStatement state = null;
        ResultSet resultSet = null;

        try {
            // 3. 向执行环境中，填充？所表示的参数
            state = conn.prepareStatement(SQL_INSERT);
            state.setInt(1, specialty.getUserId());
            state.setString(2, specialty.getName());
            state.setString(3, specialty.getDescription());

            // 4. 执行SQL
            int row = state.executeUpdate();

            // 5. 将新增的用户的标识（row），作为此段代码的执行结果 返回
            return row > 0 ? row : -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 6.把连接释放
            DBUtil.close(conn, state, resultSet);
        }
        return -1;
    }

    @Override
    public Specialty findByUserId(int userId) {
        // 1. 建立数据库连接
        Connection conn = DBUtil.getConn();

        // 2. 创建sql执行环境：state，并编译语句
        PreparedStatement state = null;
        ResultSet resultSte = null;
        Specialty specialty = null;
        try {
            // 3. 填充？
            state = conn.prepareStatement(SQL_FIND_BY_USERID);
            state.setInt(1, userId);

            // 4. 执行sql
            resultSte = state.executeQuery();
            while (resultSte.next()) {
                if (specialty != null) {
                    Specialty temp = new Specialty();
                    temp.setNext(specialty);
                    specialty = temp;
                } else {
                    specialty = new Specialty();
                }
                int id = resultSte.getInt("id");
                String name = resultSte.getString("name");
                String description = resultSte.getString("description");
                specialty.setId(id);
                specialty.setName(name);
                specialty.setDescription(description);
                specialty.setUserId(userId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(conn, state, resultSte);
        }
        return specialty;
    }
}
