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
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User updateUser = (User) request.getSession().getAttribute("updateUser");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {

            BeanUtils.populate(user,parameterMap);
            UserService userService =new UserServiceImpl();
            int i = userService.updateUser(String.valueOf(updateUser.getId()), user);
            System.out.println("update user count:  "+i+"");
            response.sendRedirect(request.getContextPath()+"/userListServlet");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
