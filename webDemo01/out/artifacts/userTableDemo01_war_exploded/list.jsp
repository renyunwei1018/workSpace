<%--
  Created by IntelliJ IDEA.
  User: RenYunWei
  Date: 2021/7/28
  Time: 17:10
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
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title style="color: white">用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;

        }

        #form1{
            border-radius: 20px;
            width: 1200px;
            height: 350px;
            margin-top: 40px;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
        body{
            color: white;
            background-size: cover;
            background: url(img/login2.jpg) no-repeat fixed center;

        }
        label{
            color: white;
        }
    </style>
</head>
<body>
<div class="container" id="form1">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left">
        <form class="form-inline" action="${pageContext.servletContext.contextPath}/userListServlet" method="post">
            <div class="form-group">
                <label for="name">名字</label>
                <input type="text" class="form-control" id="name" name="name" >
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <input type="text" class="form-control" id="address" name="address">
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" class="form-control" id="email" name="email">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="margin-bottom: 3px;float: right">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" >删除选中</a>
    </div>
    <table border="1" id="td1" class="table table-bordered table-hover">

        <tr class="success" style="color: black">
            <th><input type="checkbox" name="choose"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.pageBean.list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="choose"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.QQ}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.servletContext.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="${pageContext.servletContext.contextPath}/deleteUserServlet?id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <div style="float: left">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.servletContext.contextPath}/userListServlet?currentPage=${pageBean.currentPage-1}&rows=3" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${requestScope.pageBean.totalPage}" var="i">
                    <c:if test="${i == requestScope.pageBean.currentPage}">
                        <li class="active"><a href="${pageContext.servletContext.contextPath}/userListServlet?currentPage=${i}&rows=3">${i}</a></li>
                    </c:if>
                    <c:if test="${i != requestScope.pageBean.currentPage}">
                        <li ><a href="${pageContext.servletContext.contextPath}/userListServlet?currentPage=${i}&rows=3">${i}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                        <a href="${pageContext.servletContext.contextPath}/userListServlet?currentPage=${requestScope.pageBean.totalPage}&rows=3" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                        <a href="${pageContext.servletContext.contextPath}/userListServlet?currentPage=${pageBean.currentPage+1}&rows=3" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>

                </li>
                <span style="font-size: 25px;margin-left: 3px">
                    共${requestScope.pageBean.totalCount}条记录，共${requestScope.pageBean.totalPage}页
                </span>
            </ul>
        </nav>
    </div>

</div>

<script>
    $(function () {
        $("#td1 >tbody> tr:gt(0):odd").css("background-color","grey");
        $("#td1 >tbody>tr:gt(0):even").css("background-color","#1b6d85");
    });
</script>
</body>
</html>
