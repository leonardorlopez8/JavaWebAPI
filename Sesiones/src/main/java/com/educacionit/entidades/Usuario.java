package com.educacionit.entidades;

import java.util.concurrent.atomic.AtomicLong;

public class Usuario {

	// Atributos
	private Long id;
	private String correo;
	private String clave;
	// Incrementador que se inicia en 1
	private static AtomicLong contador = new AtomicLong(1);

	// Constructor por defecto
	public Usuario() {
		//el id autoincrementado tambien lo tenemos que tener con el constructor por defecto
		id = contador.getAndIncrement();
	}

	// Constructor con todos los campos menos el id (porque queremso que lo
	// autoincremente
	public Usuario(String correo, String clave) {
		super();
		//hacemos que el id se autoincremente en 1 unidad
		id = contador.getAndIncrement();
		this.correo = correo;
		this.clave = clave;
	}

	// toString()
	@Override
	public String toString() {
		return "[id=" + id + ", correo=" + correo + "]";
	}

	// Getters and Setters de todos los atributos menos de "contador"
	// Los Getters and Setters siempre hay que hacerlos por convencion. Porque si
	// trabajamos con algun framework, este no va
	// a saber donde guardar u obtener los valores
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
