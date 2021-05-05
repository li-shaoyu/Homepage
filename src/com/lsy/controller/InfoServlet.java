package com.lsy.controller;

import com.lsy.bean.Info;
import com.lsy.bean.Result;
import com.lsy.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lsy
 * @description:  个人简历控制层
 * @date: 2021/5/5 18:09
 * @param:  null
 * @return:
 * @version 1.0
 */

@WebServlet("/v1/info")
public class InfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

         // 2. 接收前端请求
        int userId = 0;
        String userIdText = request.getParameter("userid");
        if (userIdText != null) {
            try {
                userId = Integer.parseInt(userIdText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        // 3. 将用户编号传输给Service层进行代理处理
        Info info = DBService.find(userId);

        // 4.根据service代码的执行结果，组装Result
        Result result = null;
        if (info != null) {
            result = new Result(0, "查询成功", info);
        } else {
            result = new Result(-1, "查询失败，不存在");
        }

        // 5. 返回JSON格式数据给前端
        response.getWriter().append(result.toJSON());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
