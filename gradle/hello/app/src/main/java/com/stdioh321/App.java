/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.stdioh321;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new App().getGreeting());

    }
}