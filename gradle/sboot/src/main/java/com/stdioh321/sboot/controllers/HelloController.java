package com.stdioh321.sboot.controllers;


import com.stdioh321.sboot.entities.h2.State;
import com.stdioh321.sboot.entities.mysql.City;
import com.stdioh321.sboot.repositories.h2.StateRepository;
import com.stdioh321.sboot.repositories.mysql.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HelloController {

    @Autowired
    private CityRepository cityRepo;
    @Autowired
    private StateRepository stateRepository;



    @GetMapping("/hello")
    public String getHello(Model model) {
        model.addAttribute("msg", "My Message");
        List<String> names = new ArrayList<>();
        names.add("Mario");
        names.add("Luigi");
        names.add("Peach");
        names.add("Toad");
        model.addAttribute("names", names);
        return "hello";
    }

    @ResponseBody
    @GetMapping("/temp")
    public String getTemp(@RequestParam(value = "name") String name) {
        System.out.println("Name: " + name);
        return String.format("temp: %s", name);
    }

    @ResponseBody
    @GetMapping("/city")
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cityRepo.findAll().forEach(city -> cities.add(city));
        return cities;
    }
    @ResponseBody
    @GetMapping("/state")
    public List<State> getStates() {
        List<State> states = new ArrayList<>();
        stateRepository.findAll().forEach(state -> states.add(state));
        return states;
    }
    @ResponseBody
    @PostMapping(value = "/state")
    public Object postState(@Valid State state, BindingResult result, HttpServletResponse resp) {
        if (result.hasErrors()) {
            resp.setStatus(400);
            return result.getAllErrors();
        }
        state = stateRepository.save(state);

        return state;
    }

    @ResponseBody
    @PostMapping(value = "/city")
    public Object postCity(@Valid City city, BindingResult result, HttpServletResponse resp) {
        if (result.hasErrors()) {
            resp.setStatus(400);
            return result.getAllErrors();
        }
        city = cityRepo.save(city);

        return city;
    }

    @ResponseBody
    @GetMapping(value = "/city/{id}")
    public Object postCity(@PathVariable("id") String id, HttpServletResponse resp) {
        Optional o = cityRepo.findById(id);
        if(o.isEmpty()) {
            resp.setStatus(404);
            return null;
        }

        return o.get();
    }

    @ResponseBody
    @GetMapping("/city-name/{name}")
    public List<City> getCitiesByName(@PathVariable("name") @NotBlank String name){

        return cityRepo.findByCityName(name);
    }

    @GetMapping("/form-view")
    public String getForm() {
        return "form";
    }
}
