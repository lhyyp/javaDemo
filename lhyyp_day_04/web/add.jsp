<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 2019/11/13
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/add" method="post">
        <label for="">
            用户名：<input type="text" name="name">
        </label>
        <div>
            性别：
            <label><input name="sex" type="radio" value="男" />男 </label>
            <label><input name="sex" type="radio" value="女" />女 </label>
        </div>
        <br>
        <label for="">
            地址：<input type="text" name="adress">
        </label>
        <br>
        <label for="">
            age：<input type="text" name="age">
        </label>
        <br>
        <label for="">
            email：<input type="text" name="email">
        </label>
        <br>
        <label for="">
            qq：<input type="text" name="qq">
        </label>
        <br>
        <input type="submit" value="add">
    </form>
    <div><%=request.getAttribute("err") == null ?"":request.getAttribute("err")%></div>
</body>
</html>
