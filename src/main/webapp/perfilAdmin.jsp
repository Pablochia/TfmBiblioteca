<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Usuario" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style_modificarPerfil.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    
    <nav class="navbar">
        <h1 class="restart"><a style="text-decoration: none; color: white;" href="Admin.jsp">INICIO</a></h1>
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
        </div>
        
            
    </nav>

<form name="accion" action="Login" method="post">
    <section>
        <%
        	int id=(int)(request.getAttribute("id")!=null?request.getAttribute("id"):0);
	    	String usuario=(String)(request.getAttribute("usuario")!=null?request.getAttribute("usuario"):"");
	    	String contrasena=(String)(request.getAttribute("contrasena")!=null?request.getAttribute("contrasena"):"");
	    	int telefono=(int)(request.getAttribute("telefono")!=null?request.getAttribute("telefono"):0);
        		
    	%>
        <div class="header">Perfil Usuario</div>

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
                <input class="box" type="hidden" name="id" value="<%=id%>">
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
                Contraseña:
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

        <div class="botones">
        
        
            <button name="accion" value="actualizarAdmin" class="registro" type="submit">ACTUALIZAR</button>
        
            <button name="accion" value="eliminarperfil" class="registro" type="submit">ELIMINAR</button>
        </div>
        
        
    </section>
		</form>
    
    <footer class="footer">


        <div class="yokse">
            <i class="fa-solid fa-circle-play"></i>
        </div>



        <div class="company">
            <p class="foot_element"><a href=""></a>Pablo Chía Hidalgo</p>
            <p class="foot_element"><a href=""></a>Trabajo Fin de Master</p>
            <p class="foot_element"><a href=""></a>Diseño y Programacion de Aplicaciones Java</p>
        </div>

        <div class="socialmedia">
            <i class="fa-brands fa-twitter"></i>
            <i class="fa-brands fa-instagram"></i>
            <i class="fa-brands fa-facebook"></i>
        </div>
    </footer>

</body>
</html>