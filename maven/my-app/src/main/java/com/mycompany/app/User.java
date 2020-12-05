package com.mycompany.app;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class User {
    private String id;
    private String name;
    private Date createdAt;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public User(String name, Date createdAt){
        this.setId(UUID.randomUUID().toString());
        this.setName(name);
        this.setCreatedAt(createdAt);


    }
}
