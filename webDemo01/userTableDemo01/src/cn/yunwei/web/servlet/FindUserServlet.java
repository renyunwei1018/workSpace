package cn.yunwei.web.servlet;


import cn.yunwei.domain.PageBean;
import cn.yunwei.domain.User;
import cn.yunwei.service.UserService;
import cn.yunwei.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        UserService service = new UserServiceImpl();
        PageBean<User> userByPage = service.findUserByPage(1, 1, parameterMap);
        User user = userByPage.getList().get(0);
        HttpSession session = request.getSession();
        session.setAttribute("updateUser",user);
        response.sendRedirect(request.getContextPath()+"/update.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
