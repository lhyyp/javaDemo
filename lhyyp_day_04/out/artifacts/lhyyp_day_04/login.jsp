<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 2019/11/11
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login">
    <label for="">
        用户名：<input type="text" name="name">
    </label>
    <br>
    <label for="">
        密码：<input type="text" name="password">
    </label>
    <br>
    图形验证码：
    <input type="text" name ="verify">
    <img src="${pageContext.request.contextPath}/verify" alt="">
    <br>
    <input type="submit" value="登录">
</form>
<div><%=request.getAttribute("err") == null ?"":request.getAttribute("err")%></div>

</body>
</html>
