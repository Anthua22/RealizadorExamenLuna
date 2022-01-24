package com.realizadorexamen.modelos;

import java.util.ArrayList;

import com.realizadorexamen.modelos.preguntas.PreguntaDesarrolloPractico;
import com.realizadorexamen.modelos.preguntas.PreguntaRellenar;
import com.realizadorexamen.modelos.preguntas.PreguntaTeorica;
import com.realizadorexamen.modelos.preguntas.PreguntaTest;

public class Asignatura {
	private String codigo;
	private String titulo;
	private ArrayList<PreguntaTeorica> preguntasTeoricas;
	private ArrayList<PreguntaDesarrolloPractico> preguntasDesarrollo;
	private ArrayList<PreguntaTest> preguntasTest;
	private ArrayList<PreguntaRellenar> preguntasRellenar;

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
		this.preguntasDesarrollo = new ArrayList();
		this.preguntasRellenar = new ArrayList();
		this.preguntasTest = new ArrayList();
		this.preguntasTeoricas = new ArrayList();

	}

	public ArrayList<PreguntaTeorica> getPreguntasTeoricas() {
		return preguntasTeoricas;
	}

	public void setPreguntasTeoricas(ArrayList<PreguntaTeorica> preguntasTeoricas) {
		this.preguntasTeoricas = preguntasTeoricas;
	}

	public ArrayList<PreguntaDesarrolloPractico> getPreguntasDesarrollo() {
		return preguntasDesarrollo;
	}

	public void setPreguntasDesarrollo(ArrayList<PreguntaDesarrolloPractico> preguntasDesarrollo) {
		this.preguntasDesarrollo = preguntasDesarrollo;
	}

	public ArrayList<PreguntaTest> getPreguntasTest() {
		return preguntasTest;
	}

	public void setPreguntasTest(ArrayList<PreguntaTest> preguntasTest) {
		this.preguntasTest = preguntasTest;
	}

	public ArrayList<PreguntaRellenar> getPreguntasRellenar() {
		return preguntasRellenar;
	}

	public void setPreguntasRellenar(ArrayList<PreguntaRellenar> preguntasRellenar) {
		this.preguntasRellenar = preguntasRellenar;
	}

	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", titulo=" + titulo + ", preguntasTeoricas=" + preguntasTeoricas
				+ ", preguntasDesarrollo=" + preguntasDesarrollo + ", preguntasTest=" + preguntasTest
				+ ", preguntasRellenar=" + preguntasRellenar + "]";
	}

}
