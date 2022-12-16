package sit.int202.classicmodels.models;

public interface CartItem { //แทน line Item //interface
    public int getQuantity(); //จำนวนทั้งหมด
    public void setQuantity(int quantity); //set จำนวนทั้งหมด
    public double getUnitPrice(); //ราคาต่อ 1 ชิ้น
    public double getTotal(); //ราคาทั้งหมด
    public double getPercentDiscount(); //ส่วนลด

}
