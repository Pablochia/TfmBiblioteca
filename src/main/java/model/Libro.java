package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.GeneroDao;
import dao.LibroDao;

public class Libro {

	//attçributos
	private String isbn;
	private String titulo;
	private String descripcion;
	private String nombre_autor;
	private int idgenero;
	private int nit_editorial;
	private String foto;
	
	//constructores
	public Libro() {
		this.isbn = "";
		this.titulo = "";
		this.descripcion = "";
		this.nombre_autor ="";
		this.idgenero =0;
		this.nit_editorial =0;
	}

	public Libro(String isbn, String titulo, String descripcion, String nombre_autor,
		 int codigo_categoria, int nit_editorial, String foto) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.nombre_autor = nombre_autor;
		this.idgenero = codigo_categoria;
		this.nit_editorial = nit_editorial;
		this.foto=foto;
	}
	
	//getters and setters

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIdgenero() {
		return idgenero;
	}

	public void setIdgenero(int idgenero) {
		this.idgenero = idgenero;
	}

	public int getNit_editorial() {
		return nit_editorial;
	}

	public void setNit_editorial(int nit_editorial) {
		this.nit_editorial = nit_editorial;
	}

	
	
	//metodos
	public boolean registrar() throws SQLException {
		System.out.println("registrando Clse");
		boolean registrar=LibroDao.getinstance().registrar(this);
		return registrar;
		
	}
	
	public boolean actualizar() throws SQLException {
		
		boolean actualizar=LibroDao.getinstance().actualizar(this);
		return actualizar;
		
	}
	
	public boolean eliminarr() throws SQLException {
		
		boolean eliminar=LibroDao.getinstance().eliminar(this);
		return eliminar;
		
	}
	
	public ArrayList<Libro> listar() throws SQLException {
		
		ArrayList<Libro> lista=LibroDao.getinstance().listar();
		
		return lista;
	}
	
	public Libro getLibro() throws SQLException {
		
		Libro libro=LibroDao.getinstance().getLibro(this.getIsbn());
		
		return libro;
	}
	
	
	
	
	
}
