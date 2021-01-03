package com.stdioh321.sboot.services;

import com.stdioh321.sboot.entities.mysql.City;
import com.stdioh321.sboot.repositories.mysql.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements GenericService<City> {

    @Autowired
    public CityRepository cityRepository;


    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public List<?> getByCityName(String name){

        return cityRepository.findByCityName(name);
    }
    public City add(City city) {
        return cityRepository.saveAndFlush(city);
    }
}
