package com.lsy.dao;

import com.lsy.bean.Edu;
import com.lsy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName EduDaoImp
 * @Description 教育信息数据访问层
 * @date 2021/5/5 17:20
 * @Param
 * @return
 */
public class EduDaoImp implements BaseDao<Edu> {
    // 数据库操作语句
    private static final String SQL_INSERT = "insert into " +
            "kkb_edu(userid,start,end,school,study,description) values(?,?,?,?,?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from kkb_edu where userid=? order by start";

    @Override
    public int insert(Edu edu) {
        // 1. 建立数据库连接
        Connection conn = DBUtil.getConn();

        // 2. 通过连接conn 创建执行sql语句的环境： statement，并编译SQL
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.prepareStatement(SQL_INSERT);
            // 3. 向执行环境中，填充？所表示的参数
            statement.setInt(1, edu.getUserId());
            statement.setString(2, edu.getStart());
            statement.setString(3, edu.getEnd());
            statement.setString(4, edu.getSchool());
            statement.setString(5, edu.getStudy());
            statement.setString(6, edu.getDescription());

            // 4. 执行sql语句
            int row = statement.executeUpdate();

            // 5. 将新增的用户的标识（row），作为此段代码的执行结果 返回
            return row > 0 ? row : -1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            // 关闭连接，释放资源
            DBUtil.close(conn,statement,resultSet);
        }
        return -1;
    }

    @Override
    public Edu findByUserId(int userId){
        Connection conn = DBUtil.getConn();
        PreparedStatement state = null;
        ResultSet resultSte = null;
        Edu edu = null;
        try {
            state = conn.prepareStatement(SQL_FIND_BY_USERID);
            state.setInt(1,userId);
            resultSte = state.executeQuery();
            while(resultSte.next()){
                if(edu != null){
                    Edu temp = new Edu();
                    temp.setNext(edu);
                    edu = temp;
                }else{
                    edu = new Edu();
                }
                int id = resultSte.getInt("id");
                String start = resultSte.getString("start");
                String end = resultSte.getString("end");
                String school = resultSte.getString("school");
                String study = resultSte.getString("study");
                String description = resultSte.getString("description");
                edu.setId(id);
                edu.setStart(start);
                edu.setEnd(end);
                edu.setSchool(school);
                edu.setStudy(study);
                edu.setDescription(description);
                edu.setUserId(userId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(conn,state,resultSte);
        }
        return edu;
    }
}
