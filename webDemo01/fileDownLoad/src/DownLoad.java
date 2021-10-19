import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download")
public class DownLoad extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数文件名称
        String name = req.getParameter("name");
        //2、找到文件路径
        String realPath = this.getServletContext().getRealPath("/image/" + name);
        //3、加载进字节流
        FileInputStream in = new FileInputStream(realPath);
        //4、设置response响应头，设置响应文件类型mimeType
        String mimeType = this.getServletContext().getMimeType(name);
        resp.setHeader("content-type",mimeType);
        //5、设置响应头的打开方式，content-disposition:attachment;filename=xxx
        resp.setHeader("content-disposition","attachment;filename="+name);
        //可设置根据不通浏览器采用不通的方式，获取浏览器req.getHeader("user-agent")
        //6、将输入流数据输出
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024*8];
        int read=0;
        while ((read = in.read(bytes))!=-1) {
            outputStream.write(bytes,0,read);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
