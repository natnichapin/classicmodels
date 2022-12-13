package sit.int202.classicmodels.models;

public interface CartItem { //แทน line Item //interface
    public int getQuantity(); //จำนวนทั้งหมด
    public void setQuantity(int quantity);
    public double getUnitPrice();
    public double getTotal();
    public double getPercentDiscount();

}
