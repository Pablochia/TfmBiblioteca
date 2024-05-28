<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style_registro.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    <div class="container">
        <h2>REGISTRO</h2>
        
        <div style="color:red;">
			<%=(request.getAttribute("mensaje")!=null?request.getAttribute("mensaje"):"") %>
		</div>
        <form name="login" action="Login" method="post">
            <div class="content">
                    <div class="left">
                        
                        <label class="left" for="name">Usuario </label>
                        <div class="fa">
                            <i class="fa-sharp fa-light fa-face-smile"></i><input type="text" name="usuario" placeholder="Nombre" required>
                        </div>
                        
                    
                    </div>
                        

                    <div class="right">
                    <label for="name">Teléfono</label>
                    <div class="fa">
                        <i class="fa-sharp fa-light fa-phone"></i><input type="tel" name="telefono" placeholder="765678120" required>
                    </div>
                    

                </div>
                
            </div>

            


            <div class="content">
                <div class="left">
                    <label for="name">Contraseña</label>
                    <div class="fa">
                        <i class="fa-solid fa-key"></i><input type="password" name="contrasena" placeholder="Contraseña">
                    </div>
                    
                    

                </div>

                <div class="right">
                    <label for="name">Confirmar Contraseña</label>
                    <div class="fa">
                        <i class="fa-solid fa-key"></i><input type="password" name="contrasena2" placeholder="Contraseña">
                    </div>
                    
                </div>

            </div>
        <div class="button">
            <button name="accion" value="registro">Registrar</button>
        </div>
        

        </form>

        <span>¿Ya Tienes Cuenta? <a href="login.jsp">Inicia Sesión</a></span>

    </div>



</body>
</html>