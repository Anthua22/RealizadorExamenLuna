package com.realizadorexamen.modelos.preguntas;

import java.util.ArrayList;

import com.realizadorexamen.modelos.ApartadoPreguntaDesarrollo;
import com.realizadorexamen.modelos.IImpresion;
import com.realizadorexamen.modelos.Pregunta;

public class PreguntaDesarrolloPractico extends Pregunta {
	private ArrayList<ApartadoPreguntaDesarrollo> apartados;

	public PreguntaDesarrolloPractico(String textoPregunta, String textoAclaratorio, int nota,
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
		this.apartados.forEach(x -> apartadosSt.concat(x.getTextoApartado() + " (" + x.getPorcentajeNota() + ")\n"));
		return result.concat(super.getTextoPregunta()).concat(".")
				.concat(super.getTextoAclaratorio() + " (" + super.getNota() + " puntos)\n").concat(apartadosSt);
	}

	@Override
	public String imprimirCompleto() {
		String result = "";
		String apartadosSt = "";
		this.apartados.forEach(x -> apartadosSt.concat(x.getTextoApartado() + " (" + x.getPorcentajeNota() + ")\n"));
		return result.concat(super.getTextoPregunta()).concat(".")
				.concat(super.getTextoAclaratorio() + " (" + super.getNota() + " puntos)\n").concat(apartadosSt);
	}

}
