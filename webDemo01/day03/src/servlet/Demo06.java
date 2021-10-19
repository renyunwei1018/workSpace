package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo06")
public class Demo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        String method = req.getMethod();
        System.out.println(method);
        String servlet = req.getServletPath();
        System.out.println(servlet);
        String queryString = req.getQueryString();
        System.out.println(queryString);
        String uri = req.getRequestURI();
        System.out.println(uri);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        String protocol = req.getProtocol();
        System.out.println(protocol);
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);

        //获取请求行信息
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            String header = req.getHeader(s);
            System.out.println("头："+s+" 体："+header);
        }
    }
}
