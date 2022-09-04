package com.educacionit.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConexionMySQL {

	// por defecto tendremos un metodo que nos devuelva una conexion a la base
	default Connection getConexion() {
		Connection conexion = null;
		Properties propiedades = new Properties();

		// la conexion se va a instanciar a travez del DriveManager
		try {
			// Como concepto general, si levantamos la aplicacion con un .jar el archivo de
			// propiedades puede estar en cualquier lado.
			// Pero cuando le decimos que busque en el directorio el archivo. Cuando es un
			// .jar lo va a buscar desde la ubicacion
			// del proyecto, en este caso C:\Users\Leonardo\Desktop\JAVA WEB
			// API\Workspace\DAO . Si lo hace desde un servidor. Es decir,
			// un servidor es el que esta compilando el codigo, no se va a buscar desde la
			// carpeta donde se esta ejecutando el proyecto.
			// Se va a buscar directamente desde el servidor. En este caso como compilaremos
			// el proyecto en un .jar el archivo properties
			// se necesitara compilar con el proyecto. Porque luego lo vamos a precisar al
			// DAO como dependencia de otros proyectos.

			// el archivo de properties lo va a ir a buscar a
			// src/resources/database.properties.
			// Usamos File.separator porque no sabemos el sistema operativo

			propiedades.load(new FileInputStream(
					new File("src" + File.separator + "resources" + File.separator + "database.properties")));

			// luego de crear el objeto propiedades y el correspondiente archivo
			// database.properties le asignamos a cada
			// variable el valor correspondiente

			String URL = propiedades.getProperty("url");
			String USER = propiedades.getProperty("user");
			String PASS = propiedades.getProperty("pass");
			conexion = DriverManager.getConnection(URL, USER, PASS);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conexion;
	}

}
