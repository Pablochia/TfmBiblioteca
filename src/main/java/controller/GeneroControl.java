package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GeneroDao;
import model.Genero;

/**
 * Servlet implementation class CategoriaControl
 */
@WebServlet("/GeneroControl")
public class GeneroControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GeneroControl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Registro de genero, capturamos el nombre y usamos el metodo registrar
		String nombre=request.getParameter("nombre");
		Genero g=new Genero();
		boolean isValid;
		
		g.setNombre(nombre);
		
		try {
			isValid=g.registrar();
			
			if (isValid) {
				//Si se ha registrado mensaje exito
			request.setAttribute("mensaje", "El genero se ha registrado");
			
		}else {
			//Mensaje Error
			request.setAttribute("mensaje", "El genero no se ha registrado");
		}
		request.getRequestDispatcher("registroGenero.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
