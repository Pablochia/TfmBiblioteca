<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="model.Libro" %>

<%@page import="model.Editorial" %>

<%@page import="model.Genero" %>

<%@page import="model.Usuario" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/listas.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
    
</head>


<body>   

    <nav class="navbar">
        <h1 class="restart"><a style="text-decoration: none; color: white;" href="Admin.jsp">INICIO</a></h1>
        <%
            Usuario usuarioConectado = (Usuario)session.getAttribute("usuarioConectado");
        %>
        <div class="nav_right">

            
            <span class="sesion"><%=usuarioConectado.getNombre() %></span>
            

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

            <li><a href="#" id="hide_btn"><i class="fas fa-link"></i>Libros</a>
                <div class="dropdown hide" id="hidediv">
                    <a class="item" href="registroLibro.jsp">Insertar Libro</a>
                    <hr>
                    <a class="item" href="registroEditorial.jsp">Insertar Editorial</a>
                    <hr>
                    <a class="item" href="registroGenero.jsp">Insertar Genero</a>
                    <hr>
                    <a class="item" href="listaLibros.jsp">Lista de Libros</a>
                </div>
            </li>
            <li><a href="#" id="hide_btn2"><i class="fas fa-calendar-week"></i>Usuarios</a>
                <div class="dropdown hide" id="hidediv2">
                	<a class="item" href="registroUsuario.jsp">Insertar Usuario</a>
                    <a class="item" href="listaUsuarios.jsp">Lista de Usuarios</a>
                </div>
            </li>
        </ul>

        <script src="script.js"></script>
    </div>

    <section>
        <div class="header">
            <h1>Gestión de Libros</h1>
            <form name="Buscador" action="BusquedaControl" method="post">
                <label style="margin-right: 3px;" for="">Buscar:</label>
                <input type="search" name="buscar" id="search">      
                <input type="hidden" name="accion" value="reducirListaLibros">    
            </form>
            
        </div>
        

        <div class="fondo">
            <h4>Lista de Libros</h4>
        </div>
        <div class="table">
            <table>
                <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>TITULO</th>
                        <th>AUTOR</th>
                        <th class="celda">EDITORIAL</th>
                        <th class="rol">GENERO</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                	<%
                	Genero g = new Genero();
                	Editorial e=new Editorial();
                	Libro libro=new Libro();
                	for(Libro l :libro.listar()){
                		e.setId(l.getNit_editorial());
                		g.setCodigo(l.getIdgenero());
                	%>
                	
                    <tr>
                    	
	                        <td class="id" ><object><%=l.getIsbn() %></object></td>
	                        <td class="usuario"><%= l.getTitulo() %></td>
	                        <td class="contrasena"><%= l.getNombre_autor() %></td>
	                        <td class="celda"><%= e.getEditorial() %></td>
	                        <td class="rol"><%= g.getGenero() %></td>
	                        <td class="accion">
		                     	<form name="accion" action="LibroControl" method="get">
					                  <button name="accion" value="verinfolibroAdmin"><i class="fa fa-search-plus"></i></button>
					                  <button name="accion" value="linkactualizar"><i class="fa fa-pencil"></i></button>
					                  <button name="accion" value="linkeliminar"><i class="fa fa-trash-o"></i></button>
					                  <input type="hidden" name="isbn" value="<%=l.getIsbn() %>">
		                     	</form> 
                        	</td>
                    </tr>
                    
                    <% 
                	}
                	%>
                    
                </tbody>
            </table>
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