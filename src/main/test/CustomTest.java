import lombok.RequiredArgsConstructor;

import org.junit.jupiter.api.Test;
import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

@NamedQueries(
        @NamedQuery(name = "query", query = "select p from Product p")
)
@RequiredArgsConstructor
public class CustomTest {

    @Test
    void updateProject() {
        EntityManager em = EntityManagerClass.getInstance();

        Product product = new Product("testproduct", "testdesc", new BigDecimal(100), 3);
//        TypedQuery<Product> query = em.createNamedQuery("update Product p set p.name = ?1 where p" +
//                ".id = ?2", Product.class);
//        query.setParameter(1, "test");
//        query.setParameter(2, 1L);
//        em.getTransaction().begin();
//        Query query = em.createNativeQuery("select * from product");
//        query.executeUpdate();
//        System.out.println(em.createNativeQuery("select * from product").getResultList());
//        System.out.println(em.createNamedQuery("query", Product.class).getResultList());
//        em.getTransaction().begin();
//        System.out.println(em.createQuery("select p from Product p").getResultList());

//        System.out.println(em.createNamedQuery("query", Product.class).getResultList());
//        em.getTransaction().commit();
//        em.getTransaction().begin();
//        em.persist(product);
//        em.getTransaction().commit();
        TypedQuery<Product> query = em.createNamedQuery("query", Product.class);
        System.out.println(query.getResultList());
    }
}
