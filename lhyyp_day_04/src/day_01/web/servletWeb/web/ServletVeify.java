package day_01.web.servletWeb.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/verify")
public class ServletVeify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics gs = buff.getGraphics();
        gs.setColor(Color.pink);
        gs.fillRect(0,0,width,height);

        gs.setColor(Color.blue);
        gs.drawRect(0,0,width-1,height-1);

        String str = "qwertyuiopasdfghjklzxcvbnm";
        int fontSize = 30;
        Font font = new Font("楷体", Font.PLAIN, fontSize);
        gs.setFont(font);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            gs.drawString(ch+"",width/5*(i+1),height/2);
            sb.append(ch);
        }

        String s = sb.toString();
        request.getSession().setAttribute("verify",s);

        gs.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int xStart = random.nextInt(width);
            int xEnd = random.nextInt(width);
            int yStart = random.nextInt(height);
            int yEnd = random.nextInt(height);
            gs.drawLine(xStart,yStart,xEnd,yEnd);
        }

        ImageIO.write(buff, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
