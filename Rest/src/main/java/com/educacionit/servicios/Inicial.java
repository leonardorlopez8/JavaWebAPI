package com.educacionit.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inicial")
public class Inicial {

	private static List<String> nombres = new ArrayList<String>();
	
	@GET
	@Path("/holamundo")
	@Produces(MediaType.TEXT_PLAIN)
	public String holaMundo() {
		return "Hola Mundo";
	}

	@POST  //entramos por el metodo POST
	@Consumes(MediaType.APPLICATION_JSON) //que tipo de dato consume (vamos a trabajar con JSON), es decir seria el procedimiento opuesto a @Produces del metodo anterior
	@Produces(MediaType.APPLICATION_JSON) //y luego tambien produce un application JSON
	@Path("/agregar")
	public Response agregar(String nombre) {
		
		
		//chequea si el nombre comienza con la letra "L"
		if(nombre.contains("L")) {
			//devolvemos un codigo de error que lo podemos encontrar en https://developer.mozilla.org/es/docs/Web/HTTP/Status
			return Response.status(406).build();
		}
		 
		nombres.add(nombre);
		//sino comienza con la letra "L" devuelve el nombre en formato JSON, porque el servicio Produce un JSON
		return Response.ok(nombre).build();  
	}
	
	 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public Response listar() {
		return Response.ok(nombres).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
