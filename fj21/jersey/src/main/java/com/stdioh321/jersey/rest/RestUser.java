package com.stdioh321.jersey.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.Timestamp;
import java.time.*;

import com.stdioh321.jersey.entities.User;

@Path("/user")
public class RestUser {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
		User u = new User();
		u.setId(1L);
		u.setName("Mario");
		u.setCreatedAt(Timestamp.from(Instant.now()));

		return Response.ok().entity(u).build();
	}

	@Path("/add{p:/?}")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public User postUser(User user) {
		System.out.println(user);
		System.out.println("after");
		return user;
//		return Response.ok().entity(user).build();
	}
}
