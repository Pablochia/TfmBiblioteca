package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogemos los datos
		String accion=request.getParameter("accion").toLowerCase();
		int id=Integer.parseInt(request.getParameter("id").trim());
		
		Usuario usuario=new Usuario();
		usuario.setId(id);
		Usuario user;
		//Creamos un usuario y lo bsucamos en la BD metodo getUsuario
		try {
			//Usuario Encontrado
			user = usuario.getUsuario();
			request.setAttribute("id", user.getId());
			request.setAttribute("usuario", user.getNombre());
			request.setAttribute("contrasena", user.getPassword());
			request.setAttribute("telefono", user.getTelefono());
			
			if(accion.equals("linkactualizar")) {
				//Pagina modificar datos usuario
				request.setAttribute("modifica", "ACTUALIZAR");
				request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
			}else if(accion.equals("linkeliminar")) {
				//Paginaeliminar usuario
				request.setAttribute("modifica", "ELIMINAR");
				request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
			}else if(accion.equals("perfiladmin")) {
				//Acceder perfil administrador
				request.getRequestDispatcher("perfilAdmin.jsp").forward(request, response);
			}else if(accion.equals("perfil")) {
				//Acceder perfil usuario
				request.getRequestDispatcher("perfil.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			//Usuario no encontrado
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogemos los datos introducidos
		String accion=request.getParameter("accion").toLowerCase();
		Usuario isConected=new Usuario();
		
		String nombre=request.getParameter("usuario");
		String password=request.getParameter("contrasena");
		
		Usuario user=new Usuario();
		//Creamos un objeto usuario
		
		
		if (accion.equals("login")) {			
			//--------------------------------LOGIN--------------------------------------
			user.setNombre(nombre);
			user.setPassword(password);
			
		try {
			//Comprobamos si los adtos introducido corresponden a un usuario en la BD
			isConected=user.login();
			//Usuario encontrado
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Usuario o Contraseña incorrectos ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			e.printStackTrace();
		}
		
			if (isConected.getRol()==1) {
				//Rol Administrador
				HttpSession sesion=request.getSession();
				sesion.setAttribute("usuarioConectado", isConected);
				response.sendRedirect("Admin.jsp");
			}else 
				if(isConected.getRol()==2){
					//Rol Usuario
					HttpSession sesion=request.getSession();
					sesion.setAttribute("usuarioConectado", isConected);
					request.getRequestDispatcher("Client.jsp").forward(request, response);
			}else {
				request.setAttribute("mensaje", "Usuario o Contraseña incorrectos ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
			//---------------------------------FIN LOGIN-------------------------------------
		}else if(accion.equals("registro")) {
			//---------------------------------REGISTRO--------------------------------------
				String conf_pass=request.getParameter("contrasena2");				
				try {
					//Comprobamos que el telfono sea válido (9 digitos, no String)
					int telefono=Integer.parseInt(request.getParameter("telefono"));
					String tel=Integer.toString(telefono);
					if (tel.length()==9) {
						int rol=2; //Regisdtro de un usuario normal
						if (password.equals(conf_pass)){
							//Comprobamos que las contraseñas coincidan 
							user.setNombre(nombre);
							boolean isValid;
							try {
								//Comprobamos que el nombre de usuario se encuentra disponible
								isValid = user.comprobar();
								
								if (isValid) {
									//Nombre valido
									user.setPassword(password);
									user.setRol(rol);
									user.setTelefono(telefono);
									try {
										user.registrar();
									} catch (SQLException e) {
										e.printStackTrace();
									}
									request.setAttribute("mensaje", "Usuario registrado, logueate y empieza a usa la aplicacion");
									request.getRequestDispatcher("registro.jsp").forward(request, response);
								}else {
									//Nombre de usuario existente en BD
									request.setAttribute("mensaje", "El usuario introducido no se encuentra disponible, por favor, elige otro nombre distinto");
									request.getRequestDispatcher("registro.jsp").forward(request, response);
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
							
							
						}else {
							//Las contraseñas no coinciden
							request.setAttribute("mensaje", "Las contraseñas no coinciden");
							request.getRequestDispatcher("registro.jsp").forward(request, response);
						}	
						
					}else {
						request.setAttribute("mensaje", "Inserte un Teléfono válido");
						request.getRequestDispatcher("registro.jsp").forward(request, response);
					}
				}catch(Exception e) {
					//Telefono introducido no valido
					request.setAttribute("mensaje", "Inserte un Teléfono válido");
					request.getRequestDispatcher("registro.jsp").forward(request, response);
				}
				//-----------------------------------FIN REGISTRO-----------------------------------
		}else if(accion.equals("registroadmin")) {
			//-----------------------------------REGISTRO ADMINISTRADOR-----------------------------
			int rol=Integer.parseInt(request.getParameter("rol") );
			String conf_pass=request.getParameter("contrasena2");
			try {
				//Comprobamos que el telfono sea válido (9 digitos, no String)
				int telefono=Integer.parseInt(request.getParameter("telefono"));
				String tel=Integer.toString(telefono);
				if (tel.length()==9) {
					if (password.equals(conf_pass)){
						//Comprobamos que las contraseñas coincidan 
						boolean isValid;
						try {
							//Comprobamos que el nombre de usuario se encuentra disponible
							isValid = user.comprobar();
							
							if (isValid) {
								user.setNombre(nombre);
								user.setPassword(password);
								user.setTelefono(telefono);
								user.setRol(rol);
								try {
									//uSUARIO VALIDO
									user.registrarAdmin();
								} catch (SQLException e) {
									e.printStackTrace();
								}
								request.setAttribute("mensaje", "Usuario Registrado con Exito");
								request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
							}else {
								//Nombre no valido
								request.setAttribute("mensaje", "El usuario introducido no se encuentra disponible, por favor, elige otro nombre distinto");
								request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
						
						
					}else {
						//Contraseñas no coinciden
						request.setAttribute("mensaje", "Las contraseñas no coinciden");
						request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
					}		
				}
			}catch(Exception e) {
				//telefono introducido no valido
				request.setAttribute("mensaje", "Inserte un Teléfono válido");
				request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
			}
			
			
				//----------------------------------FIN REGISTRO ADMIN--------------------------------
		}else if(accion.equals("actualizar")) {
			//actualizar los datos de un usuario por un administrador
			//-------------------------------ACTUALIZAR-------------------------------------------
			int id=Integer.parseInt(request.getParameter("id") );
			int rol=Integer.parseInt(request.getParameter("rol") );
			int telefono=Integer.parseInt(request.getParameter("telefono"));
			//Creamos un objeto usuario con los datos recogido e invocamos el metodo actualizar
			user.setId(id);
			user.setNombre(nombre);
			user.setPassword(password);
			user.setRol(rol);
			user.setTelefono(telefono);
			
			boolean isValid;
			try {
				//Metodo a tualizar
				isValid = user.actualizar();
				if(isValid) {
					//usuario actualizado
					request.setAttribute("mensaje", "Usuario Actualizado");
				
				}else {
					//usuario no actualizado
					request.setAttribute("mensaje", "Usuario no Actualizado" );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
			//-----------------------------FIN ACTUALIZAR--------------------------------
		}else if(accion.equals("actualizaradmin")) {
			//actualizar perfil admin
			//-------------------------------ACTUALIZAR ADMIN-------------------------------------------
			int id=Integer.parseInt(request.getParameter("id") );
			int telefono=Integer.parseInt(request.getParameter("telefono"));
			//Creamos un objeto usuario con los datos recogido e invocamos el metodo actualizar
			user.setId(id);
			user.setNombre(nombre);
			user.setPassword(password);
			user.setRol(1);
			user.setTelefono(telefono);
			
			boolean isValid;
			try {
				//metodo actualizar perfil admin 
				isValid = user.actualizar();
				if(isValid) {
					//usuario actualizado
					request.setAttribute("mensaje", "Usuario Actualizado");
				
				}else {
					//usuario no actualizado
					request.setAttribute("mensaje", "Usuario no Actualizado" );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("mensaje", "Cambios Guardados");
			request.getRequestDispatcher("perfilAdmin.jsp").forward(request, response);
			//------------------------FIN ACTUALIZAR ADMIN------------------------------------------
		}else if(accion.equals("actualizaruser")) {
			//actualizar perfil por un usuario
			//-----------------------------------ACTUALIZAR--------------------------------------
			int id=Integer.parseInt(request.getParameter("id") );
			int telefono=Integer.parseInt(request.getParameter("telefono"));
			//Objeto usuario 
			user.setId(id);
			user.setNombre(nombre);
			user.setPassword(password);
			user.setRol(2);
			user.setTelefono(telefono);
			
			boolean isValid;
			try {
				//metodo actualizar perfil usuario
				isValid = user.actualizar();
				if(isValid) {
					//actualizado
					request.setAttribute("mensaje", "Cambios Guardados");
				}else {
					//no actualizado
					request.setAttribute("mensaje", "Error al modificar el Perfil" );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
			//--------------------------------------FIN ACTUALIZAR USER-----------------------------
		}else if(accion.equals("eliminar")){
			//Eliminar usuario registradfo por un admin
			//-----------------------------ELIMINAR--------------------------------------------
			int id=Integer.parseInt(request.getParameter("id") );
			user.setId(id);
			
			boolean isValid;
			try {
				//metodo eliminar
				isValid = user.eliminar();
					if(isValid) {
						//elimninado
					request.setAttribute("mensaje", "Usuario Eliminado");
				}else {
					//no eliminado
					request.setAttribute("mensaje", "Usuario no Eliminado" );
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
			//----------------------------FIN ELIMINAR----------------------------------
		}else if(accion.equals("eliminarperfil")){
			//-----------------------------ELIMINAR PERFIL------------------
			int id=Integer.parseInt(request.getParameter("id") );
			user.setId(id);
			
			try {
				user.eliminar();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("index.jsp").forward(request, response);
			//----------------------------------FIN ELIMIAR PERFIL------------------------
		}else if(accion.equals("cerrarsesion")) {
			//---------------------------CERRAR SESION---------------------------------------
			HttpSession sesion=request.getSession();
			sesion.removeAttribute("usuarioConectado");
			response.sendRedirect("index.jsp");
		}
			
	}
}

