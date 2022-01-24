package com.realizadorexamen.modelos;

import java.util.Date;
import java.util.List;

import com.realizadorexamen.enums.Convocatoria;

public class Examen {
	private Date fechaRealiacion;
	private String realizadoPor;
	private Asignatura asignatura;
	private Convocatoria conva;
	private List<Pregunta> preguntas;
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

	public Examen(Date fechaRealiacion, String realizadoPor, Asignatura asignatura, Convocatoria conva,
			List<Pregunta> preguntas) {
		super();
		this.fechaRealiacion = fechaRealiacion;
		this.realizadoPor = realizadoPor;
		this.asignatura = asignatura;
		this.conva = conva;
		this.preguntas = preguntas;
	}

	public Date getFechaRealiacion() {
		return fechaRealiacion;
	}

	public void setFechaRealiacion(Date fechaRealiacion) {
		this.fechaRealiacion = fechaRealiacion;
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

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		return "Examen [fechaRealiacion=" + fechaRealiacion + ", realizadoPor=" + realizadoPor + ", asignatura="
				+ asignatura + ", conva=" + conva + ", preguntas=" + preguntas + ", curso=" + curso + "]";
	}

	

}
