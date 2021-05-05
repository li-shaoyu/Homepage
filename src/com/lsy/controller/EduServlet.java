package com.lsy.controller;

import com.lsy.bean.Edu;
import com.lsy.bean.Result;
import com.lsy.service.DBService;
import com.lsy.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lsy
 * @description:  教育信息控制层
 * @date: 2021/5/5 18:08
 * @param:  null
 * @return:
 * @version 1.0
 */


@WebServlet("/v1/edu/insert")
public class EduServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置编码方式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        // 2. 接收前端数据
        int userId = 0;
        String userIdText = request.getParameter("userid");
        if (userIdText != null) {
            try {
                userId = Integer.parseInt(userIdText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String school = request.getParameter("school");
        String study = request.getParameter("study");
        String description = request.getParameter("description");

        // 3. 组装为bean
        Edu edu = new Edu(userId, start, end, school, study, description);

        // 4. 传输给Service层代理
        int row = DBService.insertEdu(edu);

        // 5.根据返回的结果（row），进行处理
        Result result = null;
        if (row > 0) {
            result = new Result(0, "学历增加成功");
        } else {
            result = new Result(0, "学历增加失败");
        }

        // 将结果转化为JSON格式数据返回给前端
        response.getWriter().append(result.toJSON());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
