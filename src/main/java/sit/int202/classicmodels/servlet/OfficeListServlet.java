package sit.int202.classicmodels.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.repositories.OfficeRepository;



@WebServlet(name = "OfficeListServlet", value = "/office-list")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test");
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll()); //หา List ของ office ทั้งหมด เก็บเข้า session
        String officeCode = request.getParameter("officeCode"); //เอา office code มาจาก user
        if (officeCode != null) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode)); //หา row ที่ มี office code ดังกล่าว
            //เก็บเข้า request scope
        }

        getServletContext().getRequestDispatcher("/OfficeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO document why this method is empty
    }
}
