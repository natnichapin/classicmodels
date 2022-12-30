package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="orders")
@NamedQueries({
        @NamedQuery(name = "Orders.All",query = "select o from Orders o"),
        @NamedQuery(name = "Orders.Orderdetail",
                query = "SELECT o FROM Orders o WHERE o.orderNumber= :orderNumber"),
        @NamedQuery(name = "Orders.ByCustomer",
                query = "SELECT o FROM Orders o WHERE o.customerNumber= :customerNumber")

})
public class Orders {
    @Id

    private  int orderNumber ;
    private Date orderDate ;
    private Date shippedDate ;
    private String status ;
    private int customerNumber ;
    @OneToMany(mappedBy="orderNumber")
    private List<Orderdetails> orderdetails ;

}
