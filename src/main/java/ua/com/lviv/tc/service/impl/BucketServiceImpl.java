package ua.com.lviv.tc.service.impl;

import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.BucketRepository;
import ua.com.lviv.tc.repositories.impl.BucketRepositoryImpl;
import ua.com.lviv.tc.service.BucketService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BucketServiceImpl implements BucketService {

    private BucketRepository bucketRepository = BucketRepositoryImpl.getInstance();
    private static BucketServiceImpl instance;

    private BucketServiceImpl() {}

    public static BucketServiceImpl getInstance() {
        if (instance == null) {
            instance = new BucketServiceImpl();
        }
        return instance;
    }

    @Override
    public void save(Bucket bucket) {
        bucketRepository.save(bucket);
    }

    @Override
    public void update(Bucket bucket) {
        bucketRepository.update(bucket);
    }

    @Override
    public List<Bucket> findAll() {
        return bucketRepository.findAll();
    }

    @Override
    public Optional<Bucket> findById(Long id) {
        return bucketRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        bucketRepository.deleteById(id);
    }

    @Override
    public Map<Product, Integer> getProductsInBucket(Long bucketId) {
        return bucketRepository.getProductsInBucket(bucketId);
    }

    @Override
    public void addProduct(Long bucketId, Long productId) {
        bucketRepository.addProduct(bucketId, productId);
    }

    @Override
    public void deleteProduct(Long bucketId, Long productId) {
        bucketRepository.deleteProduct(bucketId, productId);
    }

    @Override
    public void updateProduct(Long bucketId, Long productId, Integer count) {
        bucketRepository.updateProduct(bucketId, productId, count);
    }

    @Override
    public Integer getProductsCountInBucket(Long bucketId) {
        return bucketRepository.getProductsCountInBucket(bucketId);
    }
}
