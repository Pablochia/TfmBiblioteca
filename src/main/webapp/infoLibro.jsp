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
    <link rel="stylesheet" href="css/style_infoLibroAdmin.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    
    <nav class="navbar">
        <h1 class="restart"><a style="text-decoration: none; color: white;" href="Admin.jsp">INICIO</a></h1>
        
        <%
        Usuario usuarioConectado = (Usuario)session.getAttribute("usuarioConectado");	
        
        %>
          
        </div>
        <div class="nav_right">
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


    </div>

    <section>
    
    <%
        	String isbn=(String)(request.getAttribute("isbn")!=null?request.getAttribute("isbn"):"");
	    	String titulo=(String)(request.getAttribute("titulo")!=null?request.getAttribute("titulo"):"");
	    	String autor=(String)(request.getAttribute("autor")!=null?request.getAttribute("autor"):"");
	    	String descripcion=(String)(request.getAttribute("descripcion")!=null?request.getAttribute("descripcion"):"");
	    	String genero=(String)(request.getAttribute("genero")!=null?request.getAttribute("genero"):"");
	    	String editorial=(String)(request.getAttribute("editorial")!=null?request.getAttribute("editorial"):"");
	    	String foto=(String)(request.getAttribute("foto")!=null?request.getAttribute("foto"):"");
    	%>
        <div class="principal"><span><%=titulo %></span></div>
        <div class="container">

            <div id="gato1" class="tarjeta" >
                <div class="fondo">
                    <img src="images/<%=foto %>" alt=""
                    	width=140px
                    	height=180px>
                    
                </div>
                <div class="info">
                    <div class="infolibro">
                        <label for="">Título:</label><div class="busqueda"><%=titulo %></div>
                    </div>
                    <div class="infolibro">
                        <label for="" >Autor: </label><div class="busqueda"><%=autor %></div>
                    </div>
                </div>
            </div>
            <div class="sinopsis"><%=descripcion %></div>
        </div>
        <div class="fichatecnica">
            <div class="header"> Ficha Tecnica</div>
            <div class="info">
                <div class="infolibro">
                	<label for="">ISBN:</label><div class="busqueda"><%=isbn %></div>
                </div>
                <div class="infolibro">
                      <label for="">Editorial:</label><div class="busqueda"><%=editorial %></div>
                </div>
                <div class="infolibro">
                       <label for="">Genero:</label><div class="busqueda"><%=genero %></div>
                </div> 
            </div>  
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