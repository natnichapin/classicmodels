package sit.int202.classicmodels.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter",servletNames = {"OfficeListServlet","AddToCartServlet"})
public class AuthenticationFilter implements Filter {
    private FilterConfig filterConfig;
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);
        if (session==null ||session.getAttribute("user")==null) {
            response.getWriter().write("<br><br><h2 class='text-danger'>Please login first !!! </h2>"); //ไม่มี user แสดง ข้อความ
        } else {
            chain.doFilter(request, response); //มี ให้ส่งต่อไป
        }
    }
}
