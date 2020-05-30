package ua.com.lviv.tc.repositories.impl;

import org.apache.log4j.Logger;
import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.repositories.BucketRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class BucketRepositoryImpl implements BucketRepository {

    private static final Logger log = Logger.getLogger(BucketRepositoryImpl.class);
    private Connection connection = ConnectionManager.getConnection();
    private static BucketRepositoryImpl instance;

    private BucketRepositoryImpl(){
    }

    public static BucketRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BucketRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Bucket save(Bucket bucket) {
        LocalDate date = bucket.getPurchaseDate().toLocalDate();
        LocalTime time = bucket.getPurchaseDate().toLocalTime();
        String dateTime = date + " " + time;
        try (PreparedStatement statement = connection.prepareStatement("insert into bucket(purchase_date) value (?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setTimestamp(1, Timestamp.valueOf(dateTime));
            statement.execute();
            try (ResultSet result = statement.getGeneratedKeys()) {
                result.next();
                bucket.setId(result.getInt(1));
            }
        } catch (SQLException e) {
            log.error("Error while saving bucket " + bucket.toString(), e);
        }
        return bucket;
    }

    @Override
    public void update(Bucket bucket) {
//        List<Integer> productsInBucket = getProductsInBucket(bucket);
//        for (Integer id : bucket.getProductsId()) {
//            if (productsInBucket.contains(id)) {
//                try (PreparedStatement statement = connection.prepareStatement("update bucket set user_id = ?, product_id = ?, purchase_date = ? where id = ?")) {
//                    statement.setInt(1, bucket.getUserId());
//                    statement.setInt(2, id);
//                    statement.setTimestamp(3, Timestamp.from(Instant.from(bucket.getPurchaseDate())));
//                    statement.setInt(4, bucket.getId());
//                    statement.execute();
//                } catch (SQLException e) {
//                    log.error("Error while updating bucket " + bucket.toString(), e);
//                }
//            } else {
//                try (PreparedStatement statement = connection.prepareStatement("insert into bucket(id, user_id, product_id, purchase_date) value (?, ?, ?, ?)")) {
//                    statement.setInt(1, bucket.getId());
//                    statement.setInt(2, bucket.getUserId());
//                    statement.setInt(3, id);
//                    statement.setTimestamp(4, Timestamp.from(Instant.from(bucket.getPurchaseDate())));
//                    statement.execute();
//                } catch (SQLException e) {
//                    log.error("Error while updating bucket " + bucket.toString(), e);
//                }
//            }
//
//        }
    }

    @Override
    public List<Bucket> findAll() {
        List<Bucket> buckets = new ArrayList<>();
        for (Integer id : getBucketsId()) {
            Optional<Bucket> currentBucket = findById(id);
            if (currentBucket.isPresent()) {
                buckets.add(currentBucket.get());
            } else {
                log.error("Error from bucket with id " + id);
            }
        }
        return buckets;
    }

    @Override
    public Optional<Bucket> findById(Integer id) {
        Bucket bucket = null;
        try (PreparedStatement statement = connection.prepareStatement("select * from bucket where id = ?")) {
            statement.setInt(1, id);
            int bucketId = 0;
            LocalDateTime date = null;
            try (ResultSet result = statement.executeQuery()) {
                result.next();
                bucketId = result.getInt("id");
                date = result.getTimestamp("purchase_date").toLocalDateTime();
            }
            bucket = new Bucket(bucketId, date);
        } catch (SQLException e) {
            log.error("Error while finding bucket by id " + id, e);
        }
        return Optional.ofNullable(bucket);
    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("delete from bucket where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while deleting bucket by id " + id, e);
        }
    }

    private List<Integer> getBucketsId() {
        List<Integer> bucketsId = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select distinct (id) from bucket"); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                bucketsId.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            log.error("Error while read count in bucket");
        }
        return bucketsId;
    }

    @Override
    public Map<Product, Integer> getProductsInBucket(Integer bucketId) {
        Map<Product, Integer> products = new TreeMap<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from bucket_product join product on product.id = product_id where bucket_id = ?")) {
            statement.setInt(1, bucketId);
            try (ResultSet result = statement.executeQuery()) {
                while(result.next()) {
                    int productId = result.getInt("product_id");
                    int productCount = result.getInt("product_count");
                    int productCountInStorage = result.getInt("count");
                    String productName = result.getString("name");
                    String productDescription = result.getString("description");
                    BigDecimal productPrice = result.getBigDecimal("price");
                    Product product = new Product(productId, productName, productDescription, productPrice, productCountInStorage);
                    products.put(product, productCount);
                }
            }
        } catch (SQLException e) {
            log.error("Error while read products with bucket by id " + bucketId, e);
        }
        return products;
    }

    @Override
    public void addProduct(Integer bucketId, Integer productId) {
        try (PreparedStatement statement = connection.prepareStatement("insert into bucket_product values (?, ?, 1)")) {
            statement.setInt(1, bucketId);
            statement.setInt(2, productId);
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while adding product " + productId + " to bucket by id " + bucketId, e);
        }
    }

    @Override
    public void deleteProduct(Integer bucketId, Integer productId) {
        try (PreparedStatement statement = connection.prepareStatement("delete from bucket_product where bucket_id = ? and product_id = ?")) {
            statement.setInt(1, bucketId);
            statement.setInt(2, productId);
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while deleting product " + productId + " from bucket by id " + bucketId, e);
        }
    }

    @Override
    public void updateProduct(Integer bucketId, Integer productId, Integer count) {
        try (PreparedStatement statement = connection.prepareStatement("update bucket_product set product_count = ? where bucket_id = ? and product_id = ?")) {
            statement.setInt(1, count);
            statement.setInt(2, bucketId);
            statement.setInt(3, productId);
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while updating product " + productId + " in bucket by id " + bucketId, e);
        }
    }

    @Override
    public Integer getProductsCountInBucket(Integer bucketId) {
        Integer count = 0;
        try (PreparedStatement statement = connection.prepareStatement("select count(*) from bucket_product where bucket_id = ?")) {
            statement.setInt(1, bucketId);
            try (ResultSet result = statement.executeQuery()) {
                result.next();
                count = result.getInt(1);
            }
        } catch (SQLException e) {
            log.error("Error while read products count in bucket by id " + bucketId, e);
        }
        return count;
    }
}
