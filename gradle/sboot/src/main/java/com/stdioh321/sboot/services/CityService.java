package com.stdioh321.sboot.services;

import com.stdioh321.sboot.entities.h2.City;
import com.stdioh321.sboot.repositories.h2.CityRepository;
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

    public City add(City city) {
        return cityRepository.saveAndFlush(city);
    }

    public List<?> getByFull(String fields, String q) {
        return cityRepository.findByFull(fields, q, null);
    }
}
