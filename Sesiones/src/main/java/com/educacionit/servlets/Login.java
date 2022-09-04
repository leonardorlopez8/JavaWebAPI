package com.educacionit.servlets;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.entidades.Usuario;

/**
 * Servlet implementation class Login
 */

//El WebServlet recibe el parametro "name" cuyo nombre es login. Y le agregamos la url a la que
//queremos que escuche o que interprete esta anotacion. La URL va a ser, el nombre del proyecto+ / +nombre de la pagina+ /+ login

@WebServlet(name="login", urlPatterns= "/login" )
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //A. Creamos la lista de Usuarios
	private static List<Usuario> usuarios;
    
	
	
	
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
    	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		llenarUsuarios();
	}



		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
			//viene un parametro que se llama sesion desde el index.jsp, lo tomo en el login servlet
			boolean sesion = Boolean.parseBoolean(request.getParameter("sesion"));
						
			//Y en base a eso adapto la logica que teniamos anteriormente. Si la sesion existe entonces la finalizara
			
			if(sesion) {
				//Cerramos la sesion
				request.getSession().invalidate();
		        //Enviamos un mensaje de cierre
				request.setAttribute("mensaje", "Se ha cerrado correctamente la sesion");
				//Redireccionamos a formulario.jsp para que el usuario pueda comenzar de nuevo con una sesion desde cero.
				request.getRequestDispatcher("formulario.jsp").forward(request, response);	
			}
			//Luego redirigimos a index.jsp
			response.sendRedirect("index.jsp");
			
			
	}

		private Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {
			 Map<String, String> result = new HashMap<>();
			  
			  Enumeration headerNames = request.getHeaderNames();
			  while(headerNames.hasMoreElements()) {
				  String key = (String)headerNames.nextElement();
				  String value = request.getHeader(key);
				  System.out.println("Key: "+key);
				  System.out.println("VAlue: "+value);
				  result.put(key, value);
			  }
			   return result;
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		 String correo = request.getParameter("correo");
          String clave = request.getParameter("clave");
          //Manejamos las credenciales incorrectas de otra manera
          String pagina = "formulario.jsp";
          String mensaje = "Credenciales incorrectas";
          
          
          //Lo que buscamos es evaluar si los valores "correo" y "clave" existen previamente en el arraylist.
          
          Usuario usuario = buscar(correo, clave);
          //este usuario se instancia o queda en null. 
          
          if(usuario!=null) {
        	 //creamos el objeto session
        	  HttpSession sesion = request.getSession();
        	  //Si hay una sesion, cambiamos el mensaje
        	  mensaje = "Bienvenido: " ;
        	  //Si entra una sesion, cambiamos la pagina
        	  pagina = "index.jsp";
        	  //entonces por ahora enviamos un mensaje y agregamos el usuario (aprovechando el toString() con el objeto
        	  //session
        	  sesion.setAttribute("mensaje", mensaje );  
              //tambien le podemos enviar a traves de la sesion el usuario
        	  sesion.setAttribute("usuario", usuario);
        	  sesion.setAttribute("id", sesion.getId());
          }else {
        	//en caso de que no exista el usuario. Esto implica que alguno de los datos es diferente a los guardados. 
              request.setAttribute("mensaje", mensaje);
              
          }
          
          
          //La sesion se envia de la misma forma que el request. Con el RequestDispatcher.
          //Para poder enviar ese mensaje al index.jsp necesitamos un despachador. 
          RequestDispatcher rd = request.getRequestDispatcher(pagina);
          rd.forward(request, response);
          
          //Tambien podriamos haber hecho
          //request.getRequestDispatcher("index.jsp").forward(request, response);
          
 	}

	private Usuario buscar(String correo, String clave) {
		//lo que queremos es recorrer la lista de usuarios para ver si lo que llega al servlet se encuentra en la lista.
		//Entonces si el correo y la clave coinciden con los datos del usuario que estoy recorriendo, lo devuelvo
		//Esto lo hacemos porque en el index mostraremos cada usuario. 
		for (Usuario usuario : usuarios) {
			if(usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getClave().equals(clave)) {
				return usuario;
			}
		}
		//en el caso de que no encuentre algun usuario con esos valores lo hacemos retornar null
		return null;
	}
	
	//B. Creamos el metodo llenarUsuarios, como no nos estamos conectando a la BBDD crearemos esto de forma sencilla
	private void llenarUsuarios() {
		usuarios = new ArrayList<>();
		usuarios.add(new Usuario("user1@gmail.com", "user1.1234"));
		usuarios.add(new Usuario("user2@gmail.com", "user2.1234"));
		usuarios.add(new Usuario("user3@gmail.com", "user3.1234"));
		usuarios.add(new Usuario("user4@gmail.com", "user4.1234"));
	}
	
	
}
