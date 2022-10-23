package com.educacionit.RestClient;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

public class App {
	public static void main(String[] args) {

		URI URL_SERVICIOS = UriBuilder.fromUri("http://localhost:8081/Rest/servicios").build();
		
		//Agregado para el delete
		ClientConfig config = new ClientConfig();
		
		config.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
		
		//Al cliente le pasamos el config
		Client cliente = ClientBuilder.newClient(config);

		Usuario usuario = new Usuario();
		usuario.setCorreo("user3@gmail.com");
		usuario.setClave("1234");

		WebTarget URL_USUARIOS = cliente.target(URL_SERVICIOS).path("usuarios");

		// agregar usuarios
		Response respuestaAgregar = URL_USUARIOS.path("agregar").request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(usuario, MediaType.APPLICATION_JSON_TYPE));

		// Imprimimos la respuesta completa
		System.out.println(respuestaAgregar);
		// el numero de la respuesta 200, 300, 400 - Decidimos que mostramos en el
		// Backend
		System.out.println(respuestaAgregar.getStatus());

		// creamos nuestro objeto usuario:
		Response respuestaUsuarioURN = URL_USUARIOS.path("buscar").path("user1@gmail.com")
				.request(MediaType.APPLICATION_JSON_TYPE).get();
		// esto nos devuelve un objeto
		System.out.println(respuestaUsuarioURN); // nos trae el objeto.
		// esto seria el response general pero yo quiero obtener el objeto. Esto se hace
		// a traves de reflection

		// dentro de readEntity() le tenemos que pasar una clase generica,
		// no como un objeto sino para que el transforme e instancie (deserialice)
		// o serialice dependiendo cual sea el ida y vuelta la clase como tal
		// como cadena de caracteres .La entidad la vamos a estar transformando
		// en la clase Usuario no como objeto, sino como clase. Como el concepto
		// de clase en Java. Es decir readEntity() va a considerar la clase como una
		// entidad
		// no como objeto.

		Usuario usuarioURN = respuestaUsuarioURN.readEntity(Usuario.class);
		System.out.println(usuarioURN);

		// Nos devuelve la lista de usuarios:
		Response respuestaLista = URL_USUARIOS.path("listar").request(MediaType.APPLICATION_JSON_TYPE).get();

		// vemos si nos sirve Usuario.class
//    	System.out.println(respuestaLista.readEntity(Usuario.class));

		// vemos si nos sirve Usuario[].class
//    	System.out.println(respuestaLista.readEntity(Usuario[].class));

		// vemos si nos sirve List.class

		List<Usuario> listaUsuarios = (List<Usuario>) respuestaLista.readEntity(List.class);
		System.out.println(listaUsuarios);

		// Eliminamos el usuario: En este caso el ".delete() no nos sirve porque no
		// recibe el
		// metodo ningun parametro. Entonces lo reemplazamos con "method("METODO",
		// "entidad")".
		// Entity.entity() representa que entidad queremos enviar. Eliminamos el
		// "usuario" que tenemos arriba
		// es decir user3@gmail.com
		Response eliminarUsuario = URL_USUARIOS.path("eliminar").request(MediaType.APPLICATION_JSON_TYPE).method("DELETE",
				Entity.entity(usuario, MediaType.APPLICATION_JSON_TYPE));

		
		
	}
}
