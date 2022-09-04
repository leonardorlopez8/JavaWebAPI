package com.educacionit.interfaces;

import java.util.List;

public interface DAO <E, K> {

	//Busca un usuario. La E representa que me devuelve un objeto generico. Es decir
	//no solo se puede utilizar para usuarios. Entonces despues por parametro le vamos a indicar
	//el tipo de cato que quiero que nos devuelva
	//E : elemento
	//K: generico que representa cualquier tipo de dato. En lugar de poner String ya que el PK es el correo
	//Poniendo K no nos limitamos a un tipo de dato en particular.
	
	E buscar(K k);
	
	Boolean insertar(E e);
	
	Boolean eliminar(E e);
	
	Boolean actualizar(E e);
	
	List<E> listar(E e);
	
}
