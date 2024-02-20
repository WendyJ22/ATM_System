<%@ page import="com.bjpowernode.baen.ATM" %>
<%@ page import="com.bjpowernode.dao.ATMDao" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2023/4/24
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>setPwdDo</title>
    </head>
    <body>
        <%--
            修改密码：
                1.根据卡号修改
                2.原密码 ---> 验证是否正确
                3.新密码
        --%>
        <%
            // 设置编码格式
            request.setCharacterEncoding("utf-8");
            // 获取用户信息
            ATM user = (ATM)session.getAttribute("user");
            // 提供卡号
            String atmCode = user.getAtmCode();
            // 获取参数
            String pwd = request.getParameter("pwd");
            String newPwd1 = request.getParameter("newPwd1");
            String newPwd2 = request.getParameter("newPwd2");

            // 创建数据库操作对象
            ATMDao atmDao = new ATMDao();
            boolean b = atmDao.setPwd(atmCode, pwd, newPwd1, newPwd2);
            if(b) {
         %>
            修改成功！
        <%
            }else{
         %>
            修改失败！
        <%
            }
        %>
    </body>
</html>
