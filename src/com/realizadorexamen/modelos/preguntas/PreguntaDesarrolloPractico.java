package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.ApartadoPreguntaDesarrollo;
import com.realizadorexamen.modelos.IImpresion;
import com.realizadorexamen.modelos.Pregunta;

public class PreguntaDesarrolloPractico extends Pregunta {
	private ArrayList<ApartadoPreguntaDesarrollo> apartados;
	private ArrayList<Integer> porcentajes;

	public PreguntaDesarrolloPractico(String textoPregunta, String textoAclaratorio, int nota) {
		super(textoPregunta, textoAclaratorio, nota);
		apartados = new ArrayList<>();
		porcentajes = new ArrayList<>();
	}

	public void addApartado(ApartadoPreguntaDesarrollo apartado, int porcentaje) {
		this.apartados.add(apartado);
		this.porcentajes.add(porcentaje);
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



}
