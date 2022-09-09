package com.educacionit.DAO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementacion.mysql.UsuarioImplementacion;
import com.educacionit.interfaces.UtilidadesFecha;

public class App {
	public static void main(String[] args) throws ParseException {
		UsuarioImplementacion implementacion = new UsuarioImplementacion();

		// Insertarmos un usuario
		Usuario usuario1 = new Usuario("user1@gmail.com", "4321", new Date(),
				UtilidadesFecha.getStringAFecha("2022-09-08"));
        //usamos la implementacion para insertar el usuario
		implementacion.guardar(usuario1);
		//Nos deberia dar error porque el usuario ya existe
		
		implementacion.guardar(new Usuario("user2@gmail.com", "7777", new Date(),
				UtilidadesFecha.getStringAFecha("2022-09-08")));
		
		//Listamos todos los Usuarios
		List<Usuario> lista = implementacion.listar();
		lista.forEach(System.out::println);
	}
}






















