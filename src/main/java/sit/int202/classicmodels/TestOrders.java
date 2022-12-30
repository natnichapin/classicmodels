package sit.int202.classicmodels;

import sit.int202.classicmodels.repositories.OrdersRepository;

public class TestOrders {
    public static void main(String[] args) {
        OrdersRepository x = new OrdersRepository();
//       x.findAll().stream().forEach(y->y.getOrderdetails().forEach(u-> System.out.println(u.getOrderLineNumber()+" "+u.getOrderNumber())));
       x.findByCustomerNumber(112).stream().forEach(y-> System.out.println(y.getOrderNumber() ));
    }
}
