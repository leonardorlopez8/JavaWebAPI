package com.educacionit.servicios;

import java.util.List;
import java.util.ListIterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementacion.mysql.UsuarioImplementacion;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioControlador {
	// creamos el objeto implementacion
	private UsuarioImplementacion implementacion = new UsuarioImplementacion();

	// Devolvemos la lista de Usuarios
	@Path("/listar")
	@GET
	public List<Usuario> listar() {
		return implementacion.listar();
	}

	@POST
	@Path("/agregar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregar(Usuario usuario) {
		implementacion.guardar(usuario);
		return Response.ok(usuario).build();
	}

	// actualizar
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Usuario usuario) {
		implementacion.guardar(usuario);
		return Response.ok(usuario).build();
	}

	// BUSCAR USUARIOS
	// query param
	@GET
	@Path("/buscar")
	public Response buscarPorQP(@QueryParam("correo") String correo) {
		Usuario usuario = implementacion.buscar(correo);
		// is el usuario viene en null quiere decir que no existe
		if (null == usuario) {
			// recurso no encontrado
			return Response.status(404).build();
		}
		return Response.ok(usuario).build();
	}

	// buscar Por Recurso
	@GET
	@Path("/buscar/{correo}")
	public Response buscarPorURN(@PathParam("correo") String correo) {
		Usuario usuario = implementacion.buscar(correo);

		if (null == usuario) {
			// recurso no encontrado
			return Response.status(404).build();
		}
		return Response.ok(usuario).build();
	}

	@DELETE
	@Path("/eliminar")
	public Response eliminar(Usuario usuario) {
		return Response.ok(implementacion.eliminar(usuario)).build();
	}

	// agregar una lista completa
	@POST
	@Path("/agregarLista")
	public List<Usuario> agregarLista(List<Usuario> usuarios) {
		ListIterator<Usuario> it = usuarios.listIterator();
		// agregamos inteligencia para que nos devuelva solo lo que inserto
		// efectivamente. No lo que actualizo.
		while (it.hasNext()) {
			Usuario usuario = it.next();
			// si el usuario existe entonces entra en el if e inserta/actualiza y tambien
			// remueve de la lista
			if (null != implementacion.buscar(usuario.getCorreo())) {
				// Guarda y remueve de la lista
				implementacion.guardar(usuario);
				it.remove();
			} else {
				// lo guarda pero no remueve de la lista (usuarios nuevos)
				implementacion.guardar(usuario);
			}
		}
		// retorno la lista que solo va a tener los elementos que no existian antes
		// pero inserto

		return usuarios;
	}

	@POST
	@Path("/agregarFormulario")
	// en este caso no es necesario indicarle el tipo que va a consumir
	// Pero si le indicamos que los parametros que recibe el metodo
	// son PARAMETROS DE FORMULARIO
	public Response agregarFormulario(@FormParam("correo") String correo, @FormParam("clave") String clave) {
		Usuario usuario = new Usuario();
		usuario.setCorreo(correo);
		usuario.setClave(clave);
		implementacion.guardar(usuario);
		return Response.ok(usuario).build();
	}

	
	
	
	
	
	
	
}
