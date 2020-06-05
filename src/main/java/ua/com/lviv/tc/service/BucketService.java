package ua.com.lviv.tc.service;

import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.Product;

import java.util.Map;

public interface BucketService extends CrudService<Bucket, Long> {

    Map<Product, Integer> getProductsInBucket(Long bucketId);

    Integer getProductsCountInBucket(Long bucketId);

    void addProduct(Long bucketId, Long productId);

    void deleteProduct(Long bucketId, Long productId);

    void updateProduct(Long bucketId, Long productId, Integer count);
}
