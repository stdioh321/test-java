package com.stdioh321.webapp3.controllers;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		throw new IOException("ERROR");
		AtomicInteger ai  = new AtomicInteger(1);
		ai.set(3);
		response.getWriter().println("Hello Controller");
	}
}
