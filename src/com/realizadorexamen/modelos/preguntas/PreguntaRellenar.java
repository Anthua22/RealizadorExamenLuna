package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.IImpresion;
import com.realizadorexamen.modelos.Pregunta;

public class PreguntaRellenar extends Pregunta {

	private String fraseACompletar;

	private ArrayList<String> frases;

	public String getFraseACompletar() {
		return fraseACompletar;
	}

	public void setFraseACompletar(String fraseACompletar) {
		this.fraseACompletar = fraseACompletar;
	}

	public ArrayList<String> getFrase() {
		return frases;
	}

	public void setFrase(ArrayList<String> frase) {
		this.frases = frase;
	}

	public PreguntaRellenar(String textoPregunta, String textoAclaratorio, int nota, String fraseACompletar,
			ArrayList<String> frase) {
		super(textoPregunta, textoAclaratorio, nota);
		this.fraseACompletar = fraseACompletar;
		this.frases = frase;
	}

	@Override
	public String toString() {
		return "PreguntaRellenar [fraseACompletar=" + fraseACompletar + ", frase=" + frases + "]";
	}

	@Override
	public String imprimirSimple() {
		String result = "";
		return result.concat(super.getTextoPregunta()).concat(".")
				.concat(super.getTextoAclaratorio() + " (" + super.getNota() + " puntos)\n").concat(fraseACompletar);
	}

	@Override
	public String imprimirCompleto() {
		String result = "";
		String frases = "";
		this.frases.forEach(x -> frases.concat(x + "\n"));
		return result.concat(super.getTextoPregunta()).concat(".")
				.concat(super.getTextoAclaratorio() + " (" + super.getNota() + " puntos)\n")
				.concat(fraseACompletar + "\n").concat(frases);

	}

}
