package com.bjpowernode.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    void setAttribute(String key , Object value) ; 保存数据
    Object getAttribute(String key) ;  获取数据 ,getAttribute方法只能获取使用setAttribute方法放入的数据。
    void removeAttribute(String name);删除指定的数据
 */
public class Demo01_SendServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 将数据保存到预定义对象中
        request.setAttribute("name","吴迪");
        request.setAttribute("age", 22);
        // 将数据转发
        request.getRequestDispatcher("receive.jsp").forward(request,response);
    }
}
