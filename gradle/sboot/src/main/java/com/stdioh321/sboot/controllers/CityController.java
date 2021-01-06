package com.stdioh321.sboot.controllers;


import com.stdioh321.sboot.annotations.CustomAnn;
import com.stdioh321.sboot.entities.mysql.State;
import com.stdioh321.sboot.entities.mysql.City;
import com.stdioh321.sboot.exceptions.EntityValidationException;
import com.stdioh321.sboot.repositories.mysql.StateRepository;
import com.stdioh321.sboot.repositories.mysql.TmpRepository;
import com.stdioh321.sboot.services.CityService;
import com.stdioh321.sboot.utils.Tmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Random;

@Controller
@RequestScope
@RequestMapping("${api.url.v1}")
public class CityController {

    @Autowired
    private TmpRepository tmp;

    @Autowired
    @Qualifier(value = "mycity")
    private City c;

    @Autowired
    private CityService cityService;

    @Autowired
    private StateRepository stateRepo;


    @ResponseBody
    @GetMapping("/city")
    public ResponseEntity getCities(@PathParam("fields") String fields, @PathParam("q") String q) {

        var tmpCities = cityService.cityRepository.findByFields(fields, q);
        for (Object o : tmpCities) {
            System.out.println(o);
        }

        return new ResponseEntity(tmp.findByFull(fields,q,null), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/city")
    public ResponseEntity postCity(@Valid @RequestBody City city, BindingResult result) {
        if (result.hasErrors()) throw new EntityValidationException(result.getFieldErrors());
        return new ResponseEntity(cityService.add(city), HttpStatus.OK);


    }

    @ResponseBody
    @GetMapping("/city/{name}")
    public ResponseEntity getByCityName(@PathVariable("name") String name) {
        return new ResponseEntity(cityService.getByCityName(name), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/state")
    public List<State> getStates() {
        return stateRepo.findAll();
    }


}
