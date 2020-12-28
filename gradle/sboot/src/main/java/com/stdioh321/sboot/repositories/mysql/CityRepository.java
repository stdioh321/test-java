package com.stdioh321.sboot.repositories.mysql;

import com.stdioh321.sboot.entities.mysql.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/*@Repository*/
public interface CityRepository extends JpaRepository<City, String> {

    default public List<City> findByCityName(String name) {
        return this.findAll().stream().filter(city -> {
            if (city.getName().toLowerCase().contains(name.toLowerCase())) return true;
            return false;
        }).collect(Collectors.toList());
    }
}
