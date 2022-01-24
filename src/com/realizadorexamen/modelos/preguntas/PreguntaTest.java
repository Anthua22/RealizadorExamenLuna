package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.Pregunta;
import com.realizadorexamen.modelos.RespuestaTest;

public class PreguntaTest extends Pregunta {
	private boolean resta;
	private int numeroRespuestas;
	private ArrayList<RespuestaTest> opciones;

	public boolean isResta() {
		return resta;
	}

	public PreguntaTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumeroRespuestas() {
		return numeroRespuestas;
	}

	public void setNumeroRespuestas(int numeroRespuestas) {
		this.numeroRespuestas = numeroRespuestas;
	}

	public PreguntaTest(String textoPregunta, String textoAclaratorio, int nota, boolean resta,
			ArrayList<RespuestaTest> opciones, int numeroRespuesta) {
		super(textoPregunta, textoAclaratorio, nota);
		this.resta = resta;
		this.opciones = opciones;
		this.numeroRespuestas = numeroRespuesta;
	}

	public void setResta(boolean resta) {
		this.resta = resta;
	}

	@Override
	public String toString() {
		return "PreguntaTest [resta=" + resta + ", opciones=" + opciones + "]";
	}

	public ArrayList<RespuestaTest> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<RespuestaTest> opciones) {
		this.opciones = opciones;
	}

	@Override
	public String imprimirSimple() {
		String msj = "";

		for (RespuestaTest y : this.opciones) {
			msj = y.getRespuesta() + "\n";
		}

		// TODO Auto-generated method stub
		return resta
				? super.getTextoPregunta() + " " + super.getTextoAclaratorio() + " (" + super.getNota() + " puntos)\n"
						+ msj
				: super.getTextoPregunta() + " (" + super.getNota() + ")\n"+ msj;
	}

	@Override
	public String imprimirCompleto() {

		String msj = "";

		for (RespuestaTest y : this.opciones) {
			msj = y.getRespuesta() + "(" + y.isCorrecta() + ")\n";
		}

		return resta ? super.getTextoPregunta() + " " + super.getTextoAclaratorio() + " (" + super.getNota() + ")\n"+msj
				: super.getTextoPregunta() + " (" + super.getNota() + ")\n"+msj;
	}

}
