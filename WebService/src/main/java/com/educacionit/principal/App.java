package com.educacionit.principal;

import javax.xml.ws.Endpoint;


import com.educacionit.servicios.ServicioBasico;
import com.educacionit.servicios.UsuarioServicio;


public class App {
     public static void main(String[] args) {
         //Le decimos a donde va a apuntar e instanciamos el servicio
    // 	 Endpoint.publish("http://localhost:8081/servicio/suma", new ServicioBasico());
         
    	 //Agregamos otro endpoint
    	 Endpoint.publish("http://localhost:8082/servicio/usuario", new UsuarioServicio());
    	 
    	 
	}
	
}
