package com.stdioh321.tmp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/user")
public class UserController {

	
	@GET
	public String getUser() {
		return "User";
	}
}
