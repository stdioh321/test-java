package com.stdioh321.sboot.controllers;


import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String getHello(Model model){
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
    public String getTemp(@RequestParam(value = "name")  String name){
        System.out.println("Name: " + name);
        return String.format("temp: %s", name);
    }
}
