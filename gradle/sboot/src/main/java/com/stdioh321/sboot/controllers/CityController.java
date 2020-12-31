package com.stdioh321.sboot.controllers;


import com.stdioh321.sboot.entities.mysql.State;
import com.stdioh321.sboot.entities.mysql.City;
import com.stdioh321.sboot.exceptions.ApiError;
import com.stdioh321.sboot.exceptions.EntityValidationException;
import com.stdioh321.sboot.repositories.mysql.StateRepository;
import com.stdioh321.sboot.repositories.mysql.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("${api.url.v1}")
public class CityController {

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private StateRepository stateRepo;


    @ResponseBody
    @GetMapping("/city")
    public List<City> getCities() {
        return cityRepo.findAll();
    }

    @ResponseBody
    @GetMapping("/state")
    public List<State> getStates() {
        return stateRepo.findAll();
    }

    @ResponseBody
    @PostMapping("/tmp")
    public ResponseEntity<Object> doTmp(@RequestBody @Valid City city, BindingResult result) {
        if (result.hasErrors()) {
            throw new EntityValidationException(result.getFieldErrors());
        }

        
        State state = stateRepo.findById(city.getState().getId()).orElseThrow(() -> new EntityNotFoundException("State not found"));
        try {


            city.setState(state);
            city = cityRepo.saveAndFlush(city);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(city, HttpStatus.OK);
    }

}
