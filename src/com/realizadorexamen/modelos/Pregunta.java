package com.realizadorexamen.modelos;

public abstract class Pregunta implements IImpresion {
	private String textoPregunta;
	private String textoAclaratorio;
	private float nota;

	public Pregunta() {
		super();
	}

	public Pregunta(String textoPregunta, String textoAclaratorio, float nota) {
		super();
		this.textoPregunta = textoPregunta;
		this.textoAclaratorio = textoAclaratorio;
		this.nota = nota;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}

	public void setTextoPregunta(String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public String getTextoAclaratorio() {
		return textoAclaratorio;
	}

	public void setTextoAclaratorio(String textoAclaratorio) {
		this.textoAclaratorio = textoAclaratorio;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Pregunta [textoPregunta=" + textoPregunta + ", textoAclaratorio=" + textoAclaratorio + ", nota=" + nota
				+ "]";
	}

}
