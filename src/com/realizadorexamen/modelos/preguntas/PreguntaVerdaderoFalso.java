package com.realizadorexamen.modelos.preguntas;

import com.realizadorexamen.modelos.IImpresion;
import com.realizadorexamen.modelos.Pregunta;

public class PreguntaVerdaderoFalso extends Pregunta implements IImpresion {

	private boolean respuesta;

	public boolean isRespuesta() {
		return respuesta;
	}

	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}

	public PreguntaVerdaderoFalso(String textoPregunta, String textoAclaratorio, int nota, boolean respuesta) {
		super(textoPregunta, textoAclaratorio, nota);
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "PreguntaVerderoFalso [respuesta=" + respuesta + "]";
	}

	@Override
	public String imprimirSimple() {
		String result = "";
		return result.concat(super.getTextoPregunta()).concat("\n").concat("\t " + super.getTextoAclaratorio() + "\n");

	}

	@Override
	public String imprimirCompleto() {
		String result = "";
		return result.concat(super.getTextoPregunta()).concat("\n").concat("\t " + super.getTextoAclaratorio() + "\n")
				.concat(respuesta ? "VERDADERO" : "FALSO");
	}

}
