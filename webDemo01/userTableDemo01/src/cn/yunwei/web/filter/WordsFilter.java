package cn.yunwei.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

@WebFilter("/*")
public class WordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //动态代理
        ServletRequest request = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(req,args);
                    List<String> errorWords = (List<String>) req.getServletContext().getAttribute("errorWords");
                    if (value!=null && errorWords.contains(value)) {
                        return "违规字符";
                    }else {
                        return value;
                    }
                }
                Object invoke = method.invoke(req,args);
                return invoke;
            }
        });
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
