<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Usuario" %>
<%@page import="dao.UsuarioDao" %>

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
            </li>
        </ul>

        <script src="script.js"></script>
    </div>

    <section>
        <div class="header">
            <h1>Gestión de Usuarios</h1>
            <form name="Buscador" action="BusquedaControl" method="post">
                <label style="margin-right: 3px;" for="">Buscar:</label>
                <input type="search" name="buscar" id="search">      
                <input type="hidden" name="accion" value="reducirListaUsuarios">    
            </form>
            
        </div>
        

        <div class="fondo">
            <h4>Lista de Usuarios Registrados</h4>
        </div>
        <div class="table">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Usuario</th>
                        <th>Contaseña</th>
                        <th class="celda">Telefono</th>
                        <th class="rol">Rol</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                	<%
                	Usuario usuario = new Usuario();
                	for(Usuario user :usuario.listar()){
                	%>
                	
                    <tr>
                        <td class="id" ><%=user.getId() %></td>
                        <td class="usuario"><%=user.getNombre() %></td>
                        <td class="contrasena"><%=user.getPassword() %></td>
                        <td class="celda"><%=user.getTelefono() %></td>
                        <td class="rol"><%=user.getRol() %></td>
                        <td class="accion">
	                        
	                        <form name="accion" action="Login" method="get">
					              <button name="accion" value="linkactualizar"><i class="fa fa-pencil"></i></button>
					              <button name="accion" value="linkeliminar"><i class="fa fa-trash-o"></i></button>
					              <input type="hidden" name="id" value="<%=user.getId() %>">
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