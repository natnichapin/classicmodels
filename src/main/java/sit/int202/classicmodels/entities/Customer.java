package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="customers")
@NamedQueries({
        @NamedQuery(name = "Customer.FIND_USER",
                query = "SELECT c FROM Customer c WHERE concat(trim(c.contactFirstName), ' ', trim(c.contactLastName)) = :user_account"),
        @NamedQuery(name="Customer.FindAll",query="SELECT c FROM Customer c")
})

public class Customer {
    @Id
    private Integer customerNumber;
    private String customerName;
    private String contactFirstName ;
    private String contactLastName;
    private String password ;
    private String role ;

}
