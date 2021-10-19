package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/demo03")
public class Demo03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//        System.out.println(email);
//        System.out.println(password);
//        String referer = req.getHeader("referer");
//        System.out.println(referer);
//
        System.out.println(req.getContextPath());
        BufferedReader reader = req.getReader();
        String line = null;
        req.setCharacterEncoding("utf-8");
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
