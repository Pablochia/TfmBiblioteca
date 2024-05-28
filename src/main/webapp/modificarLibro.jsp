<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Genero" %>
<%@page import="dao.GeneroDao" %>
<%@page import="model.Editorial" %>
<%@page import="dao.EditorialDao" %>
<%@page import="dao.LibroDao" %>
<%@page import="model.Libro" %>
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
                <a class="item" href="registroUsuario.jsp">Insertar Usuario</a>
                    <hr>
                    <a class="item" href="listaUsuarios.jsp">Lista de Usuarios</a>
                </div>
            </li>
        </ul>


    </div>
<form name="accion" action="LibroControl" method="post">
    <section>
    
    	<%
        	String isbn=(String)(request.getAttribute("isbn")!=null?request.getAttribute("isbn"):"");
	    	String titulo=(String)(request.getAttribute("titulo")!=null?request.getAttribute("titulo"):"");
	    	String autor=(String)(request.getAttribute("autor")!=null?request.getAttribute("autor"):"");
	    	String descripcion=(String)(request.getAttribute("descripcion")!=null?request.getAttribute("descripcion"):"");
        		
    	%>
    
        <div class="header">Registro de Libros</div>
        
        <div class="mensaje" style="color:red;">
				<%=(request.getAttribute("mensaje")!=null?request.getAttribute("mensaje"):"") %>
			</div>
      
        <div class="section">
            <label>
            <h3 class="record">
                ISBN:
            </h3>
            
            </label>
            <div>
                <input class="box" type="text" value="<%=isbn %>" disabled placeholder="1234569654">
                <input class="box" type="hidden" name="isbn" value="<%=isbn %>" >
            </div>
        </div>
        <div class="section">
            <label>
            <h3 class="record">
                Título:
            </h3>
            
            </label>
            <div>
                <input class="box" type="text" name="titulo" value="<%=titulo %>" placeholder="Los 3 Mosqueteros...">
                
            </div>
        </div>
        <div class="section">
            <label>
            <h3 class="record">
                Autor:
            </h3>
            
            </label>
            <div>
                <input class="box" type="text" name="autor" value="<%=autor %>" placeholder="Alexander Dumas...">
            </div>
        </div>
        <div class="section">
            <label>
            <h3 class="record">
                Género:
            </h3>
            
            </label>
            <select class="box" name="genero">
            <%
				Genero gen=new Genero();
			%>
					<% for(Genero g:gen.listar()){  %>
				<option value=" <%=g.getCodigo()  %> "><%= g.getNombre() %></option>
					<%} %>
			</select>
        </div>
        <div class="section">
            <label>
            <h3 class="record">
                Editorial:
            </h3>
            
            </label>
            <select class="box" name="editorial">
            	<%
					Editorial edi=new Editorial();
				%>
					<% for(Editorial e:edi.listar()){  %>
				<option value=" <%=e.getId() %> "><%= e.getNombre() %></option>
					<%} %>
			</select>
        </div>

        <div class="section">
            <label>
            <h3 class="record">
                Descripción:
            </h3>
            
            </label>
        </div>

        <textarea class="description" name="descripcion" id="" cols="30" rows="10"><%=descripcion %></textarea>
        
        <button name="accion" value="<%=(request.getAttribute("modifica")!=null?request.getAttribute("modifica"):"REGISTRAR") %>" class="registro" type="submit"><%=(request.getAttribute("modifica")!=null?request.getAttribute("modifica"):"REGISTRAR") %></button>
        
        

       
        
    </section>
    
     		
</form>
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