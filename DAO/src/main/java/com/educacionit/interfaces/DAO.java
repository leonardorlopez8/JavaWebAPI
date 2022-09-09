package com.educacionit.interfaces;

import java.util.List;

public interface DAO <E, K> {
	
	E buscar(K k);
	
	Boolean guardar(E e);
	
	Boolean eliminar(E e);
	
	List<E> listar();
	
}
