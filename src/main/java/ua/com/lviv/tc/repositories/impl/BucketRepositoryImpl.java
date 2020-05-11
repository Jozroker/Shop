package ua.com.lviv.tc.repositories.impl;

import org.apache.log4j.Logger;
import ua.com.lviv.tc.config.ConnectionManager;
import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.User;
import ua.com.lviv.tc.repositories.BucketRepository;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        try (PreparedStatement statement = connection.prepareStatement("insert into bucket(purchase_date) value (?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setTimestamp(1, Timestamp.from(Instant.from(bucket.getPurchaseDate())));
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
//        Bucket bucket = null;
//        try (PreparedStatement statement = connection.prepareStatement("select * from bucket where id = ?")) {
//            statement.setInt(1, id);
//            List<Integer> products = new ArrayList<>();
//            int bucketId = 0;
//            int userId = 0;
//            LocalDate date = null;
//            try (ResultSet result = statement.executeQuery()) {
//                while(result.next()) {
//                    bucketId = result.getInt("id");
//                    userId = result.getInt("user_id");
//                    date = result.getDate("purchase_date").toLocalDate();
//                    products.add(result.getInt("product_id"));
//                }
//            }
//            bucket = new Bucket(bucketId, userId, products, date);
//        } catch (SQLException e) {
//            log.error("Error while finding bucket by id " + id, e);
//        }
//        return Optional.ofNullable(bucket);
        return null;
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

    private List<Integer> getProductsInBucket(Bucket bucket) {
        List<Integer> products = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select product_id from bucket where id = ?")) {
            statement.setInt(1, bucket.getId());
            try (ResultSet result = statement.executeQuery()) {
                while(result.next()) {
                    products.add(result.getInt("id"));
                }
            }
        } catch (SQLException e) {
            log.error("Error while read products with bucket " + bucket.toString(), e);
        }
        return products;
    }
}
