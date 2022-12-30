package sit.int202.classicmodels.servlet.Final2022;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.repositories.CustomerRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "customersServlet", value = "/021/customers")
public class customersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerRepository customers =(CustomerRepository) session.getAttribute("customers") ;
        if(session==null || customers==null){
            CustomerRepository customerRepo = new CustomerRepository();
            session.setAttribute("customers",customerRepo.findAll());
            //session.setAttribute("Orders",);
            List<Customer> a =   customerRepo.findAll();

          //  a.stream().forEach(x-> System.out.println(x.getOrders()==null?null:x.getOrders()));
             //List<Orders> a = (List<Orders>) customerRepo.findAll().stream().map(x->x.getOrders());
         // a.stream().forEach(x-> System.out.println(x.getOrderDate()));

           // customerRepo.findAll().stream().forEach(x-> x.getOrders().stream().forEach(y-> System.out.println(y.getCustomerNumber())));
        }

   getServletContext().getRequestDispatcher("/Customer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
