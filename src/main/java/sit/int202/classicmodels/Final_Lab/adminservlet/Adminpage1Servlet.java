package sit.int202.classicmodels.Final_Lab.adminservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Customer;

import java.io.IOException;

@WebServlet(name = "Admin_page1Servlet", value = "/021/admin/page1")
public class Adminpage1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute("page","Admin - Page 1");
        getServletContext().getRequestDispatcher("/DisplayPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
