package ua.com.lviv.tc.repositories.impl;

import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.User;
import ua.com.lviv.tc.repositories.BucketRepository;
import ua.com.lviv.tc.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepositoryImpl instance;
    EntityManager em = EntityManagerClass.getInstance();
    private BucketRepository bucketRepository = BucketRepositoryImpl.getInstance();

    private UserRepositoryImpl() {
        em.getTransaction().begin();
    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public User save(User user) {
        Bucket bucket = new Bucket(LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant());
        bucket = bucketRepository.save(bucket);
        user.setBucket(bucket);
//        em.persist(bucket);
        em.persist(user);
        em.getTransaction().commit();
        em.getTransaction().begin();
        return user;
    }

    @Override
    public void update(User user) {
        em.merge(user);
        em.getTransaction().commit();
        em.getTransaction().begin();
    }

    @Override
    public List<User> findAll() {
        List<User> users;
        TypedQuery<User> query = em.createNamedQuery("findAllUsers", User.class);
        users = query.getResultList();
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null;
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> userOptional = findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Query query = em.createNamedQuery("deleteUserById");
            query.setParameter(1, id);
            query.executeUpdate();
            em.getTransaction().commit();
            em.getTransaction().begin();
            bucketRepository.deleteById(user.getBucket().getId());
            em.getTransaction().commit();
            em.getTransaction().begin();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user;
        TypedQuery<User> query = em.createNamedQuery("findUserByEmail", User.class);
        query.setParameter(1, email);
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }
        return Optional.ofNullable(user);
    }
}
