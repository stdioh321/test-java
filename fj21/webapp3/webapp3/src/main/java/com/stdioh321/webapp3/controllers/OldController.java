package com.stdioh321.webapp3.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stdioh321.webapp3.entities.User;
import com.stdioh321.webapp3.repositories.UserDao;

public class OldController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			UserDao ud = new UserDao();
			List<User> users = ud.getAll();
			for (User user : users) {
				resp.getWriter().format("%s - %s\n", user.getId(), user.getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		resp.getWriter().println("Old Style with web.xml");
	}
}
