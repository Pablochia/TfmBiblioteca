package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Editorial;

public class EditorialDao {
	
	private Connection con=null;
	private static EditorialDao instance=null;
	
	public EditorialDao() throws SQLException {
		con=Conexion.getConnection();
	}
	
	
	public static EditorialDao getinstance() throws SQLException {
		
		if (instance==null) {
			instance = new EditorialDao();
		}
		
		return instance; 
	}
	

public boolean registrar(Editorial e) throws SQLException {
		
		boolean retornar=false;

		String SQL="INSERT INTO editoriales (nombre) VALUES (?)";
		
		Connection con=Conexion.getConnection();
		
		PreparedStatement st = con.prepareStatement(SQL);;
		st.setString(1,e.getNombre());
		
	
			if(st.executeUpdate()>0) {
				
				retornar=true;;
			}
		
		return retornar;
		
	}
	
	
		public ArrayList<Editorial> listar() throws SQLException {
		
			ArrayList<Editorial> lista=new ArrayList<>();
			String SQL="SELECT * FROM editoriales";
			Connection con=Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);;
			ResultSet resultado=st.executeQuery();
			
			
			Editorial edi;
			
			while(resultado.next()) {
				edi=new Editorial();
				edi.setId(resultado.getInt("ideditorial") );
				edi.setNombre(resultado.getString("nombre"));
				lista.add(edi);
			}
			
			
			return lista;
		}
		
		public  String getEditorial(int id) {
			String retornar="";
			try {
			String SQL="SELECT nombre FROM editoriales where (ideditorial=?)";
			Connection con=Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);
			st.setInt(1, id);
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
