<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="dao.UsuarioDao" %>
<%@page import="model.Usuario" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style_registrar.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    
    <nav class="navbar">
        <h1 class="restart"><a style="text-decoration: none; color: white;" href="">INICIO</a></h1>

        <%
            Usuario user = (Usuario)session.getAttribute("usuarioConectado");
         %>
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
                <div class="dropdown" id="hidediv2">
                    <a class="item" href="registroUsuario.jsp">Insertar Usuario</a>
                    <a class="item" href="listaUsuarios.jsp">Lista de Usuarios</a>
                </div>
            </li>
        </ul>


    </div>
<form name="accion" action="Login" method="post">
    <section>
    <%
        	int id=(int)(request.getAttribute("id")!=null?request.getAttribute("id"):0);
	    	String usuario=(String)(request.getAttribute("usuario")!=null?request.getAttribute("usuario"):"");
	    	String contrasena=(String)(request.getAttribute("contrasena")!=null?request.getAttribute("contrasena"):"");
	    	int telefono=(int)(request.getAttribute("telefono")!=null?request.getAttribute("telefono"):0);
        		
    	%>
        
        <div class="header">Registro de Usuarios</div>

        <div class="mensaje" style="color:red;">
				<%=(request.getAttribute("mensaje")!=null?request.getAttribute("mensaje"):"") %>
		</div>

        <div class="section">
            <label>
            <h3 class="record">
                Id:
            </h3>
            
            </label>
            <div>
                <input class="box" type="text" name="nombre" value="<%=id %>" disabled>
                <input class="box" type="hidden" name="id" value="<%=id %>">
            </div>
        </div>

        <div class="section">
            <label>
            <h3 class="record">
                Nombre:
            </h3>
            
            </label>
            <div>
                <input class="box" type="text" name="usuario" value="<%=usuario %>" placeholder="Usuario">
            </div>
        </div>
        <div class="section">
            <label>
            <h3 class="record">
                Contrase�a:
            </h3>
            
            </label>
            <div>
                <input class="box" type="text" name="contrasena" value="<%=contrasena %>" placeholder="AuWhji34">
            </div>
        </div>

        <div class="section">
            <label>
            <h3 class="record">
                Telefono:
            </h3>
            
            </label>
            <div>
                <input class="box" type="text" name="telefono" value="<%=telefono %>" placeholder="123456789">
            </div>
        </div>



        <div class="section">
            <label>
            <h3 class="record">
               Rol Usuario:
            </h3>
            </label>
            <select class="box" name="rol">
                <option value="2">user</option>
                    
                <option value="1">admin</option>
                
            </select>
        </div>
        
        
        <button name="accion" value="<%=(request.getAttribute("modifica")!=null?request.getAttribute("modifica"):"ACTUALIZAR") %>" class="registro" type="submit"><%=(request.getAttribute("modifica")!=null?request.getAttribute("modifica"):"ACTUALIZAR") %></button>
        
    </section>
</form>
    
    <footer class="footer">


        <div class="yokse">
            <i class="fa-solid fa-circle-play"></i>
        </div>



        <div class="company">
            <p class="foot_element"><a href=""></a>Pablo Ch�a Hidalgo</p>
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