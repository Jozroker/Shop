package ua.com.lviv.tc.config;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final Logger log = Logger.getLogger(ConnectionManager.class);
    private static final String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
    private static final  String user = "root";
    private static final String password = "";
    private static Connection connection;

    public static Connection getConnection() {
        log.info("creating connection to database");
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                log.error("Error while closing connection to database with url " + url, e);
            }
        }
        log.debug("connection was created successfully");
        return connection;
    }

    public static void closeConnection() {
        log.debug("close connection");
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Error while closing connection to database with url " + url, e);
            }
        }
    }
}


