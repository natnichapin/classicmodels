package sit.int202.classicmodels.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.IOException;

@WebFilter(filterName = "HistoryFilter",servletNames = "HistoryServlet")
public class HistoryFilter implements Filter {
    private FilterConfig filterConfig ;
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config ;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request ;
           HttpSession session = httpServletRequest.getSession(false);
        if(session==null || session.getAttribute("user")==null) {
            response.getWriter().write("<br><br><h2 class='text-danger'>Please login first !!! </h2>");
        }
        else {
            chain.doFilter(request,response);
        }
    }
}
