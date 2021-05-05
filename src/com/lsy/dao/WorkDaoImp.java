package com.lsy.dao;

import com.lsy.bean.Edu;
import com.lsy.bean.User;
import com.lsy.bean.Work;
import com.lsy.util.DBUtil;

import java.sql.*;

/**
 * @ClassName WorkDaoImp
 * @Description 工作经历信息数据访问层
 * @date 2021/5/4 14:38
 * @Param
 * @return
 */
public class WorkDaoImp implements BaseDao<Work> {

    // 数据库操作语句
    private static final String SQL_INSERT = "insert into kkb_work(userid,start,end,company,job,description) values(?,?,?,?,?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from kkb_work where userid=? order by start";

    @Override
    public int insert(Work work){

        // 1. 建立数据库连接conn
        Connection conn = DBUtil.getConn();

        // 2. 创建sql执行环境：state，并预编译SQL
        PreparedStatement state = null;
        ResultSet resultSte = null;
        try {
            // 3. 向执行环境中，填充？所表示的参数
            state = conn.prepareStatement(SQL_INSERT);
            state.setInt(1,work.getUserId());
            state.setString(2,work.getStart());
            state.setString(3,work.getEnd());
            state.setString(4,work.getCompany());
            state.setString(5,work.getJob());
            state.setString(6, work.getDescription());

            // 4.执行sql
            int row = state.executeUpdate();

            // 5.将新增的用户的标识（row），作为此段代码的执行结果 返回
            return row>0?row:-1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 6. 断开连接
            DBUtil.close(conn,state,resultSte);
        }
        return -1;
    }

    @Override
    public Work findByUserId(int userId){
        Connection conn = DBUtil.getConn();
        PreparedStatement state = null;
        ResultSet resultSte = null;
        Work work = null;
        try {
            state = conn.prepareStatement(SQL_FIND_BY_USERID);
            state.setInt(1,userId);
            resultSte = state.executeQuery();
            while(resultSte.next()){
                if(work != null){
                    Work temp = new Work();
                    temp.setNext(work);
                    work = temp;
                }else{
                    work = new Work();
                }
                int id = resultSte.getInt("id");
                String start = resultSte.getString("start");
                String  end = resultSte.getString("end");
                String company = resultSte.getString("company");
                String job = resultSte.getString("job");
                String description = resultSte.getString("description");
                work.setId(id);
                work.setStart(start);
                work.setEnd(end);
                work.setCompany(company);
                work.setJob(job);
                work.setDescription(description);
                work.setUserId(userId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(conn,state,resultSte);
        }
        return work;
    }
}

