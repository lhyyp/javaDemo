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
        * {
            margin: 0;
            padding: 0;
        }

        .btn_com {
            display: flex;
            width: 1200px;
            margin: 0 auto;

        }
    </style>
</head>
<body>
<div class="btn_com">
    <form action="${pageContext.request.contextPath}/findMemberPage" method="post">
        <label for="">
            用户名：<input type="text" name="name">
        </label>
        <label for="">
            email：<input type="text" name="email">
        </label>
        <input type="submit" value="查询">
    </form>

    <a href="${pageContext.request.contextPath}/add.jsp">增加</a>
</div>
<form action="${pageContext.request.contextPath}/deleteAll" method="post">
    <input type="submit" value="删除选中">
    <table border="1" align="center" cellpadding="0" cellspacing="0" width="80%" style="text-align: center;">
        <tr>
            <td></td>
            <td>编号</td>
            <td>用户名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>地址</td>
            <td>email</td>
            <td>qq</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list.list}" var="list" varStatus="s">
            <tr>
                <td><input type="checkbox" name="item" value="${list.id}"></td>
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
</form>
<div>
    共${list.totalCount} 条记录,共${list.totalPage} 页,当前页码为${list.currentPage},每页${list.row}条
</div>

<script>


</script>

</body>
</html>
