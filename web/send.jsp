<%@ page import="com.bjpowernode.baen.ATM" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/23
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>send</title>
    </head>
    <body>
        <%
            // 给receive.jsp文件转发数据
            request.setAttribute("user",new ATM(1,"666888","123456","小李",1000));
            request.getRequestDispatcher("receive.jsp").forward(request,response);
        %>
    </body>
</html>
