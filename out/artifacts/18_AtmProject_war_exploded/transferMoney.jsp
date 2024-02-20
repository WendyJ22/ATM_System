<%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/24
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>transferMoney</title>

    </head>
    <body>
        <form action="transferMoneyDo.jsp">
            请输入转账金额：<input type="text" name="money"> <br />
            请输入转账卡号：<input type="text" name="code"> <br />
            <input type="submit" value="确认转账">
        </form>
    </body>
</html>
