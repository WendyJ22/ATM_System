package com.bjpowernode.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class El_Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        // 假设当前账号密码正确
        request.setAttribute("username", uname);
        request.setAttribute("userpwd", upwd);
        // 进入主页面
        request.getRequestDispatcher("main.jsp").forward(request, response);

    }
}
