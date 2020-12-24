package com.stdioh321.jersey.rest;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stdioh321.jersey.entities.User;
import com.stdioh321.jersey.validators.IsTimestamp;

@Path("/user")
public class UserController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		var users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
		em.close();
		emf.close();
		
		return users;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User postUser(@Valid User user, @Context HttpServletRequest req) throws IOException {
		System.out.println("BEFORE");
		System.out.println(user);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(user);
		em.flush();

		em.getTransaction().commit();

		em.close();
		emf.close();

		return user;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response putUser(@Valid User user, @PathParam("id") String id) throws IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		if (u == null)
			return Response.status(404).build();
		user.setId(u.getId());

		u.update(user);
		em.getTransaction().commit();

		em.close();
		emf.close();
		return Response.ok().entity(u).build();

	}

	@Path("{id}")
	@DELETE
	public Response deleteUser(@PathParam("id") String id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		if (u == null)
			return Response.status(404).build();
		em.remove(u);
		em.getTransaction().commit();
		em.close();
		emf.close();

		return Response.ok().entity(u).build();
	}

	@Path("/tmp")
	@GET
	public Response doTmp() {
		
		throw new RuntimeException("Tudo Errado");
//		return Response.ok().build();
	}
}