package com.stdioh321.mvc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stdioh321.mvc.entities.Contact;

@RestController
public class GreetingController {

	
	@RequestMapping(value = "/greeting",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Contact greeting() {
		Map<String, String> m = new HashMap<>();
		m.put("a", "123");
		m.put("b", "987");
		Contact c = new Contact();
		c.setId("123");
		c.setName("Jumentao");
		return c;
	}

}
