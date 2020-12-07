package com.mycompany.app;

import com.mycompany.app.entities.User;
import com.mycompany.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
class MainController {

    @Autowired
    private UserRepository userRepo;

    public void doSomething() {
        System.out.println("doSomething");
        User u = new User();
        u.setName("Malandrao");
        userRepo.save(u);
        userRepo.findAll().forEach(user -> {
            System.out.println(user.toString());
        });
    }
}