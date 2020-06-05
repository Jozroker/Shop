package ua.com.lviv.tc.repositories.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.entity.User;
import ua.com.lviv.tc.repositories.BucketRepository;
import ua.com.lviv.tc.repositories.ProductRepository;
import ua.com.lviv.tc.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryImplTest {

    static EntityManager em = EntityManagerClass.getInstance();
    static UserRepository ur = UserRepositoryImpl.getInstance();
    static BucketRepository br = BucketRepositoryImpl.getInstance();
    static User user = new User("Oleg", "Neck", "pass", "USER", "mail@mail");

    @BeforeAll
    static void create() {
        String request = "delete from Bucket";
        String request2 = "delete from User";
        em.getTransaction().begin();
        Query query = em.createQuery(request);
        Query query2 = em.createQuery(request2);
        query.executeUpdate();
        query2.executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    @Order(1)
    void save() {
        System.out.println(user.getId());
        System.out.println(user.getBucket());
        user = ur.save(user);
        System.out.println(user.getId());
        System.out.println(user.getBucket());
    }

    @Test
    @Order(2)
    void update() {
        user.setFirstName("New First Name");
        ur.update(user);
    }

    @Test
    @Order(3)
    void findAll() {
        System.out.println(ur.findAll());
    }

    @Test
    @Order(4)
    void findById() {
        System.out.println(ur.findById(user.getId()));
    }

    @Test
    @Order(5)
    void findByEmail() {
        String email = user.getEmail();
        User current = ur.findByEmail(email).get();
        System.out.println(current);
        System.out.println(current.getFirstName());
    }

    @AfterAll
    static void deleteById() {
        ur.deleteById(user.getId());
    }
}