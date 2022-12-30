package sit.int202.classicmodels.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.entities.Orders;
import sit.int202.classicmodels.models.Cart;
import sit.int202.classicmodels.models.ClassicModelLineItem;
import sit.int202.classicmodels.repositories.OrdersRepository;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet(name = "OrderServlet", value = "/Order-History")
public class OrderHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

           Customer customer = (Customer) session.getAttribute("user");

        Cart<String, ClassicModelLineItem> cart = (Cart) session.getAttribute("cart");

        if(cart==null || customer==null ) {
        }
        else {
            List<Collection<ClassicModelLineItem>> OrdersOfUser = (List<Collection<ClassicModelLineItem>>) session.getAttribute("OrdersOfUser");

            if( OrdersOfUser==null ){
                List<Collection<ClassicModelLineItem>> newOrder = new ArrayList<>() ;
                session.setAttribute("OrdersOfUser",newOrder);
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date date = new Date();
            String todate = dateFormat.format(date);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +7);
            Date todate1 = cal.getTime();
            String fromdate = dateFormat.format(todate1);
                session.setAttribute("NowDate",todate);
            session.setAttribute("ShipDate",fromdate);


                Collection<ClassicModelLineItem> Order =new ArrayList<>();
                  cart.getAllItem().stream().forEach(x->Order.add(x));
                OrdersOfUser.add(Order) ;
                cart.clear();

                response.sendError(HttpServletResponse.SC_OK);

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
