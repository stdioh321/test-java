package com.stdioh321.springboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
    @GetMapping("/hello-view")
    public String getHello(Model model){
        model.addAttribute("msg", "ESTOU AQUI, HAHAHA");
        return "hello";
    }
}
