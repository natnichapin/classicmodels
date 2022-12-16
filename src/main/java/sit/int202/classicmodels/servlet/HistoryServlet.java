package sit.int202.classicmodels.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.models.Cart;
import sit.int202.classicmodels.models.ClassicModelLineItem;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "HistoryServlet", value = "/History-product")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart<String, ClassicModelLineItem> cart = (Cart) session.getAttribute("cart");
        if(cart==null) {
            session.setAttribute("message1", "not have product");
            System.out.println("null-cart");
        }
        else {
                  Collection<ClassicModelLineItem>  List  =cart.getAllItem() ;
                  List.stream().forEach(x-> System.out.println(x) );
                  session.setAttribute("HistoryItem",List);

                  session.setAttribute("message1", null);

        }

        getServletContext().getRequestDispatcher("/OrderHistory.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
