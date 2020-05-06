package ua.com.lviv.tc.repositories.impl;

import org.apache.log4j.Logger;
import ua.com.lviv.tc.config.ConnectionManager;
import ua.com.lviv.tc.entity.User;
import ua.com.lviv.tc.repositories.UserRepository;

import javax.swing.text.html.Option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private static final Logger log = Logger.getLogger(UserRepositoryImpl.class);
    private Connection connection = ConnectionManager.getConnection();
    private static UserRepositoryImpl instance;

    private UserRepositoryImpl() {

    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void save(User user) {
        try (PreparedStatement statement = connection.prepareStatement("insert into user(fname, lname, password, email, role) value (?, ?, ?, ?, ?)")) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getRole());
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while saving user " + user.toString(), e);
        }
    }

    @Override
    public void update(User user) {
        try (PreparedStatement statement = connection.prepareStatement("update user set fname = ?, lname = ?, password = ?, email = ?, role = ? where id = ?")) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getRole());
            statement.setInt(6, user.getId());
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while updating user " + user.toString(), e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from user"); ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                Integer userId = result.getInt("id");
                String email = result.getString("email");
                String firstName = result.getString("fname");
                String lastName = result.getString("lname");
                String role = result.getString("role");
                String password = result.getString("password");
                User user = new User(userId, firstName, lastName, password, role, email);
                users.add(user);
            }
        } catch (SQLException e) {
            log.error("Error while finding all users", e);
        }
        return users;
    }

    @Override
    public Optional<User> findById(Integer id) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("select * from user where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                result.next();
                String email = result.getString("email");
                String firstName = result.getString("fname");
                String lastName = result.getString("lname");
                String role = result.getString("role");
                String password = result.getString("password");
                user = new User(id, firstName, lastName, password, role, email);
            }
        } catch (SQLException e) {
            log.error("Error while finding user by id " + id, e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("delete from user where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            log.error("Error while deleting user by id " + id, e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("select * from user where email = ?")) {
            statement.setString(1, email);
            try (ResultSet result = statement.executeQuery()) {
                result.next();
                Integer id = result.getInt("id");
                String firstName = result.getString("fname");
                String lastName = result.getString("lname");
                String role = result.getString("role");
                String password = result.getString("password");
                user = new User(id, firstName, lastName, password, role, email);
            }
        } catch (SQLException e) {
            log.error("Error while finding user by email " + email, e);
        }
        return Optional.ofNullable(user);
    }
}
