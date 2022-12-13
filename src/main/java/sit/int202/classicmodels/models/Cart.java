package sit.int202.classicmodels.models;

import javax.sound.sampled.Line;
import java.util.*;
// เดิม คละ item ไม่ได้
    public class Cart<K, V extends CartItem> {
        private Map<K, V> map;
        public Cart() {
            this.map = new HashMap<>();
        }
        public int getNoOfItem() {
            return map.size();
        }
        public int getQuantity() {
            return map.values().stream().mapToInt(o -> o.getQuantity()).sum();
        }
        public Collection<V> getAllItem() {
            return Collections.unmodifiableCollection(map.values());
        }
    public double getTotalPrice() {
        return map.values().stream().mapToDouble(o -> o.getTotal()).sum();
    }
        public void addItem(K key, V value) {
            V item = map.get(key);
            if (item == null) {
                map.put(key, value);
            } else {
                item.setQuantity(item.getQuantity() + value.getQuantity());
            }
        }
        public V removeItem(K key) {
            return map.remove(key);
        }
        public void clear() {
            map.clear();
        }
    }




//ของเดิม ที่ ได้แค่ lineItem เดียว
  /*  Map<String,LineItem> itemsMap = new HashMap<>();
    public void add(LineItem item){
        String key = item.getProduct().getProductCode();
        LineItem existItem = itemsMap.get(key);
        if(existItem!=null){
            existItem.setAmount(existItem.getAmount()+ item.getAmount());
        }
        else {
            itemsMap.put(key,item);
        }
        //ต้องการถ้ามี ซ้ำก็เพิ่มจำนวน
        //itemsMap.put(item.getProduct().getProductCode(),item);
    }


    public void clear(){
        itemsMap.clear();
    }
    public List<LineItem> getItems(){
        Collection<LineItem> lineItems = itemsMap.values();
        return new ArrayList<>(lineItems) ;
        //เอา collection โยนเข้า list เนื่องจากจัดการยาก
    }

    public Double getTotalPrice(){
        double sum = 0 ;
        for(LineItem item : itemsMap.values()){
            sum=sum+item.getTotalPrice();
        }
        return sum;
    } */