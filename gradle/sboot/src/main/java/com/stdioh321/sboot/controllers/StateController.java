package com.stdioh321.sboot.controllers;


import com.stdioh321.sboot.entities.h2.State;
import com.stdioh321.sboot.exceptions.EntityValidationException;
import com.stdioh321.sboot.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestScope
@RequestMapping("${api.url.v1}/state")
public class StateController{

    @Autowired
    private StateService service;

    @Autowired
    private StateService stateService;

    @ResponseBody
    @PostMapping
    public ResponseEntity postState(@Valid @RequestBody State state, BindingResult result) {
        if (result.hasErrors()) throw new EntityValidationException(result.getFieldErrors());
        return new ResponseEntity(stateService.add(state), HttpStatus.OK);


    }


    @ResponseBody
    @GetMapping
    public List<State> getStates(@PathParam("fields") String fields, @PathParam("q") String q) {
        return stateService.getAll();
    }
    @ResponseBody
    @GetMapping("/{id}")
    public State getState(@PathVariable("id") String id) {
        return stateService.getById(id);
    }

    @ResponseBody
    @DeleteMapping(path = "/{id}")
    public State deleteState(@PathVariable("id") String id){
        return stateService.delete(id);
    }
    @ResponseBody
    @PutMapping(path = "/{id}")
    public State putState(@PathVariable("id") String id, @RequestBody State state){
        return stateService.put(id, state);
    }
}
