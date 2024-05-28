package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibroDao;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.Part;
import model.Editorial;
import model.Genero;
import model.Libro;
import model.Usuario;

/**
 * Servlet implementation class LibroControl
 */
@WebServlet("/LibroControl")
@MultipartConfig
public class LibroControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Ruta para guardar archivos
	private String pathFiles="C:\\Users\\Pablo\\Documents\\curso_java\\eclipse\\TfmBiblioteca\\src\\main\\webapp\\images";
    private File uploads=new File(pathFiles);

    public LibroControl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Guardamos las caracteristicas del libro en variables
		String accion=request.getParameter("accion").toLowerCase();
		String isbn=request.getParameter("isbn");
		Libro libro=new Libro();
		libro.setIsbn(isbn);
		Libro getLibro;
		Editorial getEditorial= new Editorial();
		Genero getGenero=new Genero();

		try {
			//invacamos metodo getLibro, si trae de vuelta algun libro lo enviamos a la vista
			getLibro = libro.getLibro();
			getEditorial.setId(getLibro.getNit_editorial());
			getGenero.setCodigo(getLibro.getIdgenero());
			request.setAttribute("isbn", getLibro.getIsbn());
			request.setAttribute("titulo", getLibro.getTitulo());
			request.setAttribute("autor", getLibro.getNombre_autor());
			request.setAttribute("descripcion", getLibro.getDescripcion());
			request.setAttribute("editorial", getEditorial.getEditorial());
			request.setAttribute("genero", getGenero.getGenero());
		
			if(accion.equals("linkactualizar")) {
				//Modificar Libro
				request.setAttribute("modifica", "ACTUALIZAR");
				request.getRequestDispatcher("modificarLibro.jsp").forward(request, response);
			}else if(accion.equals("linkeliminar")) {
				//Eliminar Libro
				request.setAttribute("modifica", "ELIMINAR");
				request.getRequestDispatcher("modificarLibro.jsp").forward(request, response);
			}else if(accion.equals("verinfolibro")) {
				//VEr la informacion del libro
				request.setAttribute("foto", getLibro.getFoto());
				request.getRequestDispatcher("informacionLibro.jsp").forward(request, response);
			}else if(accion.equals("verinfolibroadmin")) {
				//Administradpor ver info de un libro
				request.setAttribute("foto", getLibro.getFoto());
				request.getRequestDispatcher("infoLibro.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Guardamos las caracteristicas del libro en variables
		String isbn=request.getParameter("isbn");
		String titulo=request.getParameter("titulo");
		String autor=request.getParameter("autor");
		String intermediario=request.getParameter("genero");
		int categoria=Integer.parseInt(intermediario.trim());
		String edi=request.getParameter("editorial");
		int editorial=Integer.parseInt(edi.trim());
		String descripcion=request.getParameter("descripcion");
		String accion=request.getParameter("accion").toLowerCase();
		boolean isValid=false;
		
		//Libro con las caracteristicas 
		Libro l =new Libro();
		l.setIsbn(isbn);
		l.setTitulo(titulo);
		l.setNombre_autor(autor);
		l.setIdgenero(categoria);
		l.setNit_editorial(editorial);
		l.setDescripcion(descripcion);
		
		
		if(accion.equals("registrar")) {
			//--------------------REGISTRO-------------------------------------
			try {
				Part part=request.getPart("foto");
				Path path=Paths.get(part.getSubmittedFileName());
				
				//Nombre Archivo (foto)
				String nombreArchivo=path.getFileName().toString();
				
				InputStream input=part.getInputStream();
				
				
				if (input!=null) {
					//Si se han recogido datos de tipo file
					//creamos un archivo en la ruta establecida arriba 
					//y copiamos los datos del archivo seleccionado en la ruta nueva
					File file=new File(uploads,nombreArchivo);
					
					Files.copy(input,file.toPath());
					input.close();
				}
				l.setFoto(nombreArchivo);
				isValid=l.registrar();

				if(isValid) {
					//Se ha podido registrar
					request.setAttribute("mensaje", "Libro Registrado con exito");
					request.getRequestDispatcher("registroLibro.jsp").forward(request, response);
				}else {
					//no se ha podid registrar
					request.setAttribute("mensaje", "Libro no Registrado" );
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//----------------------FIN REGISTRO-----------------------------
		}else if(accion.equals("actualizar")) {
			//----------------------ACTUALIZAR-------------------------------
			try {
				isValid=l.actualizar();
				
				if(isValid) {
					//Se ha podido actualizar
					request.setAttribute("mensaje", "Libro Actualizado");
				}else {
					//Nose ha podido actualizar
					request.setAttribute("mensaje", "Libro no Actualizado" );
				}
				request.getRequestDispatcher("registroLibro.jsp").forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//-----------------FIN ACTUALIZAR----------------------------
		}else if(accion.equals("eliminar")){
			//----------------------ELIMINAR-----------------------------
			try {
				isValid=l.eliminarr();
				if(isValid) {
					//Libro Elimnado
					request.setAttribute("mensaje", "Libro Eliminado");
				}else {
					//Libro no eliminado
					request.setAttribute("mensaje", "Libro no Eliminado" );
				}
				request.getRequestDispatcher("registroLibro.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//------------------FIN ELIMINAR------------------------------
			
		}
	}
}