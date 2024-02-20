<%@ page import="com.bjpowernode.baen.ATM" %>
<%@ page import="com.bjpowernode.dao.ATMDao" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/23
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>queryDo</title>
    </head>
    <body>
        <%
            // 获取用户对象
            ATM user = (ATM)session.getAttribute("user");
            // 获取用户的卡号
            String atmCode = user.getAtmCode();
            // 创建操作数据库对象
            ATMDao atmDao = new ATMDao();
            double money = atmDao.queryMoney(atmCode);
        %>
        当前余额为：<%=money%>
    </body>
</html>
