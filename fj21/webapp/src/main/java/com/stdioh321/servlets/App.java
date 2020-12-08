package com.stdioh321.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class App extends HttpServlet {
	public App() {
		System.out.println("APP Constructor called!");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FirstServlet \"Service\" method(inherited) called");
		System.out.println("FirstServlet \"DoGet\" method called");
		var out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Something");
		out.println("</h1>");
		out.println("</body>");

		out.println("</html>");
		throw new Exception("Sou mane");
//		storeInSessionAndRespond(request, response);

	}

}