package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.ApartadoPreguntaDesarrollo;
import com.realizadorexamen.modelos.Pregunta;

public class PreguntaDesarrolloPractico extends Pregunta {
	private ArrayList<ApartadoPreguntaDesarrollo> apartados;
	
	public PreguntaDesarrolloPractico(String textoPregunta, String textoAclaratorio, int nota) {
		super(textoPregunta, textoAclaratorio, nota);
		apartados = new ArrayList<>();

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
	
	
}
