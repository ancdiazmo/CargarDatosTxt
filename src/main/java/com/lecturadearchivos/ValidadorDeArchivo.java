package com.lecturadearchivos;

import java.io.File;

import com.db.domain.HeaderInvalidoPersona;
import com.utiles.Resultado;
import com.utiles.manejadoresarchivos.ManejadorArchivosPersonas;

public class ValidadorDeArchivo {
	
	private File archivo;
	
	public ValidadorDeArchivo (File archivo) {
		setArchivo(archivo);
	}
	
	//TODO agregrar el esArchivoValidoDeCarros
	
	public Resultado esArchivoValidoDePersonas () {
		try {
			ManejadorArchivosPersonas manejadorPersonas = new ManejadorArchivosPersonas (archivo);
			if (manejadorPersonas.headerValido()) {
				return new Resultado (true);	
			}
			else {
				throw new HeaderInvalidoPersona ();
			}
		} catch (Exception e) {
			return new Resultado (false, Resultado.HEADERINCORRECTO);
		}
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	
}
