package com.mycompany.app;

import com.mycompany.repositories.ConnectionFactory;
import java.sql.Connection;

/**
 * Hello world!
 */
public class App {
    public static void main(String[]
                                    args) {
        System.out.println("Hello World!");
        try {
            Connection conn = ConnectionFactory.getConnection();

            System.out.println("Connection CREATED");

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
