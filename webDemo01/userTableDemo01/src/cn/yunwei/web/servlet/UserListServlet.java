package cn.yunwei.web.servlet;

import cn.yunwei.domain.PageBean;
import cn.yunwei.domain.User;
import cn.yunwei.service.UserService;
import cn.yunwei.service.impl.UserServiceImpl;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //get query conditions parameter
        String _currentPage = request.getParameter("currentPage");
        String _rows = request.getParameter("rows");
        int currentPage = StringUtils.isEmpty(_currentPage) ? 1 : Integer.parseInt(_currentPage);
        int rows = StringUtils.isEmpty(_rows) ? 3 : Integer.parseInt(_rows);
        if (!StringUtils.isEmpty(_currentPage) && Integer.parseInt(_currentPage)<1){
            currentPage = 1;
        }

        //get conditions
        Map<String, String[]> conditionMap = request.getParameterMap();


        //1.use service to query all users
        UserService service = new UserServiceImpl();
        PageBean<User> pageBean = service.findUserByPage(currentPage, rows,conditionMap);
        System.out.println(pageBean);
        //2.add users to request
        request.setAttribute("pageBean",pageBean);
        //3.send users to list.jsp
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
