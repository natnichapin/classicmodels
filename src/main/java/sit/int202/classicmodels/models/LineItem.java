package sit.int202.classicmodels.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sit.int202.classicmodels.entities.Product;

//@AllArgsConstructor //ไม่มี NO คือ ถ้าไม่มี Arg ส่ง มาจะ new ไม่ได้
@Getter
@Setter
public class LineItem { //รายการในแต่ละสินค้า
    private Product product;
    private Double price;
    private Integer amount;
    public LineItem(Product p) {
        this(p, 1);
    }
    public LineItem(Product p, int amount) {
        this.product = p;
        this.price = Double.valueOf(product.getMsrp()) ;
        this.amount = amount;
    }
    public Double getTotalPrice() {
        return price * amount;
    }
}