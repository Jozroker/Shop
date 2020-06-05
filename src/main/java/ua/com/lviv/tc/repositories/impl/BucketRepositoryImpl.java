package ua.com.lviv.tc.repositories.impl;

import ua.com.lviv.tc.config.EntityManagerClass;
import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.BucketProduct;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.BucketRepository;
import ua.com.lviv.tc.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

public class BucketRepositoryImpl implements BucketRepository {

    private static BucketRepositoryImpl instance;
    private ProductRepository productRepository = ProductRepositoryImpl.getInstance();
    EntityManager em = EntityManagerClass.getInstance();

    private BucketRepositoryImpl(){
        em.getTransaction().begin();
    }

    public static BucketRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BucketRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Bucket save(Bucket bucket) {
//        LocalDate date = LocalDateTime.ofInstant(bucket.getPurchaseDate(), ZoneOffset.UTC).toLocalDate();
//        LocalTime time = LocalDateTime.ofInstant(bucket.getPurchaseDate(), ZoneOffset.UTC).toLocalTime();
//        String dateTime = date + " " + time;
//        try (PreparedStatement statement = connection.prepareStatement("insert into bucket(purchase_date) value (?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
//            statement.setTimestamp(1, Timestamp.valueOf(dateTime));
//            statement.execute();
//            try (ResultSet result = statement.getGeneratedKeys()) {
//                result.next();
//                bucket.setId(result.getInt(1));
//            }
//        } catch (SQLException e) {
//            log.error("Error while saving bucket " + bucket.toString(), e);
//        }
        em.persist(bucket);
        em.getTransaction().commit();
        em.getTransaction().begin();
        return bucket;
    }

    @Override
    public void update(Bucket bucket) {
    }

    @Override
    public List<Bucket> findAll() {
        TypedQuery<Bucket> query = em.createNamedQuery("findAllBuckets", Bucket.class);
        return query.getResultList();
    }

    @Override
    public Optional<Bucket> findById(Long id) {
        return Optional.ofNullable(em.find(Bucket.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Query query = em.createNamedQuery("deleteBucketById");
        query.setParameter(1, id);
        query.executeUpdate();
        em.getTransaction().commit();
        em.getTransaction().begin();
    }

    private List<Long> getBucketsId() {
        TypedQuery<Long> query = em.createNamedQuery("getBucketsId", Long.class);
        return query.getResultList();
    }

    @Override
    public Map<Product, Integer> getProductsInBucket(Long bucketId) {
        Map<Product, Integer> products = new TreeMap<>();
        TypedQuery<BucketProduct> query = em.createNamedQuery("getProductsInBucket",
                BucketProduct.class);
        query.setParameter(1, bucketId);
        query.getResultList().forEach(elem -> products.put(elem.getProduct(), elem.getProductCount()));
        return products;
    }

    @Override
    @SuppressWarnings("all")
    public void addProduct(Long bucketId, Long productId) {
//        Query query = em.createNamedQuery("addProduct");
//        query.setParameter(1, bucketId);
//        query.setParameter(2, productId);
        Product product = productRepository.findById(productId).get();
        Bucket bucket = findById(bucketId).get();
        BucketProduct bucketProduct = new BucketProduct(bucket, product, 1);
        em.persist(bucketProduct);
        em.getTransaction().commit();
        em.getTransaction().begin();
    }

    @Override
    public void deleteProduct(Long bucketId, Long productId) {
        Query query = em.createNamedQuery("deleteProductFromBucket");
        query.setParameter(1, bucketId);
        query.setParameter(2, productId);
        query.executeUpdate();
        em.getTransaction().commit();
        em.getTransaction().begin();
    }

    @Override
    @SuppressWarnings("all")
    public void updateProduct(Long bucketId, Long productId, Integer count) {
        Product product = productRepository.findById(productId).get();
        Bucket bucket = findById(bucketId).get();
        BucketProduct bucketProduct = new BucketProduct(bucket, product, count);
        em.merge(bucketProduct);
        em.getTransaction().commit();
        em.getTransaction().begin();
    }

    @Override
    public Integer getProductsCountInBucket(Long bucketId) {
        Query query = em.createNamedQuery("getProductsCountInBucket");
        query.setParameter(1, bucketId);
        return Math.toIntExact((Long) query.getSingleResult());
    }
}
