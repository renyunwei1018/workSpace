package cn.yunwei.web.servlet;

import cn.yunwei.domain.User;
import cn.yunwei.service.LoginService;
import cn.yunwei.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //verify check code
        User user = null;
        String code = (String) request.getSession().getAttribute("code");
        request.getSession().removeAttribute("code");
        String verifyCode = request.getParameter("verifycode");
        boolean flag=false;
        if (code!=null && code.equalsIgnoreCase(verifyCode)){
            //verify userName and password
            LoginService loginService = new LoginServiceImpl();
            user = loginService.login(request.getParameter("userName"), request.getParameter("password"));
            flag = user == null? false:true;
        }else {
            request.setAttribute("loginMsg","验证码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        if (flag){
            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/userListServlet");

            return;
        }else {
            request.setAttribute("loginMsg","用户名密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
