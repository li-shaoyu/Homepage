package com.lsy.dao;

import com.lsy.bean.Skill;
import com.lsy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName SkillDaoImp
 * @Description 技能信息数据访问层
 * @date 2021/5/4 14:37
 * @Param
 * @return
 */
public class SkillDaoImp implements BaseDao<Skill> {

    // 数据库操作语句
    private static final String SQL_INSERT = "insert into kkb_skill(userid,keywords) values(?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from kkb_skill where userid=?";

    @Override
    public int insert(Skill skill) {
        // 1. 建立数据库连接：conn
        Connection conn = DBUtil.getConn();

        // 2. 创建sql执行环境：state，并编译sql语句
        PreparedStatement state = null;
        ResultSet resultSte = null;
        try {
            // 3. 向执行环境中，填充？所表示的参数
            state = conn.prepareStatement(SQL_INSERT);
            state.setInt(1, skill.getUserId());
            state.setString(2, skill.getKeyWords());

            // 4. 执行SQL
            int row = state.executeUpdate();

            // 5. 将新增的用户的标识（row），作为此段代码的执行结果 返回
            return row > 0 ? row : -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 6.把连接释放
            DBUtil.close(conn, state, resultSte);
        }
        return -1;
    }

    @Override
    public Skill findByUserId(int userId){
        Connection conn = DBUtil.getConn();
        PreparedStatement state = null;
        ResultSet resultSte = null;
        Skill skill = null;
        try {
            state = conn.prepareStatement(SQL_FIND_BY_USERID);
            state.setInt(1,userId);
            resultSte = state.executeQuery();
            if(resultSte.next()){
                int id = resultSte.getInt("id");
                String keywords = resultSte.getString("keywords");
                skill = new Skill(id,userId,keywords);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(conn,state,resultSte);
        }
        return skill;
    }
}

