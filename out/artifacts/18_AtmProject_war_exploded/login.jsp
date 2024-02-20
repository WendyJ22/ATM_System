<%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/23
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>login</title>
    </head>
    <body>
    <center>
        <h1 style="color: deeppink">登录页面</h1>
        <form action="loginDo.jsp">
            卡号：<input type="text" name="atmCode"> <br />
            密码：<input type="password" name="atmPwd"> <br />
            <br />
            <input type="submit" value="登录">
        </form>
        <a href="register.jsp">没有账号，去注册</a>
    </center>
    </body>
</html>
