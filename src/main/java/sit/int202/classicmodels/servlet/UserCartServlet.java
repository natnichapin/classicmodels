package sit.int202.classicmodels.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.models.Cart;
import sit.int202.classicmodels.models.ClassicModelLineItem;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "UserCartServlet", value = "/Cart-product")
public class UserCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart<String, ClassicModelLineItem> cart = (Cart) session.getAttribute("cart");
        if(cart==null) {
            getServletContext().getRequestDispatcher("/CartItems.jsp").forward(request, response);
        }
        else {
                  Collection<ClassicModelLineItem>  List  =cart.getAllItem() ;

                  session.setAttribute("CartItems",List);
            getServletContext().getRequestDispatcher("/CartItems.jsp").forward(request, response);

        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
