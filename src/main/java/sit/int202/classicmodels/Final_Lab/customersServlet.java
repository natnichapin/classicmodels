package sit.int202.classicmodels.Final_Lab;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.repositories.CustomerRepository;

import java.io.IOException;

@WebServlet(name = "customersServlet", value = "/021/customers")
public class customersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerRepository customers =(CustomerRepository) session.getAttribute("customers") ;
        if(session==null || customers==null){
            CustomerRepository customerRepo = new CustomerRepository();
            session.setAttribute("customers",customerRepo.findAll());

        }

   getServletContext().getRequestDispatcher("/Customer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
