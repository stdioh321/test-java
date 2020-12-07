package com.mycompany.app.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/tmp", "root", "includestdioh");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
