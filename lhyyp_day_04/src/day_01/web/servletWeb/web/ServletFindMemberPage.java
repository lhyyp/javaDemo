package day_01.web.servletWeb.web;

import day_01.web.dao.MemberDao;
import day_01.web.dao.UserDao;
import day_01.web.domain.Member;
import day_01.web.domain.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/findMemberPage")
public class ServletFindMemberPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        Map<String, String[]> searchData = request.getParameterMap();
        PageBean<Member> memberPage = new MemberDao().findMemberPage(currentPage, rows,searchData);
        request.setAttribute("list",memberPage);
        request.getRequestDispatcher("/findMemberPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
