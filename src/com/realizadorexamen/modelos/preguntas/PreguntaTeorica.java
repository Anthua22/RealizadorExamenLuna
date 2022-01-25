package com.realizadorexamen.modelos.preguntas;

import com.realizadorexamen.modelos.IImpresion;
import com.realizadorexamen.modelos.Pregunta;

public class PreguntaTeorica extends Pregunta {
	private String respuestaCorrecta;

	@Override
	public String toString() {
		return "PreguntaTeorica [respuestaCorrecta=" + respuestaCorrecta + "]";
	}

	public PreguntaTeorica(String textoPregunta, String textoAclaratorio, float nota, String respuestaCorrecta) {
		super(textoPregunta, textoAclaratorio, nota);
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String imprimirSimple() {
		String result = "";
		return result.concat(super.getTextoPregunta()).concat(". ")
				.concat(super.getTextoAclaratorio() + " (" + super.getNota() + " puntos)\n");

	}

	@Override
	public String imprimirCompleto() {
		String result = "";
		return result.concat(super.getTextoPregunta()).concat(".")
				.concat(super.getTextoAclaratorio() + " (" + super.getNota() + " puntos)")
				.concat("\n Respuesta: " + respuestaCorrecta + "\n");
	}
}
