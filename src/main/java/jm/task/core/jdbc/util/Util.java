package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    Connection connection;
    Driver driver;
    private static final String URL = "jdbc:mysql://localhost:3306/db_test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException s) {
            s.printStackTrace();
        }

        return connection;
    }

    public Util() {
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Подключение открыто!");
            }
        } catch (SQLException throwables) {
            System.err.println("Не удалось загрузить класс драйвера!");
        }

    }
}
