package com.utiles;

import java.io.File;

public class OperacionesConStrings {
	
	private OperacionesConStrings () {}
	
	public static String obtenerNombreDeArchivo (File archivo) {
		
		String ruta = archivo.getAbsolutePath();
		String [] archivoDividido = ruta.split("\\\\");
		String nombreArchivo = archivoDividido[archivoDividido.length - 1];
		return nombreArchivo;
	}

}
