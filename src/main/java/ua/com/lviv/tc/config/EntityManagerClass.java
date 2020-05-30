package ua.com.lviv.tc.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerClass {

     private static EntityManagerFactory emf;

     private EntityManagerClass() {}

     public static EntityManager getInstance() {
          if (emf == null) {
               emf = Persistence.createEntityManagerFactory("validateUnit");
          }
          return emf.createEntityManager();
     }
}
