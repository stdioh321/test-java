package com.stdioh321.mvc.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stdioh321.mvc.entities.Contact;

public class Hello extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("HELLO SERVICE");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] tmps = new String[10];
		for (String s : tmps) {
			s = "tmp: " + new Random().nextInt();

//			resp.getWriter().println(s);
		}

		var c = new Contact();
		c.setId("123");
		c.setName("Positivo");
		req.setAttribute("contact", c);
		RequestDispatcher rd = req.getRequestDispatcher("/tmp.jsp");

		rd.include(req, resp);
		rd.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		var tmp = req.getParameter("tmp");

		resp.getWriter().println("TMP: " + tmp);
	}

}
