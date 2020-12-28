package com.stdioh321.sboot.seeder;

import com.stdioh321.sboot.entities.mysql.City;
import com.stdioh321.sboot.repositories.mysql.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;


@Configuration
public class MysqlSeeder {
    @Autowired
    private CityRepository cityRepository;

    @EventListener()
    public void seed(ContextRefreshedEvent event) {
        System.out.println("--------- MysqlSeeder EventListener START ---------");
        if (cityRepository.count() < 1) {
            for (int i = 0; i < 10; i++) {
                City c = new City();
                c.setName("City " + i);
                c.setPopulation((long) i + 1);
                cityRepository.save(c);

            }
        }

        System.out.println("--------- MysqlSeeder EventListener END ---------");
    }
}
