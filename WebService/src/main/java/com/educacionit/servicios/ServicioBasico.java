package com.educacionit.servicios;

import javax.jws.WebService;

@WebService
public class ServicioBasico {
      
	public int sumar(int a, int b)	{
		return a + b;
	}
	
	
}
