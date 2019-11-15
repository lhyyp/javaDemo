<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 2019/11/14
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update" method="post">
    <input type="hidden" name="id" value="${member.id}">
    <label for="">
        用户名：<input type="text" name="name" value="${member.name}">
    </label>
    <div>
        性别：
        <c:if test="${member.sex == '男'}">
            <label><input name="sex" type="radio" value="男" checked/>男 </label>
            <label><input name="sex" type="radio" value="女" />女 </label>
        </c:if>
        <c:if test="${member.sex == '女'}">
            <label><input name="sex" type="radio" value="男" />男 </label>
            <label><input name="sex" type="radio" value="女" checked/>女 </label>
        </c:if>
    </div>
    <br>
    <label for="">
        地址：<input type="text" name="adress" value="${member.adress}">
    </label>
    <br>
    <label for="">
        age：<input type="text" name="age" value="${member.age}">
    </label>
    <br>
    <label for="">
        email：<input type="text" name="email" value="${member.email}">
    </label>
    <br>
    <label for="">
        qq：<input type="text" name="qq" value="${member.qq}">
    </label>
    <br>
    <input type="submit" value="修改">
</form>
<div><%=request.getAttribute("err") == null ?"":request.getAttribute("err")%></div>
</body>
</html>
