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
public class Demo02_ReceiveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收demo01传递的数据
        Object name = request.getAttribute("name");
        String str_name = (String)name;
        Object age = request.getAttribute("age");
        int int_age = (int)age;
        System.out.println("demo01转发的数据：" + str_name + ".." + int_age);
    }
}
