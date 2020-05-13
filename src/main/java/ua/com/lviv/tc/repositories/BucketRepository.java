package ua.com.lviv.tc.repositories;

import ua.com.lviv.tc.entity.Bucket;

import java.util.Map;

public interface BucketRepository extends CrudRepository<Bucket, Integer> {

    Map<Integer, Integer> getProductsInBucket(Bucket bucket);

    Integer getProductsCountInBucket(Integer bucketId);

    void addProduct(Integer bucketId, Integer productId);

    void deleteProduct(Integer bucketId, Integer productId);

    void updateProduct(Integer bucketId, Integer productId, Integer count);
}
