package com.shevchuk.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/db_shevchuk_connection?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String password = "qwerty";
    private static Connection connection = null;

    private ConnectionManager() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password); //get connection to db
            } catch (SQLException exception) {
                System.out.println("SQLException " + exception.getMessage());
                System.out.println("SQLState " + exception.getSQLState());
                System.out.println("VendorError " + exception.getErrorCode());
            }
        }
        return connection;
    }

    public static Connection exitConnection() {
        if (connection != null) {
            try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println("can't close connection");
            }
        }
        return connection;
    }
}
