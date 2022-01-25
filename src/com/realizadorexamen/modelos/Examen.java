package com.realizadorexamen.modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	private int nPreguntas;

	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public int getnPreguntas() {
		return nPreguntas;
	}

	public void setnPreguntas(int nPreguntas) {
		this.nPreguntas = nPreguntas;
	}

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
		String exa = "";
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		exa += objSDF.format(fechaRealizacion) + " - ";
		exa += this.realizadoPor + " - ";
		exa += this.getAsignatura().getTitulo() + " - ";
		exa += this.conva + " - ";
		exa += this.curso + " - ";
		exa += this.nPreguntas + " preguntas";

		return exa;
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
		String examen = "";
		examen = this.asignatura.getTitulo() + " - " + this.asignatura.getCodigo() + "\nCurso: " + this.curso
				+ "\nRealizado por: " + this.realizadoPor + " (" + this.fechaRealizacion.toString()
				+ ")\tConvocatoria:  " + this.conva + "\n";
		int cont = 1;
		if (this.preguntasTest != null && this.preguntasTest.size() > 0) {
			examen += "Prengutas de tipo test: \n";
			for (PreguntaTest test : this.preguntasTest) {
				examen += cont + ". " + test.imprimirSimple();
				cont++;
			}

		}

		if (this.preguntasDesarrollo != null && this.preguntasDesarrollo.size() > 0) {
			examen += "Prengutas de tipo Desarrollo: \n";
			for (PreguntaDesarrolloPractico x : this.preguntasDesarrollo) {
				examen += cont + ". " + x.imprimirSimple();
				cont++;
			}
		}

		if (this.preguntasRellenar != null && this.preguntasRellenar.size() > 0) {
			examen += "Prengutas de tipo Rellenar"
					+ ": \n";
			for (PreguntaRellenar x : this.preguntasRellenar) {
				examen += cont + ". " + x.imprimirSimple();
				cont++;
			}
		}
		if (this.preguntasTeoricas != null && this.preguntasTeoricas.size() > 0) {
			examen += "Prengutas tipo Teóricas: \n";
			for (PreguntaTeorica x : this.preguntasTeoricas) {
				examen += cont + ". " + x.imprimirSimple();
				cont++;
			}
		}

		return examen;
	}

	@Override
	public String imprimirCompleto() {
		String examen = "";
		examen = this.asignatura.getTitulo() + " - " + this.asignatura.getCodigo() + "\nCurso: " + this.curso
				+ "\nRealizado por: " + this.realizadoPor + " (" + this.fechaRealizacion.toString()
				+ ")\tConvocatoria:  " + this.conva + "\n";
		int cont = 1;
		if (this.preguntasTest != null && this.preguntasTest.size() > 0) {
			examen += "Preguntas de tipo test: \n";
			for (PreguntaTest test : this.preguntasTest) {
				examen += cont + ". " + test.imprimirCompleto();
				cont++;
			}

		}

		if (this.preguntasDesarrollo != null && this.preguntasDesarrollo.size() > 0) {
			examen += "Preguntas de tipo Desarrollo: \n";
			for (PreguntaDesarrolloPractico x : this.preguntasDesarrollo) {
				examen += cont + ". " + x.imprimirCompleto();
				cont++;
			}
		}

		if (this.preguntasRellenar != null && this.preguntasRellenar.size() > 0) {
			examen += "Preguntas de tipo Rellenar: \n";
			for (PreguntaRellenar x : this.preguntasRellenar) {
				examen += cont + ". " + x.imprimirCompleto();
				cont++;
			}
		}
		if (this.preguntasTeoricas != null && this.preguntasTeoricas.size() > 0) {
			examen += "Preguntas tipo Teóricas: \n";
			for (PreguntaTeorica x : this.preguntasTeoricas) {
				examen += cont + ". " + x.imprimirCompleto();
				cont++;
			}
		}

		return examen;

	}

	public boolean ckeckPuntos() throws Exception {
		int puntos = 0;
		if (this.preguntasTest != null && this.preguntasTest.size() > 0) {
			for (PreguntaTest test : this.preguntasTest) {
				puntos += test.getNota();
			}
		}

		if (this.preguntasDesarrollo != null && this.preguntasDesarrollo.size() > 0) {
			for (PreguntaDesarrolloPractico x : this.preguntasDesarrollo) {
				puntos+=x.getNota();
			}
		}

		if (this.preguntasRellenar != null && this.preguntasRellenar.size() > 0) {
			for (PreguntaRellenar x : this.preguntasRellenar) {
				puntos+=x.getNota();
			}
		}
		if (this.preguntasTeoricas != null && this.preguntasTeoricas.size() > 0) {
			for (PreguntaTeorica x : this.preguntasTeoricas) {
				puntos+=x.getNota();
			}
		}
		if (puntos != 10)
			throw new Exception("La suma de puntos de la preguntas del examen no es igual a 10");
		return true;
	}
}
