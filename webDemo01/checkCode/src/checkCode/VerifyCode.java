package checkCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VerifyCode")
public class VerifyCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = (String) request.getSession().getAttribute("code");
        request.getSession().removeAttribute("code");
        String code1 = request.getParameter("code");
        System.out.println(code+"======="+code1);

        if (code!=null && code.equalsIgnoreCase(code1)){
            request.setAttribute("errCode","验证正确");
            request.getRequestDispatcher("/loginCheckCode.jsp").forward(request,response);
        }else {
            request.setAttribute("errCode","验证码错误");
            request.getRequestDispatcher("/loginCheckCode.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
