package com.lsy.controller;

import com.lsy.bean.Result;
import com.lsy.bean.Work;
import com.lsy.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lsy
 * @description:  工作经历信息控制层
 * @date: 2021/5/5 18:11
 * @param:  null
 * @return:
 * @version 1.0
 */

@WebServlet("/v1/work/insert")
public class WorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        // 2.接收前端数据
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
        String company = request.getParameter("company");
        String job = request.getParameter("job");
        String description = request.getParameter("description");

        // 3. 封装实体类bean
        Work work = new Work(userId, start, end, company, job, description);

        // 4. 交给Service层代理
        int row = DBService.insertWork(work);

        // 5. 根据service代码的执行结果，组装Result
        Result result = null;
        if (row > 0) {
            result = new Result(0, "工作经历新增成功");
        } else {
            result = new Result(-1, "工作经历新增失败");
        }

        // 6.返回JSON数据给前端
        response.getWriter().append(result.toJSON());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
