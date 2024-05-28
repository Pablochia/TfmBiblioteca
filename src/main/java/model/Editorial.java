package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EditorialDao;

public class Editorial implements Serializable {

	//atributos
	private int id;
	private String nombre;

	
	//constructores
	public Editorial() {
		this.nombre = "";
	}


	public Editorial(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	

	//getters and setter

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
	
	
		//metodos
	public boolean registrar() throws SQLException {
		
		boolean registrar=EditorialDao.getinstance().registrar(this);
		return registrar;
		
	}
	
	public String getEditorial() throws SQLException {
		
		String editorial=EditorialDao.getinstance().getEditorial(this.getId());
		
		return editorial;
	}
	
	
	
	public ArrayList<Editorial> listar() throws SQLException {
		
		ArrayList<Editorial> lista=EditorialDao.getinstance().listar();
		
		return lista;
	}
	
}
