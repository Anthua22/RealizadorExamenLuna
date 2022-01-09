package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.Pregunta;
import com.realizadorexamen.modelos.RespuestaTest;

public class PreguntaOpciones extends Pregunta {
	private int numeroRespuestas;
	private ArrayList<RespuestaTest> respuestas;

	public int getNumeroRespuestas() {
		return numeroRespuestas;
	}

	public void setNumeroRespuestas(int numeroRespuestas) {
		this.numeroRespuestas = numeroRespuestas;
	}

	public ArrayList<RespuestaTest> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<RespuestaTest> respuestas) {
		this.respuestas = respuestas;
	}

	public PreguntaOpciones(String textoPregunta, String textoAclaratorio, int nota, int numeroRespuestas,
			ArrayList<RespuestaTest> respuestas) {
		super(textoPregunta, textoAclaratorio, nota);
		this.numeroRespuestas = numeroRespuestas;
		this.respuestas = respuestas;
	}

}
