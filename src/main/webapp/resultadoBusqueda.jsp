<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Usuario" %>
    <%@page import="model.Busqueda" %>
    <%@page import="model.Libro" %>
    <%@page import="model.Editorial" %>
    <%@page import="model.Genero" %>
    <%@page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/resultados.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    
    <nav class="navbar">
    <h1 class="restart"><a style="text-decoration: none; color: white;" href="Client.jsp">INICIO</a></h1>
        <%
            Usuario usuarioConectado = (Usuario)session.getAttribute("usuarioConectado");
        %>
        <div class="nav_left">
           <form name="BusquedaControl" action="BusquedaControl" method="post">
                <input type="search" name="buscar" id="search" placeholder="Buscar...">
                <input type="hidden" name="accion" value="buscar">       
            </form> 

            
        </div>
        <div class="nav_right">
            <input type="checkbox" id="checkperfil">
                    <label for="checkperfil" class="checkperfil">
                        <span class="sesion"><%=usuarioConectado.getNombre() %></span>
                    </label>

            <div class="perfil">
                <ul>
                <form name="accion" action="Login" method="get">
                	<input type="hidden" name="id" value="<%=usuarioConectado.getId() %>">
                    <button class="logout perfil_item" name="accion" value="perfilAdmin" type="submit">Perfil</button>
                    
               </form>
               <form name="accion" action="Login" method="post">
                    <button class="logout perfil_item" name="accion" value="cerrarsesion" type="submit">Cerrar Sesion</button>
                    
               </form>
                </ul>
            </div>
        </div>
        
            
    </nav>

    <input type="checkbox" id="check">
    <label for="check">
        <i class="fas fa-bars" id="btn"></i>
        <i class="fas fa-times" id="cancel"></i>
    </label>

<div class="sidebar">
    <ul>
        <li><a href="Client.jsp"><i class="fas fa-qrcode"></i>Inicio</a></li>
        
        <form name="accion" action="Login" method="get">
            <input type="hidden" name="id" value="<%=usuarioConectado.getId() %>">
            <button class="logout perfil_item" name="accion" value="perfilAdmin" type="submit">Perfil</button>
            
       </form>
        
       <form name="accion" action="Login" method="post">
                    <button class="logout perfil_item" name="accion" value="cerrarsesion" type="submit">Cerrar Sesion</button>
                    
       </form>
    </ul>


</div>

    <section>
    
    <%
    	Genero g = new Genero();
		Editorial e=new Editorial();
		String nombre=(String)request.getAttribute("nombre");
		Busqueda busqueda=new Busqueda();	
		
		int edi=busqueda.getEditorial(nombre);
		int gen=busqueda.getGenero(nombre);
    		
        		
    %>
        <div class="header"><%=nombre %></div>

        <div class="container">
        <%
        for (Libro l : busqueda.getLibro(nombre,gen,edi)){
        	e.setId(l.getNit_editorial());
    		g.setCodigo(l.getIdgenero());       
        %>
        
            <div id="gato1" class="tarjeta" >
            <form name="accion" action="LibroControl" method="get">
	        	<button name="accion" value="verInfoLibro">
	        		<div class="fondo">
                    	<img src="images/<%=l.getFoto() %>" alt=""
                    	width=140px
                    	height=180px>
                	</div>
                </button>
	        	<input type="hidden" name="isbn" value="<%=l.getIsbn() %>">
        	</form>
                
                <div class="info">
                    <p><%=l.getTitulo() %></p>
                    <p><%= l.getNombre_autor() %></p>
                    <p><%=e.getEditorial() %></p>
                    <p><%=g.getGenero() %></p>
                </div>
            </div>
		<%
		} 
		%>
  
        </div>

        
        
    </section>
    <footer class="footer">


        <div class="yokse">
            <i class="fa-solid fa-circle-play"></i>
        </div>



        <div class="company">
            <p class="foot_element"><a href=""></a>Pablo Chía Hidalgo</p>
            <p class="foot_element"><a href=""></a>Trabajo Fin de Master</p>
            <p class="foot_element"><a href=""></a>Contacto</p>
        </div>

        <div class="socialmedia">
            <i class="fa-brands fa-twitter"></i>
            <i class="fa-brands fa-instagram"></i>
            <i class="fa-brands fa-facebook"></i>
        </div>
    </footer>

</body>
</html>