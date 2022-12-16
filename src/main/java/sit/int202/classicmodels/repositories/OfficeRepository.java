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
        Query query = getEntityManager().createNamedQuery("Office.FIND_BY_CITY_OR_COUNTRY"); //เรียก static query ที่สร้างไว้ผ่านชื่อ
        query.setParameter("city", cityOrCountry); // มีค่าเป็น undefined ได้ เพราะเป็น OR
        query.setParameter("country", cityOrCountry);
        return query.getResultList();//เอาผล
    }

    public List<Office> findAll() {
        return getEntityManager().createQuery("select o from Office o").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public boolean insert(Office office) { //ต้องมี entityManager ก่อนเสมอ //เพิ่ม row ของ Office
        try {
            EntityManager entityManagerF = getEntityManager();
            entityManagerF.getTransaction().begin(); //เริ่ม
            entityManagerF.persist(office); //เซฟ entity into db
            entityManagerF.getTransaction().commit(); //คอมมิต
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(String officeCode) { //ลบด้วย String officeCode โดยไปค้นหาใน obj ก่อน
        EntityManager entityManagerF = getEntityManager();
        Office office = find(officeCode);//ค้นหา ตาม officeCode
        if (office != null) {
            entityManagerF.getTransaction().begin();
            entityManagerF.remove(office);
            entityManagerF.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean delete(Office office) { //ได้ obj มาเลย อาจจะมาจากการ query
        if (office != null) {
            EntityManager entityManagerF = getEntityManager();
            if (entityManagerF.contains(office)) {//เช็คว่ามีมั้ย ใน db  [SAVE ลง DB แล้ว]
                entityManagerF.getTransaction().begin();
                entityManagerF.remove(office);
                entityManagerF.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());// [ยังไม่ SAVE ลง DB] ค้นหาโดยไอดีของ Obj นั้น แล้วค่อยลบ
            }
        }
        return false;
    }

    //use for update
    public EntityTransaction getTransaction() {
        return getEntityManager().getTransaction(); //ดูว่าทำงานอะไรไปบ้าง
    }


}
