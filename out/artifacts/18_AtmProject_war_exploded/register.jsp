<%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/23
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>register</title>
    </head>
    <body>
        <center>
            <h1 style="color: blue">注册页面</h1>
            <form action="registerDo.jsp">
                姓名：<input type="text" name="atmName"> <br />
                密码：<input type="password" name="atmPwd"> <br />
                <br >
                <input type="submit" value="提交注册">
            </form>
            <a href="login.jsp">已有账号，去登录</a>
        </center>
    </body>
</html>
