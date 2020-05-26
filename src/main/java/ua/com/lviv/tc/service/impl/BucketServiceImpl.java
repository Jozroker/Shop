package ua.com.lviv.tc.service.impl;

import org.apache.log4j.Logger;
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
    Logger log = Logger.getLogger(BucketServiceImpl.class);
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
        log.debug("saving bucket " + bucket);
        bucketRepository.save(bucket);
    }

    @Override
    public void update(Bucket bucket) {
        log.debug("updating bucket " + bucket);
        bucketRepository.update(bucket);
    }

    @Override
    public List<Bucket> findAll() {
        log.debug("find all buckets");
        return bucketRepository.findAll();
    }

    @Override
    public Optional<Bucket> findById(Integer id) {
        log.debug("finding bucket by id " + id);
        return bucketRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("deleting bucket by id " + id);
        bucketRepository.deleteById(id);
    }

    @Override
    public Map<Product, Integer> getProductsInBucket(Integer bucketId) {
        log.debug("getting products from bucket by id " + bucketId);
        return bucketRepository.getProductsInBucket(bucketId);
    }

    @Override
    public void addProduct(Integer bucketId, Integer productId) {
        log.debug("adding product " + productId + " to bucket by id " + bucketId);
        bucketRepository.addProduct(bucketId, productId);
    }

    @Override
    public void deleteProduct(Integer bucketId, Integer productId) {
        log.debug("deleting product " + productId + " from bucket by id " + bucketId);
        bucketRepository.deleteProduct(bucketId, productId);
    }

    @Override
    public void updateProduct(Integer bucketId, Integer productId, Integer count) {
        log.debug("updating product " + productId + " in bucket by id " + bucketId);
        bucketRepository.updateProduct(bucketId, productId, count);
    }

    @Override
    public Integer getProductsCountInBucket(Integer bucketId) {
        log.debug("getting products count from bucket by id " + bucketId);
        return bucketRepository.getProductsCountInBucket(bucketId);
    }
}
