package ua.com.lviv.tc.repositories.impl;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.ProductRepository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private static ProductRepositoryImpl instance;
    private final EntityManager em = EntityManagerClass.getInstance();

    private ProductRepositoryImpl() {
        em.getTransaction().begin();
    }

    public static ProductRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ProductRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Product save(Product product) {
//        em.getTransaction().begin();
        em.persist(product);
//        em.getTransaction().commit();
//        em.getTransaction().
        return product;
    }

    @Override
    public void update(Product product) {
//        em.getTransaction().begin();
        Query query = em.createNamedQuery("updateProduct");
        query.setParameter(1, product.getCount());
        query.setParameter(2, product.getDescription());
        query.setParameter(3, product.getName());
        query.setParameter(4, product.getPrice());
        query.setParameter(5, product.getId());
        query.executeUpdate();
//        em.getTransaction().commit();
    }


    @Override
    public List<Product> findAll() {
//        em.getTransaction().begin();
        TypedQuery<Product> query = em.createNamedQuery("findAllProducts", Product.class);
        return query.getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
//        em.getTransaction().begin();
        return Optional.ofNullable(em.find(Product.class, id));
    }

    @Override
    public void deleteById(Long id) {
//        em.getTransaction().begin();
        Query query = em.createNamedQuery("deleteProductById");
        query.setParameter(1, id);
        query.executeUpdate();
//        em.getTransaction().commit();
    }
}
