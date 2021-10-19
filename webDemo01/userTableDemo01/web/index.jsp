<%--
  Created by IntelliJ IDEA.
  User: RenYunWei
  Date: 2021/7/28
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <!-- Bootstrap -->
  <link rel="stylesheet" href="../css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

  <title>管理员登录</title>

  <!-- 1. 导入CSS的全局样式 -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
  <script src="js/jquery-2.1.0.min.js"></script>
  <!-- 3. 导入bootstrap的js文件 -->
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
    function refreshCode() {
      var element = document.getElementById("vcode");
      element.src = "${pageContext.servletContext.contextPath}/checkCode?time="+ new Date().getTime();
    }
  </script>
  <style>
    #loginPage{
      border-radius: 20px;
      width: 500px;
      height: 350px;
      margin-top: 80px;
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
    }
    body{
      background-size: cover;
      background: url(/img/login2.jpg) no-repeat fixed center;

    }
    label{
      color: white;
    }
  </style>
</head>
<body>
<div class="container" id="loginPage" >
  <h3 style="text-align: center;">管理员登录</h3>
  <form action="${pageContext.servletContext.contextPath}/loginServlet" method="post" >
    <div class="form-group">
      <label for="user">用户名：</label>
      <input type="text" name="userName" class="form-control" id="user" placeholder="请输入用户名"/>
    </div>

    <div class="form-group">
      <label for="password">密码：</label>
      <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
    </div>

    <div class="form-inline">
      <label for="vcode">验证码：</label>
      <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
      <a href="javascript:refreshCode()">
        <img src="${pageContext.servletContext.contextPath}/checkCode" title="看不清点击刷新" id="vcode"/>
      </a>
    </div>

    <div class="form-group" style="text-align: center; margin-top: 20px">
      <input class="btn btn btn-primary" type="submit" value="登录">
    </div>
  </form>

<%--  <c:if test="${requestScope.loginMsg!=null}">--%>
<%--    <!-- 出错显示的信息框 -->--%>
<%--    <div class="alert alert-warning alert-dismissible" role="alert">--%>
<%--      <button type="button" class="close" data-dismiss="alert" >--%>
<%--        <span>&times;</span></button>--%>
<%--      <strong>${requestScope.loginMsg}</strong>--%>
<%--    </div>--%>
<%--  </c:if>--%>

</div>
</body>
</html>
