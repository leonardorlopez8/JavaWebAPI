package com.educacionit.implementacion.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.interfaces.ConexionMySQL;
import com.educacionit.interfaces.DAO;
import com.educacionit.interfaces.UtilidadesFecha;

public class UsuarioImplementacion implements DAO<Usuario, String>, ConexionMySQL{

	private PreparedStatement psBuscar;
	private PreparedStatement psInsertar;
	private PreparedStatement psEliminar;
	private PreparedStatement psActualizar;
	private PreparedStatement psListar;
	//clave para desencriptar
	private final String KEY = "JavaWebAPI"; //no deberia estar harcodeada en el codigo. Tampoco en el archivo properties
	
	//Podemos considerar el Statement o PreparedStatement
	@Override
	public Usuario buscar(String correo) {
		//cada vez que entre al metodo significa que vamos a hacer una consulta preparada a la BBDD
        Usuario usuario = null;
        //buscamos un usuario
        String query = "select cast(AES_DECRYPT(clave, ?) as char(50)) as clave, fechaActualizacion, fechaCreacion from usuarios where correo = ?"; //no es necesario buscar el correo porque lo trae por parametro
        //instanciamos el psBuscar con la sentencia sql
       //Y llamamos directamente al metodo default getConexion()
        try {
			psBuscar = getConexion().prepareStatement(query);//el metodo preparedStatement() me devuelve una instancia del objeto psBuscar
		    //le pasamos el correo al preparedStatement psBuscar el correo es el String correo que me estan pasando en el metodo
			//buscar() 
			psBuscar.setString(1, KEY);
			psBuscar.setString(2, correo);
			
			//Trabajamos con el ResultSet
			ResultSet resultado = psBuscar.executeQuery(); 
			//como devuelve un solo elemento no es necesario realizar un ciclo
			if(resultado.next()) {
				usuario = new Usuario();
				usuario.setCorreo(correo); //lo tomo por parametro, entonces no es necesario buscarlo
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
	public Boolean insertar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean actualizar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

}
