package cn.yunwei.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        request.setCharacterEncoding("utf-8");
        String requestURI = request.getRequestURI();
        System.out.println("uri"+requestURI);
        if (requestURI.contains("css")||requestURI.contains("fonts")||requestURI.contains("js")
                ||requestURI.contains("index.jsp")||requestURI.contains("loginServlet")||requestURI.contains("checkCode")){
            chain.doFilter(req, resp);
        }else {
            if (request.getSession().getAttribute("user")!=null){
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("loginMsg","请先登录");
                request.getRequestDispatcher("/index.jsp").forward(request,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
