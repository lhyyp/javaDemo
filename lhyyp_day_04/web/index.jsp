<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="day_01.web.domain.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    User user = new User();
    user.setName("lhhyp");
    user.setPassword("12345");
    request.setAttribute("user",user);


    List list1 = new ArrayList();
    list1.add(new User("张三","12345"));
    list1.add(new User("lisi","12345"));
    request.setAttribute("list1",list1);

    List list = new ArrayList();
    list.add(111);
    list.add(2222);
    list.add(333);
    request.setAttribute("list",list);


    Map map = new HashMap();
    map.put("a","li");
    map.put("b","wwu");
    request.setAttribute("map",map);
  %>
  ${user}<br>
  ${user.name}<br>
  ${list}<br>
  ${map}<br>
  ${map.a}<br>
  ${map['b']}<br>
  ${empty map}<br>
  <c:if test="true">
    你好
  </c:if><br>
  <c:choose >
    <c:when test="${user.name == 'lhhyp'}">新起义</c:when>
    <c:otherwise>新义</c:otherwise>
  </c:choose>
  <br>
  <c:forEach items="${list1}" var="list1" varStatus="s">
    ${list1.name}<br>
  </c:forEach>


  
  </body>
</html>
