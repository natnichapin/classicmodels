package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.EntityManagerBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class OfficeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findByCityOrCountry(String cityOrCountry) {
        cityOrCountry = cityOrCountry.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("Office.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();
    }

    public List<Office> findAll() {
        return getEntityManager().createQuery("select o from Office o").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public boolean insert(Office office) {
        try {
            EntityManager entityManagerF = getEntityManager();
            entityManagerF.getTransaction().begin();
            entityManagerF.persist(office);
            entityManagerF.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(String officeCode) {
        EntityManager entityManagerF = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManagerF.getTransaction().begin();
            entityManagerF.remove(office);
            entityManagerF.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean delete(Office office) {
        if (office != null) {
            EntityManager entityManagerF = getEntityManager();
            if (entityManagerF.contains(office)) {
                entityManagerF.getTransaction().begin();
                entityManagerF.remove(office);
                entityManagerF.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }

    //use for update
    public EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }


}
