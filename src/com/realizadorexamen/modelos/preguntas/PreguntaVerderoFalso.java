package com.realizadorexamen.modelos.preguntas;

import com.realizadorexamen.modelos.Pregunta;

public class PreguntaVerderoFalso extends PreguntaTest{

	private boolean respuesta;

	public boolean isRespuesta() {
		return respuesta;
	}

	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}

	public PreguntaVerderoFalso(String textoPregunta, String textoAclaratorio, int nota, boolean respuesta) {
		super(textoPregunta, textoAclaratorio);
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "PreguntaVerderoFalso [respuesta=" + respuesta + "]";
	}
	
	
	
}
