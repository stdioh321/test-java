package com.stdioh321.mvc.controllers;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stdioh321.mvc.entities.Contact;

@Controller
public class TmpController {

	@PostMapping(value = "/tmp-controller")
	public String tmp(@Valid Contact c, BindingResult result) {
		if (result.hasFieldErrors()) {
			System.out.println("HAS ERRRORS");
			return "home/home";
		} else
			System.out.println(c);
		// org.springframework.web.servlet.DispatcherServlet
		System.out.println("{contact.msg}");
		return "tmp";
	}

	@GetMapping(value = "/tmp-controller")
	public String getTmp(Contact c, ModelMap model) {
		// org.springframework.web.servlet.DispatcherServlet

		System.out.println(c);
		model.addAttribute("contact", c);
		return "tmp";
	}

	@GetMapping(value = "/home")
	public ModelAndView getHome(ModelMap model) {

//		var m = new HashMap<String, String>();
//		m.put("home", "home321");
//		model.addAttribute("home", m);
//		model.addAttribute("title", "Some Title");
		
		ModelAndView mv = new ModelAndView();
		Contact c = new Contact();
		c.setId("asdas");
		c.setName("asdasxzhcjxh8");
		mv.addObject("title", c);
		mv.setViewName("home/home");
		return mv;
	}
}
