package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.IImpresion;
import com.realizadorexamen.modelos.Pregunta;
import com.realizadorexamen.modelos.RespuestaTest;

public class PreguntaOpciones extends Pregunta implements IImpresion {
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

	@Override
	public String imprimirSimple() {
		String result = "";
		String opciones = "";
		this.respuestas.forEach(x -> opciones.concat(x.getRespuesta() + "\n"));
		return result.concat(super.getTextoPregunta()).concat(" (" + super.getTextoAclaratorio() + ")\n")
				.concat(opciones);

	}

	@Override
	public String imprimirCompleto() {
		String result = "";
		String opciones = "";
		this.respuestas.forEach(x -> {
			if(x.isCorrecta())
				opciones.concat(x.getRespuesta() + " Si\n");
			else
				opciones.concat(x.getRespuesta() + " No\n");
			
		});

		return result.concat(super.getTextoPregunta()).concat(" (" + super.getTextoAclaratorio() + ")\n")
				.concat(opciones);

	}

}
