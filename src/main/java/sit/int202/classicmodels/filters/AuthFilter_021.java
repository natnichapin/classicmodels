package sit.int202.classicmodels.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import sit.int202.classicmodels.entities.Customer;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter_021",servletNames = {"Admin_page1Servlet","User_page_2Servlet"})
public class AuthFilter_021 implements Filter {
    private FilterConfig config ;
    public void init(FilterConfig config) throws ServletException {
        this.config = config ;
    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);
//        if (session==null ||session.getAttribute("user")==null) {
//            response.getWriter().write("<br><br><h2 class='text-danger'>Please login first !!! </h2>"); //ไม่มี user แสดง ข้อความ
//        } else {
//            chain.doFilter(request, response); //มี ให้ส่งต่อไป
//        }



        if (session==null ||session.getAttribute("user")==null) {

            response.getWriter().write("<br><br><h2 class='text-danger'>Please login first !!! </h2>"); //ไม่มี user แสดง ข้อความ
        } else {
            //chain.doFilter(request, response); //มี ให้ส่งต่อไป
            Customer customer = (Customer) session.getAttribute("user");
            if(customer.getRole().equals("admin") || customer.getRole().equals("user")){
                chain.doFilter(request,response);

            }
            else {
                response.getWriter().write("<br><br><h2 class='text-danger'> You can not acess this page!!! </h2>");

                }
             }
        }
    }
