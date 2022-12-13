package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class EntityManagerBuilder {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-models");
    //เอามาจากไฟล์ Persistence ที่ <persistence-unit name="classic-models">
    //ประกอบด้วย <provider> <class> <properties>
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
