<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 2019/11/11
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add(111);
        list.add(2222);
        list.add(333);
        request.setAttribute("list",list);
    %>
  <h1><%=request.getSession().getAttribute("user")%></h1>
    ${user.name}<br>
${list}

</body>
</html>
