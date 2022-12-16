package sit.int202.classicmodels.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

//@WebFilter(filterName = "LoggerFilter" , urlPatterns = "/*") //annotation สิ่งที่ต้องระบุตอนเขียน : คือ url pattern  /* wildcard เรียกผ่าน root
//ทุกๆ resource ที่อยู่ที่root จะต้องผ่าน filter นี้ ซึ่ง web container จะมาอ่านแล้วใช้ทำงาน
// ซึ่งเขียนได้ 2 แบบ  URL  และ ระบุชื่อ

@WebFilter(filterName = "LoggerFilter" , servletNames = {"AddToCartServlet","ProductListServlet"})
public class LoggerFilter implements Filter {
    private FilterConfig config ;
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // ขาเข้า
        long before = System.currentTimeMillis(); //เวลาเริ่มต้น
        //invoke resources
        chain.doFilter(request, response); //ทำงานต่อใน resource
        //ขาออก
        HttpServletRequest req = (HttpServletRequest) request ;
        long duration = System.currentTimeMillis()-before ;
        String message ="Servlet duration" + req.getRequestURI()  + " " + duration + " ms " ;
        config.getServletContext().log(message);
    }
    public void destroy() {
    }
}
