package com.stdioh321.jersey.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/hello")
public class Hello extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param = req.getParameter("param"); // Retrieves <input type="text" name="description">
		Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">
//	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//	    InputStream fileContent = filePart.getInputStream();

		resp.getWriter().println("PARAM: " + param);
		resp.getWriter().println("FILE: " + filePart.getSubmittedFileName());
		resp.getWriter().println(Paths.get("").toAbsolutePath());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().println("nothing here");
		resp.getWriter().println(Paths.get("").toAbsolutePath().toString());
	}
}
