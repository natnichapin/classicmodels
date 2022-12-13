package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Product;
import sit.int202.classicmodels.repositories.EntityManagerBuilder;
import sit.int202.classicmodels.repositories.ProductRepository;

import java.util.List;

public class TestProduct {
    public static void main(String[] args) {
        EntityManager em = EntityManagerBuilder.getEntityManager();
//        Query query = em.createQuery("select p from Product p");
//        //0-19
//        query.setFirstResult(0);
//        query.setMaxResults(30);
//        List<Product> productList = query.getResultList();
        ProductRepository repository = new ProductRepository();
        System.out.println("No of product: "+repository.countAll());
        List<Product> productList = repository.findAll(1);
        //10 รายการสุดท้าย
        for (Product product : productList) {
            System.out.println(product.getProductCode()+ " : " + product.getProductName() + " : " + product.getProductLine());
        }
        em.close();
    }
}
