package ua.com.lviv.tc.repositories;

import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.Product;

import java.util.Map;

public interface BucketRepository extends CrudRepository<Bucket, Long> {

    Map<Product, Integer> getProductsInBucket(Long bucketId);

    Integer getProductsCountInBucket(Long bucketId);

    void addProduct(Long bucketId, Long productId);

    void deleteProduct(Long bucketId, Long productId);

    void updateProduct(Long bucketId, Long productId, Integer count);
}
