package com.stdioh321.webapp3.controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorHandler")

public class ErrorHandler extends HttpServlet{
		
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("ERROR");
		response.getWriter().println("ERROR");
		
	}
}
