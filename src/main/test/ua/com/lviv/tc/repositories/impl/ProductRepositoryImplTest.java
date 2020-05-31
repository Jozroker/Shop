package ua.com.lviv.tc.repositories.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

class ProductRepositoryImplTest {

    EntityManager em = EntityManagerClass.getInstance();
    static ProductRepository pr = ProductRepositoryImpl.getInstance();
    private static Product product = new Product("testproduct", "testdesc", new BigDecimal(100),
            3);

    @BeforeEach
    void clean() {
        String request = "delete from Product";
        em.getTransaction().begin();
        Query query = em.createNamedQuery(request, Product.class);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    @Order(1)
    void save() {
        pr.save(product);
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
        System.out.println(pr.findById(123L));
        System.out.println(pr.findById(product.getId()));
    }

    @AfterAll
    static void deleteById() {
        pr.deleteById(product.getId());
    }
}