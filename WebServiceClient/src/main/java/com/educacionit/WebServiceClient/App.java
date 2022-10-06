package com.educacionit.WebServiceClient;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.servicios.UsuarioServicio;
import com.educacionit.servicios.UsuarioServicioProxy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws RemoteException
    {
        List<Usuario> usuarios; 	
    	UsuarioServicio servicioUsuario = new UsuarioServicioProxy();
    	
    	usuarios = Arrays.asList(servicioUsuario.listar());
        
    	usuarios.forEach((e)->System.out.println(e));
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    	
    	
    }
}
