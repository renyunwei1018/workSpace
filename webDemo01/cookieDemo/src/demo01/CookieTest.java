package demo01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        //获取cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        resp.setContentType("text/html;charset=utf-8");
        //记录本次访问时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = sf.format(date);
        String s = URLEncoder.encode(format, "utf-8");
        //校验是否第一次访问
        if (cookies!=null && cookies.length>0){
            for (Cookie c : cookies) {
                if ("lastTime".equals(c.getName())){
                    //不是第一次访问
                    flag = true;
                    c.setValue(s);
                    resp.getWriter().write("欢迎回来，您上一次登录时间为： "+ URLDecoder.decode(c.getValue(),"utf-8"));
                    break;
                }
            }
        }
        if (!flag){
            Cookie c = new Cookie("lastTime",s);
            resp.addCookie(c);
            //非第一次访问
            resp.getWriter().write("欢迎首次访问本网站");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
