package com.educacionit.configuraciones;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/servicios")
public class Configuracion extends ResourceConfig {
	public Configuracion() {
		packages("com.educacionit.servicios");
	}

}
