package com.educacionit.DAO;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementacion.mysql.UsuarioImplementacion;

public class App 
{
    public static void main( String[] args )
    {
      //Probamos conexion con la base
    	Usuario usuario = null;
    	UsuarioImplementacion impl = new UsuarioImplementacion();
    	
    	//Recuperamos el usuario
    	usuario = impl.buscar("user1@gmail.com");
        System.out.println(usuario);
    	
    }
}
