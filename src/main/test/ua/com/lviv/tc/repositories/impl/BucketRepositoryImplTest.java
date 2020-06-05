package ua.com.lviv.tc.repositories.impl;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.BucketRepository;
import ua.com.lviv.tc.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BucketRepositoryImplTest {

    static EntityManager em = EntityManagerClass.getInstance();
    static BucketRepository br = BucketRepositoryImpl.getInstance();
    static ProductRepository pr = ProductRepositoryImpl.getInstance();
    private static LocalDateTime dt = LocalDateTime.now();
    private static Instant instant = dt.atZone(ZoneId.of("Europe/Paris")).toInstant();
    static Bucket bucket = new Bucket(instant);
    static Product product = new Product("testproduct", "testdesc", new BigDecimal(100),
            3);

    @BeforeAll
    static void create() {
        String request = "delete from Bucket";
        String request2 = "delete from BucketProduct";
        em.getTransaction().begin();
        Query query = em.createQuery(request);
        Query query2 = em.createQuery(request2);
        query2.executeUpdate();
        query.executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    @Order(1)
    void save() {
        System.out.println(bucket.getId());
        bucket = br.save(bucket);
        System.out.println(bucket.getId());
    }

    @Test
    @Order(2)
    void findAll() {
        System.out.println(br.findAll());
    }

    @Test
    @Order(3)
    void findById() {
        System.out.println(br.findById(bucket.getId()));
    }

    @Test
    @Order(4)
    void getProductsInBucket() {
        System.out.println(br.getProductsInBucket(bucket.getId()));
    }

    @Test
    @Order(5)
    void addProduct() {
//        Product prod = new Product(1L, "a", "a", new BigDecimal(3), 3);
//        Bucket buck = new Bucket(1L, Instant.from(LocalDateTime.now().atZone(ZoneId.of("Europe/Paris")).toInstant()));
//        pr.save(prod);
//        em.persist(prod);
//        em.persist(buck);
//        br.addProduct(buck.getId(), prod.getId());
//        System.out.println(br.findAll());
        product = pr.save(product);
        br.addProduct(bucket.getId(), product.getId());
        System.out.println(br.findAll());
    }

    @Test
    @Order(6)
    void updateProduct() {
        br.updateProduct(bucket.getId(), product.getId(), 10);
        System.out.println(br.findAll());
    }

    @Test
    @Order(7)
    void getProductsCountInBucket() {
        System.out.println(br.getProductsCountInBucket(bucket.getId()));
    }

    @Test
    @Order(8)
    void deleteProduct() {
        br.deleteProduct(bucket.getId(), product.getId());
        System.out.println(br.findAll());
    }

    @AfterAll
    static void deleteById() {
        br.deleteById(bucket.getId());
        pr.deleteById(product.getId());
    }
}