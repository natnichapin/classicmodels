package sit.int202.classicmodels;

import sit.int202.classicmodels.entities.Product;
import sit.int202.classicmodels.models.Cart;
import sit.int202.classicmodels.models.ClassicModelLineItem;
import sit.int202.classicmodels.models.LineItem;
import sit.int202.classicmodels.repositories.ProductRepository;

public class TestCart {
    public static void main(String[] args) {
        Cart<String, ClassicModelLineItem> cart = new Cart<>();
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.find("S10_1678");
        cart.addItem(product.getProductCode(), new ClassicModelLineItem(product,5));
        product = productRepository.find("S12_3380");
        cart.addItem(product.getProductCode(), new ClassicModelLineItem(product));
        System.out.println(cart.getNoOfItem());
        System.out.println(cart.getQuantity());
        System.out.println(cart.getTotalPrice());
        System.out.println(cart.getAllItem());
        cart.removeItem("S10_1678");

    }
}

/* ProductRepository repository = new ProductRepository();
        Product p = repository.find("S10_1949");
        System.out.println("Price: "+p.getMsrp());
        LineItem line = new LineItem(p); //ตอน new มีอยู้แล้ว 1 product
        Cart cart = new Cart();
        //มี product 2 ชิ้น
        //ตัวแปรตัวเดิม
        cart.add(line);
        p = repository.find("S10_1678");
        line = new LineItem(p);
        cart.add(line);
        cart.add(line);

        System.out.println(cart.getTotalPrice());

        for (LineItem item : cart.getItems()) {
            System.out.println(item.getProduct().getProductCode()+",amount " +item.getAmount());
        }*/
