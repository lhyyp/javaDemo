package day_01.web.servletWeb.web;

import day_01.web.dao.UserDao;
import day_01.web.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String verify = request.getParameter("verify");

        Map<String, String[]> map = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 判断验证码
        String verify1 = (String) request.getSession().getAttribute("verify");
        request.getSession().removeAttribute("verify");

        if (verify!=null && verify1.equalsIgnoreCase(verify)) {
            User res = new UserDao().login(user);
            if(res==null){
                request.setAttribute("err", "用户名或密码错误");
                System.out.println("用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            }else{
                request.getSession().setAttribute("user",res);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }

        } else {
            request.setAttribute("err", "验证码错误");
            System.out.println("验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

//
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.write("hello,你好");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
