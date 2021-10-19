package checkCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCode01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 200;
        int height = 50;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //画背景
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.gray);
        graphics.fillRect(0,0,width,height);
        //画边框
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0,0,width-1,height-1);
        //画验证码
        String Code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <=4 ; i++) {
            int index = random.nextInt(Code.length());
            graphics.setColor(Color.BLUE);
            graphics.drawString(Code.charAt(index)+"",width/5*i,height/2);
            sb.append(Code.charAt(index)+"");
        }

        graphics.setColor(Color.green);
        for (int i = 1; i <=10 ; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        HttpSession session = req.getSession();
        session.setAttribute("code",sb.toString());
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
