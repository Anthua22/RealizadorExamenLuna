package com.realizadorexamen.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.realizadorexamen.enums.Convocatoria;
import com.realizadorexamen.modelos.preguntas.PreguntaDesarrolloPractico;
import com.realizadorexamen.modelos.preguntas.PreguntaRellenar;
import com.realizadorexamen.modelos.preguntas.PreguntaTeorica;
import com.realizadorexamen.modelos.preguntas.PreguntaTest;

public class Examen implements IImpresion {
	private Date fechaRealizacion;
	private String realizadoPor;
	private Asignatura asignatura;
	private Convocatoria conva;
	private ArrayList<PreguntaTeorica> preguntasTeoricas;
	private ArrayList<PreguntaDesarrolloPractico> preguntasDesarrollo;
	private ArrayList<PreguntaTest> preguntasTest;
	private ArrayList<PreguntaRellenar> preguntasRellenar;

	private String curso;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Examen() {
		super();
	}

	public Examen(Date fechaRealiacion, String realizadoPor, Asignatura asignatura, Convocatoria conva, String curso) {
		super();
		this.fechaRealizacion = fechaRealiacion;
		this.realizadoPor = realizadoPor;
		this.asignatura = asignatura;
		this.conva = conva;
		this.curso = curso;
	}

	public Date getFechaRealiacion() {
		return fechaRealizacion;
	}

	public void setFechaRealiacion(Date fechaRealiacion) {
		this.fechaRealizacion = fechaRealiacion;
	}

	public String getRealizadoPor() {
		return realizadoPor;
	}

	public void setRealizadoPor(String realizadoPor) {
		this.realizadoPor = realizadoPor;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Convocatoria getConva() {
		return conva;
	}

	public void setConva(Convocatoria conva) {
		this.conva = conva;
	}

	@Override
	public String toString() {
		return "Examen [fechaRealiacion=" + fechaRealizacion + ", realizadoPor=" + realizadoPor + ", asignatura="
				+ asignatura + ", conva=" + conva + ", preguntasTeoricas=" + preguntasTeoricas
				+ ", preguntasDesarrollo=" + preguntasDesarrollo + ", preguntasTest=" + preguntasTest
				+ ", preguntasRellenar=" + preguntasRellenar + ", curso=" + curso + "]";
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
	public String imprimirSimple() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String imprimirCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

}
