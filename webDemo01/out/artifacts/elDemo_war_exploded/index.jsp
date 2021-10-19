<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: RenYunWei
  Date: 2021/7/19
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    ${3+4}
    ${3%4}<!--由于取余可以使用mod、除可以使用div-->
    ${3>4}
    ${true||false}<!--and or or-->
    <%--四个域对象从小到大--%>
  <%

    pageContext.setAttribute("gender","男");
    request.setAttribute("name","张三");
    session.setAttribute("hobby","打球");
    application.setAttribute("age","6");

    User user = new User();
    user.setName("李四");
    user.setBrithday(new Date());
    request.setAttribute("u",user);
  %>

  ${requestScope.name}
  ${requestScope.u.name}
  
  </body>
</html>
