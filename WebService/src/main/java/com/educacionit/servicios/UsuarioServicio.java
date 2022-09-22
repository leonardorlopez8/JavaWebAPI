package com.educacionit.servicios;

import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementacion.mysql.UsuarioImplementacion;

//el @WebService es una anotacion pero que puede recibir parametros. Name: nombre del servicio

@WebService(name = "ServicioUsuario", portName="ServicioUsuario")
public class UsuarioServicio {
	private static UsuarioImplementacion implementacion = new UsuarioImplementacion();

	// aqui crearemos un metodo que agregue el usuario que nosotros tenemos en el
	// DAO
	
	//operationName es como el metodo que se va a hacer desde el Webservice, aqui le cambiamos el nombre.
	//el Resultado webresult le cambiamos el nombre a "agregado"
	//adicionalmente le podemos poner un tag al parametro
	@WebMethod(operationName="guardarUsuario")
	@WebResult(name="guardado")
	public boolean agregar(@WebParam(name="usuario") Usuario usuario) {
		// para insertar un usuario precisamos un objeto de tipo implementacion
		return implementacion.guardar(usuario);
		//retorna un true si guardo de lo contrario false.
				
	}

	@WebMethod(operationName="eliminarUsuario")
	@WebResult(name="eliminado")
	public boolean eliminar(@WebParam(name="usuario") Usuario usuario) {
		return implementacion.eliminar(usuario);
	}

	
	@WebMethod(operationName="buscarUsuario")
	@WebResult(name="usuario")
	public Usuario buscar(@WebParam(name="correo") String correo) {
		return implementacion.buscar(correo);
	}
    
//	@WebMethod(operationName="listarUsuarios")
//	@WebResult(name="usuarios")
//	public List<Usuario> listar(){
//		return implementacion.listar();
//	}
	
	//si tenemos algun error con las listas retornamos un arreglo de usuarios
	@WebMethod(operationName="listarUsuarios")
	@WebResult(name="usuarios")
	public Usuario[] listar(){
	    List<Usuario> lista = implementacion.listar();
	    //especificamos el tamaño del arreglo
	    Usuario[] usuarios = new Usuario[lista.size()];
	    //transformamos la lista a un arreglo
	    lista.toArray(usuarios);
      return usuarios;
	}
	
}
