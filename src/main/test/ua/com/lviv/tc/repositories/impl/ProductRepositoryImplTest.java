package ua.com.lviv.tc.repositories.impl;

import org.junit.jupiter.api.*;
import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepositoryImplTest {

    static EntityManager em = EntityManagerClass.getInstance();
    static ProductRepository pr = ProductRepositoryImpl.getInstance();
    private static Product product = new Product("testproduct", "testdesc", new BigDecimal(100),
            3);

    @BeforeAll
    static void create() {
        String request = "delete from Product";
        em.getTransaction().begin();
        Query query = em.createQuery(request);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    @Order(1)
    void save() {
        product = pr.save(product);
    }

    @Test
    @Order(2)
    void update() {
        this.product.setName("testproduct2");
        pr.update(product);
        this.product.setName("testproduct");
    }

    @Test
    @Order(3)
    void findAll() {
        System.out.println(pr.findAll());
    }

    @Test
    @Order(4)
    void findById() {
//        System.out.println(pr.findById(123L));
        System.out.println(pr.findById(product.getId()));
    }

    @AfterAll
    static void deleteById() {
        pr.deleteById(product.getId());
    }
}