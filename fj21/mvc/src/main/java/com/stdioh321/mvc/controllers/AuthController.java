package com.stdioh321.mvc.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stdioh321.mvc.entities.User;

@Controller
public class AuthController {

	@GetMapping("form-login")
	public String formLogin() {
		return "form-login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(@NotEmpty String username, @NotEmpty String password, HttpServletResponse resp,
			HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException {
		System.out.println(username + " : " + password);

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/fj21?user=root&password=includestdioh");
		var cs = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?;");
		cs.setString(1, username);
		cs.setString(2, password);
		var rs = cs.executeQuery();
		boolean isUser = rs.next();
		conn.close();
		ModelAndView mav = new ModelAndView();
		
		if (isUser) {
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			session.setAttribute("loggedIn", u);
			model.addAttribute("user", u);
			mav.setViewName("home");
			return mav;
		}

		resp.setStatus(404);
		
//		model.addAttribute("error", "Invalid");
		mav.addObject("error", "INVALID");
		mav.setViewName("redirect:form-login");
		return mav;

	}

}
