package com.realizadorexamen.modelos;

public class ApartadoPreguntaDesarrollo {
	private String textoApartado;
	private float porcentajeNota;

	public String getTextoApartado() {
		return textoApartado;
	}

	public void setTextoApartado(String textoApartado) {
		this.textoApartado = textoApartado;
	}

	public float getPorcentajeNota() {
		return porcentajeNota;
	}

	public void setPorcentajeNota(float porcentajeNota) {
		this.porcentajeNota = porcentajeNota;
	}

	public ApartadoPreguntaDesarrollo(String textoApartado, float porcentajeNota) {
		super();
		this.textoApartado = textoApartado;
		this.porcentajeNota = porcentajeNota;
	}

	@Override
	public String toString() {
		return "ApartadoPreguntaDesarrollo [textoApartado=" + textoApartado + ", porcentajeNota=" + porcentajeNota
				+ "]";
	}

	

}
