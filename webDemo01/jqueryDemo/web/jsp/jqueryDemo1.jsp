<%--
  Created by IntelliJ IDEA.
  User: RenYunWei
  Date: 2021/8/9
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jqueryDemo1</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>

<div id = "div1"> div1....</div>
<div id="div2">div2....</div>

<script>
    var div1 = $("#div1");
    alert(div1.html());
    var div2 = $("div2");
    alert(div2.html())
</script>
</body>
</html>
