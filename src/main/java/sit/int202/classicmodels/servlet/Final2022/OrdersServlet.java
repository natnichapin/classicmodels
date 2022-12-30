package sit.int202.classicmodels.servlet.Final2022;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.entities.Orders;
import sit.int202.classicmodels.repositories.CustomerRepository;
import sit.int202.classicmodels.repositories.OrdersRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrdersServlet", value = "/Orders")
public class OrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Orders orders = (Orders) session.getAttribute("orders");
        String id = request.getParameter("id");
        if (session == null || orders == null) {
            OrdersRepository orderRepo = new OrdersRepository();
            request.setAttribute("orders", orderRepo.findById(Integer.valueOf(id)));
            System.out.println(orderRepo.findById(Integer.valueOf(id)).toString());
            //orderRepo.findById(Integer.valueOf(id)).getOrderdetails().stream().forEach(x-> System.out.println(x.getOrderNumber()+"   "+x.getOrderLineNumber()));
            //session.setAttribute("Orders",);
            //List<Customer> a =   customerRepo.findAll();

        }

        getServletContext().getRequestDispatcher("/Orders.jsp").forward(request,response);  }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
