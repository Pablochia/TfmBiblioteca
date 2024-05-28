<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Usuario" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/style_admin.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
    
</head>


<body>   

    <nav class="navbar">
        <h1 class="restart"><a style="text-decoration: none; color: white;" href="Admin.jsp">INICIO</a></h1>
        <div class="nav_left">
            <%
            Usuario user = (Usuario)session.getAttribute("usuarioConectado");
            %>
        </div>
        <div class="nav_right">
                    <span class="sesion"><%=user.getNombre() %></span>

            <div class="perfil">
                <ul>
                <form name="accion" action="Login" method="get">
                	<input type="hidden" name="id" value="<%=user.getId() %>">
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

            <li><a href="#" id="hide_btn"><i class="fas fa-link"></i>Libros</a></li>
            <div class="dropdown hide" id="hidediv">
                    <a class="item" href="registroLibro.jsp">Insertar Libro</a>
                    <a class="item" href="registroEditorial.jsp">Insertar Editorial</a>
                    <a class="item" href="registroGenero.jsp">Insertar Genero</a>
                    <a class="item" href="listaLibros.jsp">Lista de Libros</a>
                </div>
            </li>
            <li><a href="#" id="hide_btn2"><i class="fas fa-calendar-week"></i>Usuarios</a>
                <div class="dropdown hide" id="hidediv2">
                	<a class="item" href="registroUsuario.jsp">Insertar Usuario</a>
                    <a class="item" href="listaUsuarios.jsp">Lista de Usuarios</a>
                </div>
            
        </ul>


    </div>

    <section class="sep">
        <div class="container">
            <div class="main">
                <img src="images/libros.jpg" alt=""
                width="1100px"
                >
            </div>
            <div class="header">
                <h1>BUSCAS ALGO EN ESPECIAL</h1>
            </div>
            
            <div class="generos">
            
            <form name="accion" action="BusquedaControl" method="post">
	        	<input type="hidden" name="buscar" value="Fantasia"> 
	        	<button class="accrapido" name="accion" value="buscarAdmin">
	        		<div class="fantasy">
                    	<img class="image" src="images/fantasia.jpg" alt="">
                    	<div>
                        	<h1 class="tittle">FANTASIA</h1>
                        	<p class="description">Vive historias sobrenaturales que rompen con la realidad establecida</p>
                    	</div>
                	</div>
                </button>
	        	<input type="hidden" name="isbn">
        	</form>
            
            <form name="accion" action="BusquedaControl" method="post">
	        	<input type="hidden" name="buscar" value="Terror"> 
	        	<button class="accrapido" name="accion" value="buscarAdmin">
	        		 <div class="terror">
                    	<img class="image" src="images/terror.jpg" alt="">
                    	<div>
                        	<h1 class="tittle">TERROR</h1>
                        	<p class="description">Sumérgete en historias con una atmósfera inquietante capaz de provocar miedo en el lector</p>
                    	</div>
                	</div>
                </button>
	        	<input type="hidden" name="isbn">
        	</form>
            

               <form name="accion" action="BusquedaControl" method="post">
	        	<input type="hidden" name="buscar" value="Contemporanea"> 
	        	<button class="accrapido" name="accion" value="buscarAdmin">
	        		<div class="contemporanea">
                    	<img class="image" src="images/contemporanea.jpg" alt="">
                    	<div>
                        	<h1 class="tittle">CONTEMPORANEA</h1>
                        	<p class="description">Adéntrate en historas apasionantes desde la primera página</p>
                    	</div>
                	</div>
                </button>
	        	<input type="hidden" name="isbn">
        	</form>
                    
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
    <script src="script.js"></script>
</body>
</html>