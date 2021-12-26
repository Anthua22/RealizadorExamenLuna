package com.realizadorexamen.modelos;

public class PreguntaDesarrolloPractico extends Pregunta {
	private String textoApartado;
	private int porcentajeNota;

	public PreguntaDesarrolloPractico(String textoPregunta, String textoAclaratorio, int nota, String textoApartado,
			int porcentajeNota) {
		super(textoPregunta, textoAclaratorio, nota);
		this.textoApartado = textoApartado;
		this.porcentajeNota = porcentajeNota;
	}

	@Override
	public String toString() {
		return "PreguntaDesarrolloPractico [textoApartado=" + textoApartado + ", porcentajeNota=" + porcentajeNota
				+ "]";
	}

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

}
