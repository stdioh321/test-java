package com.stdioh321.mvc.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.stdioh321.mvc.entities.Contact;
import com.stdioh321.mvc.entities.User;

@Controller
public class TmpController {

	@RequestMapping(value = "/tmp-controller/{tmp}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String tmp(@Valid Contact c, BindingResult result, ModelMap model,@PathVariable String tmp) {
		if (result.hasFieldErrors()) {
			System.out.println("HAS ERRRORS");
			return "home/home";
		} else
			System.out.println(c);
		System.out.println(tmp);
		// org.springframework.web.servlet.DispatcherServlet
		model.addAttribute("contact", c);
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
	public String getHome() {
		return "home/home";
	}

	@ResponseBody
	@GetMapping(value = "/tmp")
	public String getTmp(ModelMap model, HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ClassNotFoundException, JsonProcessingException {

		System.out.println("Req ID: " + req.getParameter("id"));

//		var m = new HashMap<String, String>();
//		m.put("home", "home321");
//		model.addAttribute("home", m);
//		model.addAttribute("title", "Some Title");

		ModelAndView mv = new ModelAndView();
		Contact c = new Contact();
		c.setId("asdas");
		c.setName("asdasxzhcjxh8");

		mv.addObject("title", c);
		mv.addObject("d", Calendar.getInstance().getTime());
		mv.setViewName("home/home");

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/fj21?user=root&password=includestdioh");
		var cs = conn.prepareStatement("SELECT * FROM users;");
		var rs = cs.executeQuery();
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			User u = new User();
			u.setId(rs.getString("id"));
			u.setName(rs.getString("name"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setCreatedAt(rs.getTimestamp("created_at"));
			u.setUpdatedAt(rs.getTimestamp("updated_at"));
			users.add(u);
		}
		conn.close();

		mv.addObject("users", users);
//		return mv;
		resp.setContentType("application/json");

		return new ObjectMapper().writeValueAsString(users);
	}
}
