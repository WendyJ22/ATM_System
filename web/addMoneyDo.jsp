<%@ page import="com.bjpowernode.baen.ATM" %>
<%@ page import="com.bjpowernode.dao.ATMDao" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/24
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>addMoneyDo</title>
    </head>
    <body>
        <%
            // 获取用户对象
            ATM user = (ATM)session.getAttribute("user");
            ATMDao atmDao = new ATMDao();
            // 获取卡号
            String atmCode = user.getAtmCode();
            // 获取当前金额
            double atmMoney = atmDao.queryMoney(atmCode);

            // 获取用户添加的金额
            double money = Double.valueOf(request.getParameter("money"));
            // 创建数据库的操作对象
            boolean b = atmDao.addMoney(atmCode, atmMoney, money);
            // 判断
            if(b) {
        %>
            <h1 style="color: red">存款成功！</h1>
        <%
            }
        %>
    </body>
</html>
