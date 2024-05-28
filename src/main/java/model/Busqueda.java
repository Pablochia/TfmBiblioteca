package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BusquedaDao;
import dao.LibroDao;

public class Busqueda {

	//atributos
	private String nombre;

	//constructores
	public Busqueda() {
		
	}
	
	public Busqueda(String nombre) {
		super();
		this.nombre = nombre;
	}

	//getters and setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
		//metodos
	public int getEditorial(String nombre) throws SQLException {
		
		int ideditorial=BusquedaDao.getinstance().buscarEditorial(nombre);
		return ideditorial;
		
	}
	
	public int getGenero(String nombre) throws SQLException {
		
		int idgenero=BusquedaDao.getinstance().buscarGenero(nombre);
		return idgenero;
		
	}
	
	public ArrayList<Libro> getLibro(String nombre, int genero, int editorial) throws SQLException {
		
		ArrayList<Libro> lista=BusquedaDao.getinstance().buscarLibro(nombre, genero, editorial);
		
		return lista;
	}
	
	public ArrayList<Usuario> getUsuario(String nombre) throws SQLException {
		
		ArrayList<Usuario> lista=BusquedaDao.getinstance().buscarUsuario(nombre);
		
		return lista;
	}
}
