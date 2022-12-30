package sit.int202.classicmodels.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.entities.Orders;
import sit.int202.classicmodels.repositories.OrdersRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListHistroyServlet", value = "/List")
public class ListHistroyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();


        Customer customer = (Customer) session.getAttribute("user");
        List<Orders> OrderU  =(List<Orders>)session.getAttribute("OrderU");
        if(OrderU==null){
            OrdersRepository repo = new OrdersRepository();
            System.out.println("cu id : "+customer.getCustomerNumber());
            List<Orders> OrderDemo = repo.findByCustomerNumber(customer.getCustomerNumber());
            OrderDemo.stream().forEach(x-> System.out.println(x.getOrderNumber()+" "+x.getCustomerNumber()));
            session.setAttribute("OrderU",OrderDemo);
        }






        getServletContext().getRequestDispatcher("/OrderHistory.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
