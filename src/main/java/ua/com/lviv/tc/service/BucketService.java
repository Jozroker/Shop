package ua.com.lviv.tc.service;

import ua.com.lviv.tc.entity.Bucket;

import java.util.Map;

public interface BucketService extends CrudService<Bucket, Integer> {

    Map<Integer, Integer> getProductsInBucket(Bucket bucket);

    Integer getProductsCountInBucket(Integer bucketId);

    void addProduct(Integer bucketId, Integer productId);

    void deleteProduct(Integer bucketId, Integer productId);

    void updateProduct(Integer bucketId, Integer productId, Integer count);
}
