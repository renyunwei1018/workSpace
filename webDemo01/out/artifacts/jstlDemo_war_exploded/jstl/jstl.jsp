<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: RenYunWei
  Date: 2021/7/26
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    1、test里面的内容是if的判断语句
    2、如果为true则显示if中的内容
--%>
<c:if test="true">我是真</c:if>
<c:if test="false">我是假</c:if>

<%--
    choose  相当于switch
        when    相当于case
        otherwise   相当于default

--%>

<%
    request.setAttribute("number",3);
    List list = new ArrayList();
    list.add("元素0");
    list.add("元素1");
    list.add("元素2");

    request.setAttribute("list",list);
%>

<c:choose>
    <c:when test="${requestScope.number==1}">我是when</c:when>
    <c:otherwise>我是其他</c:otherwise>

</c:choose>

<%--
    foreach 相当于java代码的for循环
        1、完成重复操作
        2、遍历容器
    begin 开始变量
    end 结束变量
    var 临时变量
    step 步长
    items 表示容器



    varstatus 循环对象
        count 表示循环的次数
        index 表示容器中元素的索引
--%>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>

<c:forEach items="${requestScope.list}" var="listValue" varStatus="s">
    ${s.index}   ${s.count}    ${listValue}
</c:forEach>
</body>
</html>
