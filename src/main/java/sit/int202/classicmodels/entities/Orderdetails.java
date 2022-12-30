package sit.int202.classicmodels.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="orderdetails")
@NamedQueries({
        @NamedQuery(name = "Orders.find",query = "select o from Orders o")

//        @NamedQuery(name = "Orders.Orderdetail",
//                query = "SELECT o FROM Orders o WHERE o.orderNumber= :orderNumber")
})
public class Orderdetails {

    @JoinColumn (name="orderNumber", referencedColumnName="orderNumber")
    @Id
    private  int orderNumber ;
    @Id
    private  String productCode ;
    private  int orderLineNumber ;

    private int quantityOrdered ;
    private double priceEach ;

    @ManyToOne
    @JoinColumn(name = "productCode")
    private Product product;

//    @OneToMany(mappedBy="productCode")
//    private List<Product> products ;

//    @Column(name = "total")
//    private double total = quantityOrdered*priceEach ;


}
