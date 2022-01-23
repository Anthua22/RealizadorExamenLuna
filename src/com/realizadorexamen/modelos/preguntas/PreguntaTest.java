package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.IImpresion;
import com.realizadorexamen.modelos.Pregunta;

public class PreguntaTest extends Pregunta implements IImpresion {
	private boolean resta;

	private ArrayList<PreguntaVerdaderoFalso> verdaderoFalso;

	private ArrayList<PreguntaOpciones> opciones;

	public boolean isResta() {
		return resta;
	}

	public PreguntaTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreguntaTest(String textoPregunta, String textoAclaratorio, int nota, boolean resta) {
		super(textoPregunta, textoAclaratorio, nota);
		this.resta = resta;
	}

	public void setResta(boolean resta) {
		this.resta = resta;
	}

	public ArrayList<PreguntaVerdaderoFalso> getVerdaderoFalso() {
		return verdaderoFalso;
	}

	public void setVerdaderoFalso(ArrayList<PreguntaVerdaderoFalso> verdaderoFalso) {
		this.verdaderoFalso = verdaderoFalso;
	}

	public ArrayList<PreguntaOpciones> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<PreguntaOpciones> opciones) {
		this.opciones = opciones;
	}

	@Override
	public String toString() {
		return "PreguntaTest [resta=" + resta + ", verdaderoFalso=" + verdaderoFalso + ", opciones=" + opciones + "]";
	}

	@Override
	public String imprimirSimple() {
		// TODO Auto-generated method stub
		return resta ? "Preguntas tipo test" : "Preguntas tipo test. Por cada pregunta fallada resta 1";
	}

	@Override
	public String imprimirCompleto() {
		// TODO Auto-generated method stub
		return resta ? "Preguntas tipo test" : "Preguntas tipo test. Por cada pregunta fallada resta 1";
	}

}
