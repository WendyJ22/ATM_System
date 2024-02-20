<%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/24
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>setPwd</title>
    </head>
    <body>
        <form action="setPwdDo.jsp">
            原密码：<input type="text" name="pwd"> <br />
            新密码：<input type="text" name="newPwd1"> <br />
            确认密码：<input type="text" name="newPwd2"> <br />
            <input type="submit" value="确认修改">
        </form>
    </body>
</html>
