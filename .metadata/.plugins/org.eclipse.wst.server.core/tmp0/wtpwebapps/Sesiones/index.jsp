<%@page import="com.educacionit.entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mi primera sesion</title>
</head>
<body>

<!-- Creamos la clase de java y mostramos el mensaje desde un scriptlets -->

<%
 String mensaje = (String) session.getAttribute("mensaje");
 Usuario usuario = (Usuario) session.getAttribute("usuario");
 String id = (String) session.getAttribute("id");
  
 //que podemos hacer si mensaje, usuario o id vienen en "null" en el caso de que se refresque el index.jsp
 //El usuario no deberia ver null, null, null para estos valores Si alguno de los valores esta en null
 //significa que no se creo la sesion. El usuario simplemente entro a localhost:8081/Sesiones/index.jsp directamente
 //entonces en ese caso debe redireccionar a formulario.jsp
 if(usuario==null){
	 response.sendRedirect("formulario.jsp");
 } else{
 
%>

  <!-- De lo contrario -->
 <h1><%=mensaje %></h1>
 <h2><%=usuario.getCorreo() %></h2>
 <h3><%="Numero de sesion: "+id %></h3>

<% 
}
%>


   <!-- Creo un ancla o referencia hacia el servlet login --> 
   <a href="login?sesion=true">Cerrar Sesion</a>

</body>
</html>