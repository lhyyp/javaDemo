package day_01.web.servletWeb.web;

import day_01.web.dao.MemberDao;
import day_01.web.domain.Member;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/add")
public class ServletAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(1234);
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Member member = new Member();
        try {
            BeanUtils.populate(member,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(member);
        int add = new MemberDao().add(member);
        System.out.println(add);

        response.sendRedirect(request.getContextPath()+"/list");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
