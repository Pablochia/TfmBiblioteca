package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.EditorialDao;
import dao.GeneroDao;

public class Genero implements Serializable{
	
	//atributos
	private int codigo;
	private String nombre;
	
	
		//constructores
	public Genero() {
		this.codigo=0;
		this.nombre="";
	}
	
	public Genero(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//getters and setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	//metodos
	public boolean registrar() throws SQLException {
		
		boolean registrar=GeneroDao.getinstance().registrar(this);
		return registrar;
		
	}
	
	public String getGenero() throws SQLException {
		
		String genero=GeneroDao.getinstance().getGenero(this.getCodigo());
		
		return genero;
	}
	
	public ArrayList<Genero> listar() throws SQLException {
		
		ArrayList<Genero> lista=GeneroDao.getinstance().listar();
		
		return lista;
	}
	
	
	

}
