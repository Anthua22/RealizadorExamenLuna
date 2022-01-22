package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.Pregunta;

public class PreguntaTest extends Pregunta {
	private boolean resta;

	private ArrayList<PreguntaTest> tiposPregunta;

	public boolean isResta() {
		return resta;
	}

	public void setResta(boolean resta) {
		this.resta = resta;
	}

	public ArrayList<PreguntaTest> getTiposPregunta() {
		return tiposPregunta;
	}

	public void setTiposPregunta(ArrayList<PreguntaTest> tiposPregunta) {
		this.tiposPregunta = tiposPregunta;
	}

	public PreguntaTest(String textoPregunta, String textoAclaratorio, int nota, boolean resta,
			ArrayList<PreguntaTest> tiposPregunta) {
		super(textoPregunta, textoAclaratorio, nota);
		this.resta = resta;
		this.tiposPregunta = tiposPregunta;
	}

	public PreguntaTest(int nota, boolean resta,
			ArrayList<PreguntaTest> tiposPregunta) {
		this.resta = resta;
		this.tiposPregunta = tiposPregunta;
	}
	

}
