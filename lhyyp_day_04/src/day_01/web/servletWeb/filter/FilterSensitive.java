package day_01.web.servletWeb.filter;
/*
    敏感词过滤
 */
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class FilterSensitive implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        ServletRequest o =(ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(method.getName().equals("getParameter")){
                    String value =(String) method.invoke(req, args);
                    if(value!=null){
                        for (String s : list) {

                            if(value.contains(s)){
                                value = value.replaceAll(s,"***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req, args);
            }
        });

        chain.doFilter(o, resp);
    }
    private List<String> list = new ArrayList<String>();

    public void init(FilterConfig config) throws ServletException {
        try{

            ServletContext sc = config.getServletContext();
            String realPath = sc.getRealPath("/WEB-INF/classes/sensitive.txt");
            BufferedReader br = new BufferedReader(new FileReader(realPath));

            String line = null;
            while ((line = br.readLine())!=null){
                System.out.println("敏感字："+line);
                list.add(line);
            }
            br.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
