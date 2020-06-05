package ua.com.lviv.tc.service.impl;

import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.ProductRepository;
import ua.com.lviv.tc.repositories.impl.ProductRepositoryImpl;
import ua.com.lviv.tc.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private static ProductService instance = new ProductServiceImpl();

    public ProductServiceImpl() {
        this.productRepository = ProductRepositoryImpl.getInstance();
    }

    public static ProductService getInstance() {
        return instance;
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
