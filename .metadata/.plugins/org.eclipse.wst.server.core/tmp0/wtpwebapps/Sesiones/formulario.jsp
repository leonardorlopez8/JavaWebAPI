<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Inicio de Sesion</h1>


<!-- Los formularios necesitan una accion y un metodo. Los unico dos metodos que permite HTML a 
travez de un formulario son GET y POST. Los otros metodos o verbos no funcionan en un formulario (UPDATE, DELETE...) -->
<!--El action por ahora lo dejamos vacio porque necesitamos tener el servlet. Por lo tanto redireccionara a 
la misma pagina -->
	<form action="login" method="POST" >
		<div>
			<label for="correo"> Usuario: </label>
			<!-- el type es el tipo de dato a validar.El "id" identifica el tag dentro del html y el 
             "name" es el que identifica el valor en el envio de la informacion. Lo logico seria
              que se llamen el "id" y el "name" de la misma manera -->
			<!-- Tener el label junto con el input lo que hace es que al darle click a la etiqueta
			se posiciona dentro del input Para vincular al label con el input se utiliza el "for"
			el cual utiliza el "id" del input correspondiente -->
			<input type="email" id="correo" name="correo"
				placeholder="usuario@dominio.ext" required />

		</div>
		
		<div>
		     <label for="clave">Clave: </label>
		     <!-- Tambien le podemos agregar un Regex a travez del atributo pattern. Para que valide 
		     la Password. El Regex es una expresion regular que evalua un patron. 
		     Y los input the HTML5 los permite. Si bien lo podemos poner ahora, realizaremos 
		     la validacion desde el Backend  -->
		     <input type="password" id="clave" name="clave" placeholder="Digite su contraseņa" required/>
		
		</div>
	
	    <div>
	         <button type="submit">Enviar</button>
	         <button type="reset">Limpiar</button>
	         
	    
	    </div>
	    
	    <!-- Se mostrar el mensaje si y solo si vino con credenciales incorrectas. Si refrescamos la 
	    pantalla no se mostrara el null ni el h2 en rojo -->
	    <div>
	   
	         <% 
	         
	           if(session.getAttribute("mensaje")!= null){
	        	   response.sendRedirect("index.jsp");
	        	   
	           } else{
	        	   
	           
	            
	         
	         
	            String mensaje = (String) request.getAttribute("mensaje");
	            //manejamos el null (como estamos con un request por si no se cargo el objeto mensaje)
	            if(mensaje!=null){
	            	%>
	            	<h2 style="color:red"><%=mensaje %> </h2>
	            	
	            	<%}
	           }//cierro el else
	            	%>
	           	      
	    
	    </div>
	    
	
	</form>



</body>
</html>