<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/9e9253d3c0.js" crossorigin="anonymous"></script>
</head>


<body>   
    <nav class="navbar">

        <h1 class="restart"><a style="text-decoration: none; color: white;" href="index.jsp">INICIO</a></h1>
        
        <div class="nav_right">
            
            <ul class="nav_list">
                <li class="nav_element"><a style="text-decoration: none; color: black;" href="registro.jsp">Regitrarse</a></li>
                <li class="nav_element"><a style="text-decoration: none; color: black;"  href="login.jsp">Iniciar Sesión</a></li>
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
            <li><a href="index.jsp"><i class="fas fa-qrcode"></i>Inicio</a></li>
            <li><a href="registro.jsp"><i class="fas fa-sliders-h"></i>Registrarse</a></li>
            <li><a href="login.jsp"><i class="fas fa-envelope"></i>Iniciar Sesión</a></li>
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
                <div class="fantasy">
                    <img class="image" src="images/fantasia.jpg" alt="">
                    <div>
                        <h1 class="tittle">FANTASIA</h1>
                        <p class="description">Vive historias sobrenaturales que rompen con la realidad establecida</p>
                    </div>
                </div>

                <div class="terror">
                    <img class="image" src="images/terror.jpg" alt="">
                    <div>
                        <h1 class="tittle">TERROR</h1>
                        <p class="description">Sumérgete en historias con una atmósfera inquietante capaz de provocar miedo en el lector</p>
                    </div>
                    
                </div>

                <div class="contemporanea">
                    <img class="image" src="images/contemporanea.jpg" alt="">
                    <div>
                        <h1 class="tittle">CONTEMPORANEA</h1>
                        <p class="description">Adéntrate en historas apasionantes desde la primera página</p>
                    </div>
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