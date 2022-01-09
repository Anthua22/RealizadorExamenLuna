package com.realizadorexamen.modelos;

public class RespuestaTest {
	private String respuesta;
	private boolean correcta;
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public boolean isCorrecta() {
		return correcta;
	}
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	public RespuestaTest(String respuesta, boolean correcta) {
		super();
		this.respuesta = respuesta;
		this.correcta = correcta;
	}
	@Override
	public String toString() {
		return "RespuestaTest [respuesta=" + respuesta + ", correcta=" + correcta + "]";
	}
	
	
}
