package com.educacionit.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inicial")
public class Inicial {

	@GET
	@Path("/holamundo")
	@Produces(MediaType.TEXT_PLAIN)
	public String holaMundo() {
		return "Hola Mundo";
	}

	
}
