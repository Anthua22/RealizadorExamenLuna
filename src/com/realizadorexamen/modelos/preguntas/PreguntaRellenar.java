package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.Pregunta;

public class PreguntaRellenar extends Pregunta {

	private String fraseACompletar;

	private ArrayList<String> frase;

	public String getFraseACompletar() {
		return fraseACompletar;
	}

	public void setFraseACompletar(String fraseACompletar) {
		this.fraseACompletar = fraseACompletar;
	}

	public ArrayList<String> getFrase() {
		return frase;
	}

	public void setFrase(ArrayList<String> frase) {
		this.frase = frase;
	}

	public PreguntaRellenar(String textoPregunta, String textoAclaratorio, int nota, String fraseACompletar,
			ArrayList<String> frase) {
		super(textoPregunta, textoAclaratorio, nota);
		this.fraseACompletar = fraseACompletar;
		this.frase = frase;
	}

	@Override
	public String toString() {
		return "PreguntaRellenar [fraseACompletar=" + fraseACompletar + ", frase=" + frase + "]";
	}

}
