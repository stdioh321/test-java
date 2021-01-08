package com.stdioh321.sboot.controllers;


import com.stdioh321.sboot.entities.h2.State;
import com.stdioh321.sboot.entities.h2.City;
import com.stdioh321.sboot.exceptions.EntityValidationException;
import com.stdioh321.sboot.repositories.h2.TmpRepository;
import com.stdioh321.sboot.services.CityService;
import com.stdioh321.sboot.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestScope
@RequestMapping("${api.url.v1}")
public class CityController {
    @Autowired
    private Environment env;

    @Autowired
    private TmpRepository tmp;

    @Autowired
    @Qualifier(value = "mycity")
    private City c;

    @Autowired
    private CityService cityService;

    @Autowired
    private StateService stateService;


    @ResponseBody
    @GetMapping("/city")
    public ResponseEntity getCities(@PathParam("fields") String fields, @PathParam("q") String q,@Value("${tmp}") String tmp) {

        return new ResponseEntity(cityService.getByFull(fields, q), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/city")
    public ResponseEntity postCity(@Valid @RequestBody City city, BindingResult result) {
        if (result.hasErrors()) throw new EntityValidationException(result.getFieldErrors());
        return new ResponseEntity(cityService.add(city), HttpStatus.OK);


    }




}
