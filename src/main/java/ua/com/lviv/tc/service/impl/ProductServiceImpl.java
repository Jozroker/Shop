package ua.com.lviv.tc.service.impl;

import org.apache.log4j.Logger;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.ProductRepository;
import ua.com.lviv.tc.repositories.impl.ProductRepositoryImpl;
import ua.com.lviv.tc.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private Logger log = Logger.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl() {
        this.productRepository = ProductRepositoryImpl.getInstance();
    }

    @Override
    public void save(Product product) {
        log.debug("save product " + product);
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        log.debug("update product " + product);
        productRepository.update(product);
    }

    @Override
    public List<Product> findAll() {
        log.debug("find all products");
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        log.debug("find product by id " + id);
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("delete product by id " + id);
        productRepository.deleteById(id);
    }
}
