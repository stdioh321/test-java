package com.mycompany.app.repositories;

import com.mycompany.app.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface  UserRepository extends CrudRepository<User,Long> {
}
