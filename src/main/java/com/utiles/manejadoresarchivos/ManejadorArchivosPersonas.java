package com.utiles.manejadoresarchivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.db.domain.PersonaCargaDatos;
import com.utiles.Headers;

public class ManejadorArchivosPersonas extends ManejadorDeArchivos{
	
	
	public ManejadorArchivosPersonas (File archivo) {
		super (archivo, Headers.personaHeader);
	}
	
	public List<PersonaCargaDatos> obtenerPersonasArchivo () {
		List<PersonaCargaDatos> personas = new ArrayList<> ();
		csv.remove(0); //se quita la cabecera para comenzar a crear los objetos PersonaCargaDatos
		for (CSVRecord record: csv) {
			personas.add(new PersonaCargaDatos (record.get(Headers.personaHeader[0]), 
					Integer.parseInt(record.get(Headers.personaHeader[1])), record.get(Headers.personaHeader[2])
					, record.get(Headers.personaHeader[3])));
		}
		return personas;
	}

}
