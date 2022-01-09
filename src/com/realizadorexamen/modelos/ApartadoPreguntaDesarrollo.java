package com.realizadorexamen.modelos;

public class ApartadoPreguntaDesarrollo {
	private String textoApartado;
	private int porcentajeNota;
	public String getTextoApartado() {
		return textoApartado;
	}
	public void setTextoApartado(String textoApartado) {
		this.textoApartado = textoApartado;
	}
	public int getPorcentajeNota() {
		return porcentajeNota;
	}
	public void setPorcentajeNota(int porcentajeNota) {
		this.porcentajeNota = porcentajeNota;
	}
	
	public ApartadoPreguntaDesarrollo(String textoApartado, int porcentajeNota) {
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
