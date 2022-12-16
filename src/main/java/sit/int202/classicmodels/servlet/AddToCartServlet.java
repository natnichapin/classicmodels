package sit.int202.classicmodels.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Product;
import sit.int202.classicmodels.models.Cart;
import sit.int202.classicmodels.models.ClassicModelLineItem;
import sit.int202.classicmodels.repositories.ProductRepository;

import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        Cart<String, ClassicModelLineItem> cart = (Cart) session.getAttribute("cart"); //เอาตระกร้าจาก Session
        if (cart == null) {
            cart = new Cart<>();
            session.setAttribute("cart", cart); //เอาตระกร้าจาก session
        }
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.find(productCode);//เช็คโปรดัก ในDBว่ามีไม๊
        if (product != null) {
            cart.addItem(productCode, new ClassicModelLineItem(product)); //แอดลงตระกร้า
        }
        response.getWriter().print(cart.getQuantity()); //แสดง ปริมาณในตระกร้า หลัง เพิ่มของ
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
