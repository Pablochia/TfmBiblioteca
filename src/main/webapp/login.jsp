<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style_login.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    <div class="container">
        
            <h2>INICIO DE SESION</h2>
            
            <div style="color:red;">
				<%=(request.getAttribute("mensaje")!=null?request.getAttribute("mensaje"):"") %>
			</div>
        

        <form name="accion" action="Login" method="post">

            <div class="element">
                <label for="name">Nombre</label>
            </div>

            <div class="element">
                <i class="fa-solid fa-user"></i><input type="text" name="usuario" placeholder="Usuario">
            </div>
            <hr color="black">
            
            <div class="element">
                <label for="password">Contrase�a</label>   
            </div>
            <div class="element">
                <i class="fa-solid fa-key"></i><input type="password" name="contrasena" id="password"
                        placeholder="Contrase�a">
            </div>
            <hr color="black">
        

        	<span>�No recuerdas la contrase�a?</span>
        	
        		<button  name="accion" value="login" class="button">Iniciar Sesi�n</button>
        	
        		
        	
        	
		</form>
        <div class="noacc">�No tienes cuenta??</div>

        <a class="signin" href="registro.jsp">Reg�strate aqu�</a>







    </div>
</body>
</html>