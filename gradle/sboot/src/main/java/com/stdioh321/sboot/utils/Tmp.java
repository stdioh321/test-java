package com.stdioh321.sboot.utils;

import com.stdioh321.sboot.entities.mysql.City;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import javax.enterprise.inject.Produces;

@ApplicationScope
/*@Getter
@Setter*/

@Component

public class Tmp {
    private String name;

    public Tmp() {
        name = "TMP";
        System.out.println("------- TMP CONSTRUCTOR -------");
    }

    @Bean
    /*@Qualifier("mycity")*/
    public City getCity1() {
        var c = new City();
        c.setName("abc");
        c.setId("123");
        return c;
    }

    @Bean
    @Qualifier("mycity")
    public City getCity2() {
        System.out.println("QUALIFIER MYCITY");
        var c = new City();
        c.setName("DEF");
        c.setId("987");
        return c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
