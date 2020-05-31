package ua.com.lviv.tc.repositories.impl;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@NamedQueries({
        @NamedQuery(name = "update", query = "update Product p set p.count = ?1, p.description = " +
                "?2, p.name = ?3, p.price = ?4 where p.id = ?5"),
        @NamedQuery(name = "findAll", query = "select p from Product p"),
        @NamedQuery(name = "deleteById", query = "delete from Product p where p.id = ?1")
})
public class ProductRepositoryImpl implements ProductRepository {

    private static ProductRepositoryImpl instance;
    private final EntityManager em = EntityManagerClass.getInstance();

    private ProductRepositoryImpl() {
    }

    public static ProductRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ProductRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Product save(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        return product;
    }

    @Override
    public void update(Product product) {
        em.getTransaction().begin();
        TypedQuery<Product> query = em.createNamedQuery("update", Product.class);
        query.setParameter(1, product.getCount());
        query.setParameter(2, product.getDescription());
        query.setParameter(3, product.getName());
        query.setParameter(4, product.getPrice());
        query.setParameter(5, product.getId());
        query.executeUpdate();
        em.getTransaction().commit();
    }


    @Override
    public List<Product> findAll() {
        em.getTransaction().begin();
        TypedQuery<Product> query = em.createNamedQuery("findAll", Product.class);
        return query.getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        em.getTransaction().begin();
        return Optional.ofNullable(em.find(Product.class, id));
    }

    @Override
    public void deleteById(Long id) {
        em.getTransaction().begin();
        TypedQuery<Product> query = em.createNamedQuery("deleteById", Product.class);
        query.setParameter(1, id);
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
