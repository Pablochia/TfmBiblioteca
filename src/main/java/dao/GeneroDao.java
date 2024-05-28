package dao;

import model.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GeneroDao {
	
	private Connection con=null;
	private static GeneroDao instance=null;
	
	public GeneroDao() throws SQLException {
		con=Conexion.getConnection();
	}
	
	
	public static GeneroDao getinstance() throws SQLException {
		
		if (instance==null) {
			instance = new GeneroDao();
		}
		
		return instance; 
	}
	

	public  boolean registrar(Genero gen) {
		
		boolean retornar=false;
		try {
		String SQL="INSERT INTO generos(nombre) VALUES(?)";
		
		Connection con=Conexion.getConnection();
		
		PreparedStatement st = con.prepareStatement(SQL);;
		st.setString(1, gen.getNombre());
			if(st.executeUpdate()>0) {
				retornar=true;;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			retornar=false;
		}
		return retornar;
		
	}
	
	
		public ArrayList<Genero> listar() throws SQLException {
		
			ArrayList<Genero> lista=new ArrayList<>();
			String SQL="SELECT * FROM generos";
			Connection con=Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);;
			ResultSet resultado=st.executeQuery();
			
			
			Genero gen;
			
			while(resultado.next()) {
				gen=new Genero();
				gen.setCodigo(resultado.getInt("idgenero"));
				gen.setNombre(resultado.getString("nombre"));
				lista.add(gen);
			}
			
			
			
			return lista;
		}
		
		public String getGenero(int cod) {
			String retornar="";
			try {
			String SQL="SELECT nombre FROM generos where (idgenero=?)";
			Connection con=Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);;
			st.setInt(1, cod);
			ResultSet resultado=st.executeQuery();
	
			
			if(resultado.next()) {
				
				retornar= resultado.getString("nombre");
			}
			
				
			} catch (SQLException e) {
				retornar="--";
				e.printStackTrace();
			
			}
			return retornar;
		}
	
	
}
