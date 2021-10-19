package servlet;

import javax.servlet.*;
import java.io.IOException;

public class Demo01 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /**
         * 初始化方法
         * 在servlet被创建时执行，只执行一次
         * */
        System.out.println("创建servlet对象");
    }

    @Override
    public ServletConfig getServletConfig() {
        /**
         * 获取servlet的配置方法
         */
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /**
        * 提供服务的方法
        * 每次访问执行一次
        * */
        System.out.println("提供服务");
    }

    @Override
    public String getServletInfo() {
        /**
         * 获取servlet的信息如：版本、作者等
         */
        return null;
    }

    @Override
    public void destroy() {
        /**
        * 销毁方法
        * servlet服务器正常关闭时执行，只执行一次
        * */
        System.out.println("销毁servlet对象");

    }
}
