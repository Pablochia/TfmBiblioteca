package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.UsuarioDao;
import dao.Conexion;
import dao.GeneroDao;
import dao.LibroDao;

public class Usuario {

	//atributos
	private int id;
	private String nombre;
	private String password;
	private int telefono;
	private int rol;
	
	
	//constructores
	public Usuario() {
		
	}

	

	public Usuario(int id,String nombre, String password,int telefono, int rol) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.password = password;
		this.rol = rol;
		this.telefono=telefono;
	}

	
	//getters and setters

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getRol() {
		return rol;
	}



	public void setRol(int rol) {
		this.rol = rol;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	//metopdos
	
	public Usuario login() throws SQLException {
		
		Usuario user=UsuarioDao.getinstance().login(this);
		return user;
		
	}
	
	public boolean comprobar() throws SQLException {
		
		boolean isValid=UsuarioDao.getinstance().isValid(this.getNombre());
		return isValid;
		
	}
	
	public boolean registrar() throws SQLException {
		
		boolean registrar=UsuarioDao.getinstance().registrar(this);
		return registrar;
		
	}
	
	public boolean registrarAdmin() throws SQLException {
		
		boolean registrar=UsuarioDao.getinstance().registrarAdmin(this);
		return registrar;
		
	}
	
	public boolean actualizar() throws SQLException {
		
		boolean registrar=UsuarioDao.getinstance().actualizar(this);
		return registrar;
		
	}
	
	public boolean eliminar() throws SQLException {
		
		boolean registrar=UsuarioDao.getinstance().eliminar(this);
		return registrar;
		
	}
	
	public ArrayList<Usuario> listar() throws SQLException {
		
		ArrayList<Usuario> lista=UsuarioDao.getinstance().listar();
		
		return lista;
	}
	public Usuario getUsuario() throws SQLException {
		
		Usuario usuario=UsuarioDao.getinstance().getUsuario(this.getId());
		
		return usuario;
	}
	
	
	
	
}
