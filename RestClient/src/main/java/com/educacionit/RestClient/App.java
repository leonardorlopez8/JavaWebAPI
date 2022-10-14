package com.educacionit.RestClient;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class App 
{
    public static void main( String[] args )
    {

        
    	URI URL_SERVICIOS = UriBuilder.fromUri("http://localhost:8081/Rest/servicios").build();
        Client cliente = ClientBuilder.newClient();
    	
        Usuario usuario = new Usuario();
        usuario.setCorreo("user3@gmail.com");
        usuario.setClave("1234");
        
        WebTarget URL_USUARIOS = cliente.target(URL_SERVICIOS).path("usuarios");
        
        //agregar usuarios
        Response respuestaAgregar = URL_USUARIOS.path("agregar").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(usuario, MediaType.APPLICATION_JSON_TYPE));
       
        //Imprimimos la respuesta completa
    	System.out.println(respuestaAgregar);
    	//el numero de la respuesta 200, 300, 400 - Decidimos que mostramos en el Backend
    	System.out.println(respuestaAgregar.getStatus());
    	
    	
    	
    }
}
