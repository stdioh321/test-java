package com.stdioh321.sboot.seeder;

import com.stdioh321.sboot.entities.h2.City;
import com.stdioh321.sboot.entities.h2.State;
import com.stdioh321.sboot.repositories.h2.CityRepository;
import com.stdioh321.sboot.repositories.h2.StateRepository;
import com.stdioh321.sboot.utils.Utils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Random;


@Configuration

public class DbSeeder {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;

    @EventListener

    public void seed(ContextRefreshedEvent event) {
        System.out.println("--------- DbSeeder EventListener START ---------");
        if (stateRepository.count() < 1) {
            for (int i = 0; i < 3; i++) {
                State s = new State();
                s.setName("state " + i);
                s.setInitial("s" + i);
                s = stateRepository.saveAndFlush(s);

                City c = new City();
                c.setName("city " + Utils.getRandomString(5));
                c.setState(s);
                cityRepository.save(c);
            }
        }
        /*if (cityRepository.count() < 1) {
            for (int i = 0; i < 10; i++) {
                City c = new City();
                c.setName("City " + i);
                c.setPopulation((long) i + 1);
                cityRepository.save(c);

            }
        }*/

        System.out.println("--------- DbSeeder EventListener END ---------");
    }
}
