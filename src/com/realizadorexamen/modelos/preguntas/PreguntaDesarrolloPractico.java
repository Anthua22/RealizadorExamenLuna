package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.ApartadoPreguntaDesarrollo;
import com.realizadorexamen.modelos.IImpresion;
import com.realizadorexamen.modelos.Pregunta;

public class PreguntaDesarrolloPractico extends Pregunta {
	private ArrayList<ApartadoPreguntaDesarrollo> apartados;

	public PreguntaDesarrolloPractico(String textoPregunta, String textoAclaratorio, float nota,
			ArrayList<ApartadoPreguntaDesarrollo> apartados) {
		super(textoPregunta, textoAclaratorio, nota);
		this.apartados = apartados;

	}

	public void addApartado(ApartadoPreguntaDesarrollo apartado) {
		this.apartados.add(apartado);

	}

	public ArrayList<ApartadoPreguntaDesarrollo> getApartados() {
		return apartados;
	}

	public void setApartados(ArrayList<ApartadoPreguntaDesarrollo> apartados) {
		this.apartados = apartados;
	}

	@Override
	public String toString() {
		return "PreguntaDesarrolloPractico [apartados=" + apartados + "]";
	}

	@Override
	public String imprimirSimple() {
		String result = "";
		String apartadosSt = "";
		for (ApartadoPreguntaDesarrollo x : this.apartados) {
			apartadosSt += x.getTextoApartado() + " (" + x.getPorcentajeNota() + " puntos)\n";
		}
		return result.concat(super.getTextoPregunta()).concat(".")
				.concat(super.getTextoAclaratorio() + " (" + super.getNota() + " puntos)\n").concat(apartadosSt);
	}

	@Override
	public String imprimirCompleto() {
		return this.imprimirSimple();
	}

	public static boolean ckeckPuntosPropocion(float puntosTotal, float puntos) throws Exception {
		if (puntosTotal != puntos)
			throw new Exception("La suma de puntos de los apartados no es igual a " + puntosTotal);
		return true;
	}

	public static boolean ckeckPuntosExamenMixto(float puntosTotal) throws Exception {
		if (puntosTotal != 4)
			throw new Exception("La pregunta de tipo desarrollo tiene que valer 4 puntos");
		return true;
	}
}
