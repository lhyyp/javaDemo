package day_01.web.servletWeb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/login.jsp") || requestURI.contains("/login") || requestURI.contains("/verify")){
            chain.doFilter(req, resp);
        }else{
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("err","你尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }





    }

    public void init(FilterConfig config) throws ServletException {

    }

}
