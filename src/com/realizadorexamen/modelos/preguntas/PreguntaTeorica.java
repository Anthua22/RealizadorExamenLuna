package com.realizadorexamen.modelos.preguntas;

import com.realizadorexamen.modelos.Pregunta;

public class PreguntaTeorica extends Pregunta {
	private String respuestaCorrecta;

	@Override
	public String toString() {
		return "PreguntaTeorica [respuestaCorrecta=" + respuestaCorrecta + "]";
	}

	public PreguntaTeorica(String textoPregunta, String textoAclaratorio, int nota, String respuestaCorrecta) {
		super(textoPregunta, textoAclaratorio, nota);
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
}
