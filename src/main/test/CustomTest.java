import org.junit.jupiter.api.Test;
import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

public class CustomTest {

    @Test
    void updateProject() {
        EntityManager em = EntityManagerClass.getInstance();
        Product product = new Product("testproduct", "testdesc", new BigDecimal(100), 3);
        TypedQuery<Product> query = em.createNamedQuery("update Product p set p.name = ?1 where p" +
                ".id = ?2", Product.class);
        query.setParameter(1, "test");
        query.setParameter(2, 1L);
        query.executeUpdate();
//        em.getTransaction().begin();
//        em.persist(product);
//        em.getTransaction().commit();

    }
}
