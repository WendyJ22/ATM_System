<%@ page import="com.bjpowernode.baen.ATM" %>
<%@ page import="com.bjpowernode.dao.ATMDao" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/23
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>quKuanDo</title>
    </head>
    <body>
        <%
            // 获取取款金额
            double money = Double.valueOf(request.getParameter("money"));
            // 获取用户信息
            ATM user = (ATM)session.getAttribute("user");
            // 判断金额是否足够
            if(user.getAtmMoney() > money) {
                // 取款
                ATMDao atmDao = new ATMDao();
                boolean b = atmDao.quKuan(user.getAtmCode(), user.getAtmMoney(), money);
                if(b) {
        %>
            <h1>成功取款<%=money%></h1>
        <%
                }
            }else{
        %>
        <h1 style="color: red">穷鬼，你钱不够！！</h1>
        <%
            }
        %>
    </body>
</html>
