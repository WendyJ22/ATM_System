<%@ page import="com.bjpowernode.baen.ATM" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/23
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>receive</title>
    </head>
    <body>
        <%
            /*// 接收数据
            String name = (String) request.getAttribute("name");
            int age = (int)request.getAttribute("age");
            System.out.println("这是我从Demo01接收的数据：" + name + "..." + age);*/

            // 接收send.jsp发送的数据
            Object user = request.getAttribute("user");
            ATM atmUser = (ATM)user;
            System.out.println("user = " + user);
            System.out.println("用户信息入下:");
            System.out.println(atmUser.getAtmName() + "..." +atmUser.getAtmMoney());
        %>
    </body>
</html>
