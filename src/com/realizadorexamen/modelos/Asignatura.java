package com.realizadorexamen.modelos;

public class Asignatura {
	private String codigo;
	private String titulo;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Asignatura(String codigo, String titulo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", titulo=" + titulo + "]";
	}
	
	
	
}
