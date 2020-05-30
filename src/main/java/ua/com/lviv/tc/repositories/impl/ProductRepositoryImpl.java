//package ua.com.lviv.tc.repositories.impl;
//
//import org.apache.log4j.Logger;
//import ua.com.lviv.tc.entity.Product;
//import ua.com.lviv.tc.repositories.ProductRepository;
//
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class ProductRepositoryImpl implements ProductRepository {
//
//    private static final Logger log = Logger.getLogger(ProductRepositoryImpl.class);
//    private Connection connection = ConnectionManager.getConnection();
//    private static ProductRepositoryImpl instance;
//
//    private ProductRepositoryImpl() {
//
//    }
//
//    public static ProductRepositoryImpl getInstance() {
//        if (instance == null) {
//            instance = new ProductRepositoryImpl();
//        }
//        return instance;
//    }
//
//    @Override
//    public Product save(Product product) {
//        try (PreparedStatement statement = connection.prepareStatement("insert into product(name, description, price, count) value (?, ?, ?, ?)")) {
//            statement.setString(1, product.getName());
//            statement.setString(2, product.getDescription());
//            statement.setBigDecimal(3, product.getPrice());
//            statement.setInt(4, product.getCount());
//            statement.execute();
//        } catch (SQLException e) {
//            log.error("Error while saving product " + product.toString(), e);
//        }
//        return product;
//    }
//
//    @Override
//    public void update(Product product) {
//        try (PreparedStatement statement = connection.prepareStatement("update product set name = ?, description = ?, price = ?, count = ? where id = ?")) {
//            statement.setString(1, product.getName());
//            statement.setString(2, product.getDescription());
//            statement.setBigDecimal(3, product.getPrice());
//            statement.setInt(4, product.getCount());
//            statement.setInt(5, product.getId());
//            statement.execute();
//        } catch (SQLException e) {
//            log.error("Error while updating product " + product.toString(), e);
//        }
//    }
//
//    @Override
//    public List<Product> findAll() {
//        List<Product> products = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement("select * from product"); ResultSet result = statement.executeQuery()) {
//            while (result.next()) {
//                Integer productId = result.getInt("id");
//                String name = result.getString("name");
//                String description = result.getString("description");
//                BigDecimal price = result.getBigDecimal("price");
//                Integer count = result.getInt("count");
//                Product product = new Product(productId, name, description, price, count);
//                products.add(product);
//            }
//        } catch (SQLException e) {
//            log.error("Error while finding all products", e);
//        }
//        return products;
//    }
//
//    @Override
//    public Optional<Product> findById(Integer id) {
//        Product product = null;
//        try (PreparedStatement statement = connection.prepareStatement("select * from product where id = ?")) {
//            statement.setInt(1, id);
//            try (ResultSet result = statement.executeQuery()) {
//                result.next();
//                String name = result.getString("name");
//                String desc = result.getString("description");
//                BigDecimal price = result.getBigDecimal("price");
//                Integer count = result.getInt("count");
//                product = new Product(id, name, desc, price, count);
//            }
//        } catch (SQLException e) {
//            log.error("Error while finding product by id " + id, e);
//        }
//        return Optional.ofNullable(product);
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        try (PreparedStatement statement = connection.prepareStatement("delete from product where id = ?")) {
//            statement.setInt(1, id);
//            statement.execute();
//        } catch (SQLException e) {
//            log.error("Error while deleting product by id " + id, e);
//        }
//    }
//}
