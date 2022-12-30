package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import sit.int202.classicmodels.entities.Orders;

import java.util.List;

public class OrdersRepository {
    private EntityManager entityManager ;
    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Orders> findAll(){
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("Orders.All");
        List<Orders> orders =   query.getResultList() ;
        entityManager.close();
        return  orders ;

    }

    public Orders findById(int id) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Orders.Orderdetail");
        query.setParameter("orderNumber",id);
        List<Orders> Orders = query.getResultList();
        em.close();
        return Orders.size()==0? null : Orders.get(0);
    }
    public List<Orders> findByCustomerNumber(int CustomerNumber) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Orders.ByCustomer");
        query.setParameter("customerNumber",CustomerNumber);
        List<Orders> Orders = query.getResultList();
        em.close();
        return Orders.size()==0? null : Orders;
    }

}
