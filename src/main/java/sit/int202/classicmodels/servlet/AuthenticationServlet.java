package sit.int202.classicmodels.servlet;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.repositories.CustomerRepository;

import java.io.IOException;

@WebServlet(name = "AuthenticationServlet", value = "/login")
public class AuthenticationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);

    }
    //login ได้แค่ คนที่อยู่ใน db
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password"); //รับ Username และ password มาจาก from
        String userName = request.getParameter("userName");
        if(userName==null || userName.trim().length()==0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST); //เช็คว่าไม่ส่งรหัสมา
            return; //ไม่รีเทินอะไร
        }
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName(userName); //หา user
        if (customer==null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN); //403 //ไม่เจอ ส่ง 403
        } else {

            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), customer.getPassword());
            //ตรวจสอบ pass ว่าตรงกันมั้ย จาก DB
            if (!result.verified) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED); //ไม่ตรง return Error
            } else {
                request.getSession().setAttribute("user", customer); //Set ลง Session เพื่อระบุตัวตน
            }
        }
         }
}
