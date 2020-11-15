package com.utiles;

public class Resultado {
	
	public static final String INGRESOCORRECTO = "Se ingreso de manera correcta a la BD.";
	public static final String INGRESOFALLIDO = "Se genero un error en el ingreso a la BD: ";
	public static final String HEADERINCORRECTO = "La cabecera del archivo es invalida favor rectificar.";
	private static final String ERRORDECLAVEPRIMARIA = "Se esta intentando ingresar un registro que ya existe.";
	
	private boolean valor;
	private String mensaje;
	
	public Resultado (boolean resultado) {
		this.valor = resultado;
		this.mensaje = "";
	}
	
	public Resultado (boolean resultado, String mensaje) {
		this.valor = resultado;
		this.mensaje = mensaje;
	}
	
	public Resultado (boolean resultado, String mensaje, Exception e) {
		this.valor = resultado;
		this.mensaje = mensaje + " Exception: " + interpretaException(e);
	}

	public boolean getResultado() {
		return valor;
	}

	public void setResultado(boolean resultado) {
		this.valor = resultado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	private String interpretaException (Exception e) {
		if (e instanceof org.hibernate.exception.ConstraintViolationException) {
			return ERRORDECLAVEPRIMARIA;
		}
		else {
			return e.toString();
		}
	}
}
