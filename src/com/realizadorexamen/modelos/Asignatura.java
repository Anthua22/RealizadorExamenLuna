package com.realizadorexamen.modelos;

import java.util.ArrayList;

public class Asignatura {
	private String codigo;
	private String titulo;
	private ArrayList<Pregunta> preguntas;
	
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
	public Asignatura(String codigo, String titulo, ArrayList<Pregunta> preguntas) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.preguntas = preguntas;
	}
	
	
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", titulo=" + titulo + ", preguntas=" + preguntas + "]";
	}
	
	
	
	
	
}
