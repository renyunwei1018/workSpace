package cn.yunwei.web.servlet;

import cn.yunwei.domain.User;
import cn.yunwei.service.UserService;
import cn.yunwei.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String,String> parameterMap= new HashMap<>();
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String QQ = request.getParameter("QQ");
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        parameterMap.put("name", name);
        parameterMap.put("age",age);
        parameterMap.put("email",email);
        parameterMap.put("gender",gender);
        parameterMap.put("QQ",QQ);
        parameterMap.put("address",address);
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
        UserService userService = new UserServiceImpl();
        int i = userService.addUser(user);
        request.setAttribute("flag",i);
        response.sendRedirect("/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
