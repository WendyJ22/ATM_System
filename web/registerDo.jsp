<%@ page import="java.util.Random" %>
<%@ page import="com.bjpowernode.dao.ATMDao" %>
<%@ page import="com.bjpowernode.baen.ATM" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/23
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>registerDo</title>
    </head>
    <body>
        <%
            // 设置编码表
            request.setCharacterEncoding("utf-8");
            // 接收参数
            String atmName = request.getParameter("atmName");
            String atmPwd = request.getParameter("atmPwd");

            // 默认卡号666开头，后面加3位随机数
            Random random = new Random();
            // 创建数据库的连接对象
            ATMDao atmDao = new ATMDao();
            String code = "666";
            while (true) {
                int num = random.nextInt(900) + 100;
                code += num;
                // 判断卡号是否存在
                boolean checkCode = atmDao.checkCode(code);
                if(checkCode) {
                    // 卡号不存在 可以注册
                    break;
                }
            }
            // 创建ATM对象
            ATM atm = new ATM();
            atm.setAtmCode(code);
            atm.setAtmName(atmName);
            atm.setAtmPwd(atmPwd);
            atm.setAtmMoney(0);
            // 调用注册的方法  传递ATM对象 注册账号
            boolean b = atmDao.atmRegister(atm);
            if(b) {
        %>
            <h1>恭喜您，注册成功，您的卡号是：<%=code%></h1>
            <a href="login.jsp">立即登录</a>
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">返回继续注册</a>
        <%
            }else{
        %>
            <h1>注册失败，请重新<a href="register.jsp">注册</a></h1>
        <%
            }
        %>
    </body>
</html>
