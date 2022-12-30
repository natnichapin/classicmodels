package sit.int202.classicmodels.servlet.Final_Lab.adminservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Customer;

import java.io.IOException;

@WebServlet(name = "Admin_page2Servlet", value = "/021/admin/page2")
public class Adminpage2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();
        Customer customer = (Customer) session.getAttribute("user") ;
        if(session==null|| customer==null) {

            session.setAttribute("message0","Unknown User - Unknown role");
        }
        else if(!customer.getRole().equals("user")||!customer.getRole().equals("admin")){
            session.setAttribute("message0",customer.getCustomerName()+" - "+customer.getRole());
        }
        session.setAttribute("page","Admin - Page 2");
        getServletContext().getRequestDispatcher("/DisplayPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
