package com.educacionit.implementacion.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.interfaces.ConexionMySQL;
import com.educacionit.interfaces.DAO;
import com.educacionit.interfaces.UtilidadesFecha;

public class UsuarioImplementacion implements DAO<Usuario, String>, ConexionMySQL {

	private PreparedStatement psBuscar;
	private PreparedStatement psInsertar;
	private PreparedStatement psEliminar;
	private PreparedStatement psActualizar;
	private PreparedStatement psListar;
	private final String KEY = "JavaWebAPI"; // no deberia estar harcodeada en el codigo. Tampoco en el archivo
												// properties

	@Override
	public Usuario buscar(String correo) {

		Usuario usuario = null;
		String query = "select cast(AES_DECRYPT(clave, ?) as char(50)) as clave, fechaActualizacion, fechaCreacion from usuarios where correo = ?"; // no
																																					// es
		try {

			// si la instancia se encuentra en null lo instancio, de lo contrario sigo
			// adelante
			if (null == psBuscar) {
				psBuscar = getConexion().prepareStatement(query);
			}

			psBuscar.setString(1, KEY);
			psBuscar.setString(2, correo);

			ResultSet resultado = psBuscar.executeQuery();
			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setCorreo(correo); // lo tomo por parametro, entonces no es necesario buscarlo
				usuario.setClave(resultado.getString("clave"));
				usuario.setFechaCreacion(UtilidadesFecha.getStringAFecha(resultado.getString("fechaCreacion")));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public Boolean eliminar(Usuario usuario) {
		String query = "delete from usuarios where correo=?";
		try {
			if (null == psEliminar) {
				psEliminar = getConexion().prepareStatement(query);
			}
			psEliminar.setString(1, usuario.getCorreo());

			return psEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Usuario> listar() {
		// este caso lo podriamos haber hecho con un Statement sencillo porque no
		// tenemos inyeccion SQL. Es decir,
		// no le estamos indicando algun parametro.
		// Pero seguimos utilizando la "consulta preparada" porque es mucho mas rapida
		// la consulta. El motor de BBDD
		// no la evalua de nuevo. "Evaluar" significa que la BBDD conoce la tabla, los
		// campos y la estructura del query

		List<Usuario> listaUsuarios = new ArrayList<>();
		String query = "select correo, cast(AES_DECRYPT(clave, ?) as char(50)) as clave, fechaActualizacion, fechaCreacion from usuarios";

		try {
			if (null == psListar) {
				psListar = getConexion().prepareStatement(query);
			}
			psListar.setString(1, KEY);
			ResultSet resultado = psListar.executeQuery();

			while (resultado.next()) {
				// Aqui necesitamos un "usuario" nuevo en cada iteracion
				Usuario usuario = new Usuario();
				usuario.setCorreo(resultado.getString("correo"));
				usuario.setClave(resultado.getString("clave"));
				usuario.setFechaCreacion(UtilidadesFecha.getStringAFecha(resultado.getString("fechaCreacion")));
				listaUsuarios.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	
	@Override
	public Boolean guardar(Usuario usuario) {
		//Este metodo evita que se genere el error de usuario duplicado
		Usuario aux = buscar(usuario.getCorreo());
		if(null == aux) {
			return insertar(usuario);
		}else {
			return actualizar(usuario);
		}
		
	}
	
	
	//METODOS PRIVADOS
	private Boolean insertar(Usuario usuario) {
		// la fecha de actualizacion la borramos por ahora, la haremos en base a
		// triggers
		String query = "insert into usuarios(correo, clave, fechaCreacion)values(?, AES_ENCRYPT(?,?), ?); ";
		try {
			// como mejores practicas se recomienda colocar el null primero
			if (null == psInsertar) {
				// y dentro del if lo instanciamos
				psInsertar = getConexion().prepareStatement(query);
			}
			psInsertar.setString(1, usuario.getCorreo());
			psInsertar.setString(2, usuario.getClave());
			psInsertar.setString(3, KEY);
			// le pasamos la fecha del momento
			psInsertar.setString(4, UtilidadesFecha.getFechaAString(new Date()));
			// ejecutamos la instruccion

			// Como retornamos un booleano
			return psInsertar.executeUpdate() == 1; // si retorna 1 significa que inserto correctamente el usuario
			// de lo contrario retorna false

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// pero tenemos este retorno obligatorio, entonces le hacemos retornar false
		return false;
	}

	private Boolean actualizar(Usuario usuario) {
		// la fecha de Actualizacion no la vamos a actualizar porque se actualizara con
		// triggers
		// Actualizaremos solo la clave
		String query = "update usuarios set clave=AES_ENCRYPT(?,?) where correo = ?";
		try {
			if (null == psActualizar) {
				psActualizar = getConexion().prepareStatement(query);
			}

			psActualizar.setString(1, usuario.getClave());
			psActualizar.setString(2, KEY);
			psActualizar.setString(3, usuario.getCorreo());

			return psActualizar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}



}
