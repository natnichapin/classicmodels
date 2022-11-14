package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity //ระบุ anotation
@Table(name = "Offices")
@NamedQueries({
        @NamedQuery(name = "Office.FIND_BY_CITY_OR_COUNTRY",
                query = "select o from Office o where lower(o.city) like :city or lower(o.country) like :country")
})


public class Office {
    @Id
    //entity class
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String territory;
    //ctr+d : duplicate
    @OneToMany(mappedBy="officeCode")
    private List<Employee> employees;

}
