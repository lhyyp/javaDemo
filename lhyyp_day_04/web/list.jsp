<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 2019/11/13
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .btn_com{
            display: flex;
            width: 1200px;
            margin: 0 auto;

        }
    </style>
</head>
<body>
<div class="btn_com">

    <a href="${pageContext.request.contextPath}/add.jsp">增加</a>
</div>
<table border="1" align="center" cellpadding="0" cellspacing="0" width="80%" style="text-align: center;">
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>地址</td>
        <td>email</td>
        <td>qq</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="list" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${list.name}</td>
            <td>${list.sex}</td>
            <td>${list.age}</td>
            <td>${list.adress}</td>
            <td>${list.email}</td>
            <td>${list.qq}</td>
            <td>
                <a href="${pageContext.request.contextPath}/detele?id=${list.id}">删除</a>
                <a href="${pageContext.request.contextPath}/view?id=${list.id}">修改</a>

            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
