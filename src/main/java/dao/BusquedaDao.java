package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Genero;
import model.Libro;
import model.Usuario;

public class BusquedaDao {
	
	private Connection con=null;
	private static BusquedaDao instance=null;
	
	public BusquedaDao() throws SQLException {
		con=Conexion.getConnection();
	}
	
	
	public static BusquedaDao getinstance() throws SQLException {
		
		if (instance==null) {
			instance = new BusquedaDao();
		}
		
		return instance; 
	}
	
	
	public int buscarGenero(String nombre) throws SQLException {
		int id_genero=0;
	String SQL="SELECT idgenero FROM generos WHERE (nombre=?);";
	Connection con=Conexion.getConnection();
	
	PreparedStatement st = con.prepareStatement(SQL);;
	st.setString(1,nombre);
	ResultSet resultado=st.executeQuery();
	
	if (resultado.next()) {
		id_genero=(resultado.getInt("idgenero"));
	}
	return id_genero;
}
	
	public int buscarEditorial(String nombre) throws SQLException {
		int id_editoriales=-1;
	String SQL="SELECT ideditorial FROM editoriales WHERE (nombre=?);";
	Connection con=Conexion.getConnection();
	
	PreparedStatement st = con.prepareStatement(SQL);;
	st.setString(1,nombre);
	ResultSet resultado=st.executeQuery();
	
	if (resultado.next()) {
		id_editoriales=(resultado.getInt("ideditorial"));
	}
	return id_editoriales;
}
	
	public static ArrayList<Libro> buscarLibro(String nombre, int genero, int editorial) {
		
		ArrayList<Libro> lista=new ArrayList<>();
	try {
	String SQL="SELECT * FROM libros WHERE (titulo LIKE '"+nombre+"%') OR (titulo LIKE '%"+nombre+"%') OR (autor=?) OR (id_genero=?) OR (id_editorial=?)";
	Connection con=Conexion.getConnection();
	
	PreparedStatement st = con.prepareStatement(SQL);;
	st.setString(1, nombre);
	st.setInt(2, genero);
	st.setInt(3, editorial);
	ResultSet resultado=st.executeQuery();
	
	
	Libro lib;
	
	while(resultado.next()) {
		lib=new Libro();
		lib.setIsbn(resultado.getString("isbn"));
		lib.setTitulo(resultado.getString("titulo"));
		lib.setDescripcion(resultado.getString("descripcion"));
		lib.setNombre_autor(resultado.getString("autor"));
		lib.setNit_editorial(resultado.getInt("id_editorial"));
		lib.setIdgenero(resultado.getInt("id_genero"));
		lib.setFoto(resultado.getString("foto"));
		lista.add(lib);
	}
	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	
	}
	
	return lista;
}
	
	public static ArrayList<Usuario> buscarUsuario(String nombre) {
		
		ArrayList<Usuario> lista=new ArrayList<>();
	try {
	String SQL="SELECT * FROM usuarios WHERE (usuario LIKE '"+nombre+"%')";
	Connection con=Conexion.getConnection();
	
	PreparedStatement st = con.prepareStatement(SQL);;
//	st.setString(1, nombre);
	ResultSet resultado=st.executeQuery();
	
	
	Usuario user=new Usuario();
	
	while(resultado.next()) {
		user.setId(resultado.getInt("idusuarios"));
		user.setNombre(resultado.getString("usuario"));
		user.setPassword(resultado.getString("password"));
		user.setRol(resultado.getInt("rol"));
		user.setTelefono(resultado.getInt("telefono"));
		lista.add(user);
	}
	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	
	}
	
	return lista;
}
}
	
