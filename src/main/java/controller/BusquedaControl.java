package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusquedaDao;
import model.Busqueda;
import model.Libro;

@WebServlet("/BusquedaControl")
public class BusquedaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BusquedaControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogemos el nombre introducido y la accion que quiere realizar
		String nombre=request.getParameter("buscar");
		String accion=request.getParameter("accion");
		request.setAttribute("nombre", nombre);
		if (accion.equals("buscar")) {
			//Si el que busca es un usuario mandamos a la pagina de resultados
			request.getRequestDispatcher("resultadoBusqueda.jsp").forward(request, response);
		}if (accion.equals("buscarAdmin")) {
			//Si el que busca esun administrador mandamos a la pagina de la lista para aadministradores
			request.getRequestDispatcher("busquedaLibros.jsp").forward(request, response);
		} else if(accion.equals("reducirListaLibros")) {
			//Busqueda para filtrar los libros
			request.getRequestDispatcher("busquedaLibros.jsp").forward(request, response);
		}else if (accion.equals("reducirListaUsuarios")) {
			//Busqueda para filtrar los usuarios
			request.getRequestDispatcher("busquedaUsuarios.jsp").forward(request, response);
		}else if (accion.equals("anonimo")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
			
			
			
		
		
	}

}
