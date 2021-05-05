package com.lsy.controller;

import com.lsy.bean.Result;
import com.lsy.bean.Specialty;
import com.lsy.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lsy
 * @description:  特长信息控制层
 * @date: 2021/5/5 18:10
 * @param:  null
 * @return:
 * @version 1.0
 */

@WebServlet("/v1/specialty/insert")
public class SpecialtyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        // 2. 接收前端数据
        int userId = 0;
        String userIdText = request.getParameter("userid");  // 标记一下前端的userid
        if (userIdText != null) {
            try {
                userId = Integer.parseInt(userIdText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        // 3. 组装为bean
        Specialty specialty = new Specialty(userId, name, description);

        // 4. 传递给Service层
        int row = DBService.insertSpecialty(specialty);

        // 5. 根据service代码的执行结果，组装Result
        Result result = null;
        if (row > 0) {
            result = new Result(0, "特长新增成功");
        } else {
            result = new Result(-1, "特长新增失败");
        }

        // 6. 返回JSON格式数据给前端
        response.getWriter().append(result.toJSON());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
