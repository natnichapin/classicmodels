package sit.int202.classicmodels.servlet.Final_Lab.userservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Customer;

import java.io.IOException;

@WebServlet(name = "User_page_2Servlet", value = "/021/user/page2")
public class Userpage2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession() ;

        session.setAttribute("page","User - Page 2");
        getServletContext().getRequestDispatcher("/DisplayPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
