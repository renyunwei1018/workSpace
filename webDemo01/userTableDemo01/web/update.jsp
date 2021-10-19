<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/10/6
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>

    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.servletContext.contextPath}/updateUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${updateUser.name}"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${updateUser.gender=='男'}">
                <input type="radio" name="sex" value="男"  checked="checked"/>男
                <input type="radio" name="sex" value="女"  />女
            </c:if>
            <c:if test="${updateUser.gender=='女'}">
                <input type="radio" name="sex" value="男"  />男
                <input type="radio" name="sex" value="女" checked="checked" />女
            </c:if>

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" value="${updateUser.age}" name="age"  />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <input type="text" class="form-control" id="address" value="${updateUser.address}" name="address"  />
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" value="${updateUser.QQ}"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" value="${updateUser.email}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="button" onclick="javascript:history.back(-1)" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
