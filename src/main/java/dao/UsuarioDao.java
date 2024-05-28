package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDao {
	
	private Connection con=null;
	private static UsuarioDao instance=null;
	
	public UsuarioDao() throws SQLException {
		con=Conexion.getConnection();
	}
	
	
	public static UsuarioDao getinstance() throws SQLException {
		
		if (instance==null) {
			instance = new UsuarioDao();
		}
		
		return instance; 
	}
	
	
	public Usuario login(Usuario user) throws SQLException {
		Usuario usuario=new Usuario();
		
			
			String SQL="SELECT * FROM usuarios WHERE (usuario=?) AND (password=?)";
			Connection con=Conexion.getConnection();
			PreparedStatement st = con.prepareStatement(SQL);;
			st.setString(1,user.getNombre());
			st.setString(2, user.getPassword());
			ResultSet rs=st.executeQuery();
			
			if (rs.next()) {
				usuario.setId(Integer.parseInt(rs.getString("idusuarios")));
				usuario.setNombre(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setTelefono(Integer.parseInt(rs.getString("telefono")));
				usuario.setRol(rs.getInt("rol"));
			
			}else {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
			}
			
			return usuario;
		}
	
	public boolean isValid(String usuario) {
		boolean isValid=true;
		String SQL="SELECT usuario FROM usuarios WHERE (usuario=?)";
		Connection con;
		try {
			con = Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);;
			st.setString(1,usuario);
			ResultSet rs=st.executeQuery();
			if (rs.next()) {
				isValid=false;
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return isValid;
		}
	public boolean registrar (Usuario user) throws SQLException {
		boolean retornar=false;
		Connection con = Conexion.getConnection();;
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("INSERT INTO usuarios (usuario,password,rol,telefono) VALUES (?,?,?,?);");
		ps.setString(1, user.getNombre());
		ps.setString(2, user.getPassword());
		ps.setInt(4, user.getTelefono());
		ps.setInt(3, user.getRol());
		
		if(ps.executeUpdate()>0) {
			
			retornar=true;;
		}
		
		ps.close();
		
		return retornar;
	}
	
	public boolean registrarAdmin (Usuario user) throws SQLException {
		boolean retornar=false;
		Connection con = Conexion.getConnection();;
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("INSERT INTO usuarios (usuario,password,rol,telefono) VALUES (?,?,?,?);");
		ps.setString(1, user.getNombre());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getRol());
		ps.setInt(4, user.getTelefono());
		
		
		if(ps.executeUpdate()>0) {
			
			retornar=true;;
		}
		
		ps.close();
		
		return retornar;
	}
	
	public boolean actualizar(Usuario user) {
		boolean retornar=false;
		try {
			String SQL="UPDATE usuarios SET usuario = ?, password = ?,  rol = ?,  telefono = ? WHERE (idusuarios = ?);";
			
			Connection con=Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);;
			st.setInt(5,user.getId());
			st.setString(1,user.getNombre());
			st.setString(2,user.getPassword());
			st.setInt(3,user.getRol());
			st.setInt(4,user.getTelefono());
	
			if(st.executeUpdate()>0) {
				
				retornar=true;;
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			retornar=false;
		}
		return retornar;
		
	}
	
public boolean eliminar(Usuario user) {
		
		boolean retornar=false;
		try {
			String SQL="DELETE FROM usuarios WHERE (idusuarios = ?)";
			
			Connection con=Conexion.getConnection();
			
			PreparedStatement st = con.prepareStatement(SQL);;
			st.setInt(1,user.getId());
		
	
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
	
	public ArrayList<Usuario> listar() throws SQLException {
		
		ArrayList<Usuario> lista=new ArrayList<>();
		String SQL="SELECT * FROM usuarios";
		Connection con=Conexion.getConnection();
		
		PreparedStatement st = con.prepareStatement(SQL);;
		ResultSet resultado=st.executeQuery();
				
		Usuario user;
		
		while(resultado.next()) {
			user=new Usuario();
			user.setId(resultado.getInt("idusuarios"));
			user.setNombre(resultado.getString("usuario"));
			user.setPassword(resultado.getString("password"));
			user.setRol(resultado.getInt("rol"));
			user.setTelefono(resultado.getInt("telefono"));
			lista.add(user);
		}
		
		return lista;
	}
	
	public Usuario getUsuario(int id) throws SQLException {
		Usuario user=new Usuario();
		String SQL="SELECT * FROM usuarios where (idusuarios=?)";
		Connection con=Conexion.getConnection();
		
		PreparedStatement st = con.prepareStatement(SQL);
		st.setInt(1, id);
		ResultSet resultado=st.executeQuery();
	
	
	
	
		if(resultado.next()) {
			
			user.setId(resultado.getInt("idusuarios"));
			user.setNombre(resultado.getString("usuario"));
			user.setPassword(resultado.getString("password"));
			user.setTelefono(resultado.getInt("telefono"));
			user.setRol(resultado.getInt("rol"));
			
		}
		
		return user;
	}
	
}

