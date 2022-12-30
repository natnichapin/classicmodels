package sit.int202.classicmodels.servlet.Final_Lab.userservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Customer;

import java.io.IOException;

@WebServlet(name = "User_page1Servlet", value = "/021/user/page1")
public class Userpage1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user") ;
        if(session==null|| customer==null) {

            session.setAttribute("message0","Unknown User - Unknown role");
        }
        else if(!customer.getRole().equals("user")||!customer.getRole().equals("admin")){
            session.setAttribute("message0",customer.getCustomerName()+" - "+customer.getRole());
        }
        session.setAttribute("page","User - Page 1");

        getServletContext().getRequestDispatcher("/DisplayPage.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
