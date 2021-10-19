<%--
  Created by IntelliJ IDEA.
  User: RenYunWei
  Date: 2021/7/19
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码登录</title>
</head>

<style>
    div{
        color: red;
    }
</style>
<body>
    <form action="/VerifyCode">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>密 码</td>
                <td><input type="password" name="passWord"></td>
            </tr>
            <tr>
                <td colspan="2"><img src="/checkCode" id="image"> </td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="code"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"> </td>
            </tr>
        </table>
    </form>
    <div>
        <%System.out.println(request.getAttribute("errCode"));%>
        <%=request.getAttribute("errCode")==null ? "":request.getAttribute("errCode")%>
    </div>
    <script>
        window.onload = function () {
            var element = document.getElementById("image");
            element.onclick=function () {
                var date = new Date();
                var time = date.getTime();
                element.src = "/checkCode?"+time;
            }
        }
    </script>
</body>
</html>
