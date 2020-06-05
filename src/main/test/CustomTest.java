import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.ProductRepository;
import ua.com.lviv.tc.repositories.impl.ProductRepositoryImpl;

import java.math.BigDecimal;


class BucketRepositoryImplTest {
    ProductRepository pr = ProductRepositoryImpl.getInstance();

    @Test
    void create() {
        Product product = new Product("a", "a", new BigDecimal(3), 3);
        System.out.println(product);
        Product newProduct = pr.save(product);
        System.out.println(product);
    }
}