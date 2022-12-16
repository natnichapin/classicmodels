package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.entities.Product;

import java.util.List;

import static sit.int202.classicmodels.repositories.EntityManagerBuilder.getEntityManager;

public class CustomerRepository {
    private EntityManager entityManager ;
    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }
    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Customer.FIND_USER");
        query.setParameter("user_account", name);
        List<Customer> customers = query.getResultList();
        em.close();
        return customers.size()==0? null : customers.get(0);
    }

    //ต้องเพิ่ม method ที่ทำให้เรียก default size ได้

    public List<Customer> findAll(){
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("Customer.FindAll");
        List<Customer> customers =   query.getResultList() ;
        entityManager.close();
        return  customers ;

    }

    public Customer find(String customerId){
        return getEntityManager().find(Customer.class,customerId);
    }

}


