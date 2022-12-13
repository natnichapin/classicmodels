package sit.int202.classicmodels.models;

import sit.int202.classicmodels.entities.Product;

public class ClassicModelLineItem implements CartItem { //ต้อง imple ให้ครบไม่งั้นจะเป็น abstract //เอามาจาก interface cart

    private Product product;
    private int quantity;
    private double percentDiscount; //มีส่วนลด

    public ClassicModelLineItem(Product product) { //ใส่ product ให้เชื่อมกับ Jpa //ไม่มีปริมาณ
        this(product, 1, 0.0);
    }

    public ClassicModelLineItem(Product product, int quantity) { //ใส่ product ให้เชื่อมกับ Jpa //มีปริมาณ
        this(product, quantity, 0.0);
    }

    public ClassicModelLineItem(Product product, int quantity, double percentDiscount) {  //มีส่วนลด
        this.product = product;
        this.quantity = quantity;
        this.percentDiscount = percentDiscount;
    }
    public Product getProduct() { //เอาคลาส Product นั้นออกมา
        return product;
    }
    @Override
    public int getQuantity() {
        return quantity; //ปริมาณ
    }
    @Override
    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }
    @Override
    public double getUnitPrice() { //ราคาต่อหน่วย
        return Double.valueOf(product.getMsrp()) ;
    }
    @Override
    public double getTotal() {
        return getUnitPrice()*getQuantity() - getUnitPrice()*getQuantity()*percentDiscount;
    }
    @Override
    public double getPercentDiscount() {
        return percentDiscount;
    }
    public void setPercentDiscount(double percentDiscount) { //set % การลด
        this.percentDiscount = percentDiscount;
    }
    @Override
    public String toString() {
        return '{' + product.getProductName() + ", " +
                getUnitPrice() + ", " + quantity +
                ", " + percentDiscount +
                "% }";
    }


}

