package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Genero;
import model.Libro;

public class LibroDao {
	
	private Connection con=null;
	private static LibroDao instance=null;
	
	public LibroDao() throws SQLException {
		con=Conexion.getConnection();
	}
	
	
	public static LibroDao getinstance() throws SQLException {
		
		if (instance==null) {
			instance = new LibroDao();
		}
		
		return instance; 
	}
	
	public boolean registrar(Libro l) {
		
		boolean retornar=false;
		String SQL="INSERT INTO libros VALUES (?,?,?,?,?,?,?);";
		Connection con;
		try {
			con = Conexion.getConnection();
			PreparedStatement st = con.prepareStatement(SQL);;
			st.setString(1,l.getIsbn());
			st.setString(2,l.getTitulo());
			st.setString(4,l.getDescripcion());
			st.setString(3,l.getNombre_autor());
			st.setInt(5,l.getIdgenero());
			st.setInt(6,l.getNit_editorial());
			st.setString(7,l.getFoto());
	
			if(st.executeUpdate()>0) {
				
				retornar=true;;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return retornar;
		
	}


	public  boolean actualizar(Libro l) throws SQLException {
	
		boolean retornar=false;
		String SQL="UPDATE libros SET titulo = ?, descripcion = ?,  autor = ?,  id_genero = ?, id_editorial = ? WHERE (isbn = ?);";
		
		Connection con=Conexion.getConnection();
		
		PreparedStatement st = con.prepareStatement(SQL);;
		st.setString(6,l.getIsbn());
		st.setString(1,l.getTitulo());
		st.setString(2,l.getDescripcion());
		st.setString(3,l.getNombre_autor());
		st.setInt(4,l.getIdgenero());
		st.setInt(5,l.getNit_editorial());
	
			if(st.executeUpdate()>0) {
				
				retornar=true;;
			}
		return retornar;
		
	}
	
	
	public boolean eliminar(Libro l) {
		
		boolean retornar=false;
		try {
		String SQL="DELETE FROM libros WHERE (isbn = ?)";
		
		Connection con=Conexion.getConnection();
		
		PreparedStatement st = con.prepareStatement(SQL);;
		st.setString(1,l.getIsbn());
		
	
			if(st.executeUpdate()>0) {
				
				retornar=true;;
				System.out.println("YES");
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			retornar=false;
		}
		return retornar;
		
	}
	
	
		public ArrayList<Libro> listar() throws SQLException {
		
			ArrayList<Libro> lista=new ArrayList<>();
			String SQL="SELECT * FROM libros";
			Connection con=Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);;
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
				lista.add(lib);
			}
			
			return lista;
		}
		
		
		
		
		public Libro getLibro(String isbn) {
			Libro lib=new Libro();
		try {
			String SQL="SELECT * FROM libros where (isbn=?)";
			Connection con=Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);
			st.setString(1, isbn);
			ResultSet resultado=st.executeQuery();
			
			
			
			
			if(resultado.next()) {
				
				lib.setIsbn(resultado.getString("isbn"));
				lib.setTitulo(resultado.getString("titulo"));
				lib.setDescripcion(resultado.getString("descripcion"));
				lib.setNombre_autor(resultado.getString("autor"));
				lib.setNit_editorial(resultado.getInt("id_editorial"));
				lib.setIdgenero(resultado.getInt("id_genero"));
				lib.setFoto(resultado.getString("foto"));
			}
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
			return lib;
		}
}
