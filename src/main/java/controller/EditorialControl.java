package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Editorial;

/**
 * Servlet implementation class EditorialControl
 */
@WebServlet("/EditorialControl")
public class EditorialControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditorialControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Registro de Editorial, capturamos el nombre y utilizamos el método registrar
		
		String nombre=request.getParameter("nombre");
		boolean isValid;

		Editorial e=new Editorial();
		e.setNombre(nombre);
		try {
			isValid=e.registrar();
			if (isValid) {
				//Si se ha registrado correctamente mandamoas mensaje de editorial registrada
			request.setAttribute("mensaje", "La editorial se ha registrado");
			
			}else {
				//si no se ha podido registrar mensaje error
			request.setAttribute("mensaje", "La editorial no se ha registrado");
			}
			request.getRequestDispatcher("registroEditorial.jsp").forward(request, response);
		
	
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}
}

