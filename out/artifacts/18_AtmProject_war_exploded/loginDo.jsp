<%@ page import="com.bjpowernode.dao.ATMDao" %>
<%@ page import="com.bjpowernode.baen.ATM" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/23
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>loginDo</title>
    </head>
    <body>
        <%
            // 设置编码表
            request.setCharacterEncoding("utf-8");
            // 接收参数
            String atmCode = request.getParameter("atmCode");
            String atmPwd = request.getParameter("atmPwd");
            // 创建数据库对象
            ATMDao atmDao = new ATMDao();
            ATM atm = atmDao.atmLogin(atmCode, atmPwd);
            if( atm != null ) {
                // 将用户对象保存到域对象中
                session.setAttribute("user", atm);
         %>
            <h1 style="color: deeppink">登录成功，欢迎<%=atm.getAtmName()%>光临动力银行</h1>
            <a href="queryDo.jsp">查询余额</a>  &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="quKuan.jsp">取款</a>  &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="addMoney.jsp">存款</a>  &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="transferMoney.jsp">转账</a> &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="setPwd.jsp">修改密码</a> &nbsp;&nbsp;&nbsp;&nbsp;
        <%
            } else {
         %>
            <h1>账号或密码错误，请重新<a href="login.jsp">登录</a></h1>
        <%
            }
        %>
    </body>
</html>
