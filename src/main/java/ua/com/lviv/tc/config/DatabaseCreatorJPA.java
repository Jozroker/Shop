package ua.com.lviv.tc.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseCreatorJPA {

    public static void main(String[] args) {
        new DatabaseCreatorJPA().createDatabase();
    }

    public void createDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("createUnit");
        EntityManager em = emf.createEntityManager();
    }
}
