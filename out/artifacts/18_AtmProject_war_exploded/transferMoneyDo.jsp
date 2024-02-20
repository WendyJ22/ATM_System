<%@ page import="com.bjpowernode.baen.ATM" %>
<%@ page import="com.bjpowernode.dao.ATMDao" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/24
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>transferMoneyDo</title>
    </head>
    <body>
        <%--
            1.减去自己账号中的金额  自己的卡号  自己原有金额   转账的金额
            2.添加目标账号的金额    对方的卡号  对方的原有金额 转账的金额
        --%>
        <%
            // 解决乱码问题
            request.setCharacterEncoding("utf-8");
            // 获取转账中需要的参数
            ATM user = (ATM)session.getAttribute("user");
            ATMDao atmDao = new ATMDao();
            // 先获取自己的数据
            String atmCode = user.getAtmCode();
            double atmMoney = atmDao.queryMoney(atmCode);
            // 要转账的金额
            double money = Double.valueOf(request.getParameter("money"));
            // 获取目标的数据
            String targetCode = request.getParameter("code");
            double targetMoney = atmDao.queryMoney(targetCode);

            // 调用方法 转账
            boolean b = atmDao.transferMoney(atmCode, atmMoney, money, targetCode, targetMoney);
            if(b) {
        %>
        <h1>转账成功</h1>
        <%
            }else{
        %>
        <h1>转账失败</h1>
        <%
            }
        %>
    </body>
</html>
