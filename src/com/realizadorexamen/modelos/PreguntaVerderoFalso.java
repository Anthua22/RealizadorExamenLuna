package com.realizadorexamen.modelos;

public class PreguntaVerderoFalso extends Pregunta{

	private boolean respuesta;

	public boolean isRespuesta() {
		return respuesta;
	}

	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}

	public PreguntaVerderoFalso(String textoPregunta, String textoAclaratorio, int nota, boolean respuesta) {
		super(textoPregunta, textoAclaratorio, nota);
		this.respuesta = respuesta;
	}
	
	
	
}
