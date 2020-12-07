package com.mycompany.app;

import com.mycompany.app.connections.ConnectionFactory;
import com.mycompany.app.entities.User;
import com.mycompany.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.*;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 */

@SpringBootApplication
public class App {


    public static void main(String[] args) throws SQLException {
        SpringApplication.run(App.class);

        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("myPU");
        EntityManager eM = eMF.createEntityManager();
        eM.getTransaction().begin();
        System.out.println("------------------ JPA ------------------");
        User u = new User();
        u.setName("Luigi " + Instant.now().toEpochMilli());
        eM.persist(u);
        eM.getTransaction().commit();
        List<User> users = eM.createNamedQuery("all", User.class).getResultList();
        for (User us : users) {
            System.out.println(us.toString());
        }
        eM.close();
        eMF.close();
    }

    @Bean
    public CommandLineRunner doSomething(MainController mC) {
        return (args) -> {
            System.out.println("------------------ SPRING BOOT JPA ------------------");
            mC.doSomething();
        };
    }

    /*@Bean
    public CommandLineRunner demo(UserRepository userRepo) {
        return (args) -> {
            System.out.println("CommandLineRunner");
            User u = new User();
            u.setName("Malandrao");
            userRepo.save(u);
            userRepo.findAll().forEach(user -> {
                System.out.println(user.toString());
            });


        };

    }*/
}
