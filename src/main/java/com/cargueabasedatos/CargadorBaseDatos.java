package com.cargueabasedatos;

import java.io.File;
import java.util.List;

import com.db.dao.PersonaDAO;
import com.db.domain.PersonaCargaDatos;
import com.utiles.Resultado;
import com.utiles.manejadoresarchivos.ManejadorArchivosPersonas;

public class CargadorBaseDatos {
	
	//TODO agregrar el cargarArchivoCarrosBaseDatos
	
	public Resultado cargarArchivoPersonasBaseDatos(File archivo) {
		try {
			ManejadorArchivosPersonas manejadorPersonas = new ManejadorArchivosPersonas (archivo);
			List<PersonaCargaDatos> personas = manejadorPersonas.obtenerPersonasArchivo();	
			PersonaDAO personaDAO = new PersonaDAO ();
	
			personas.forEach(persona -> personaDAO.save(persona));
			return new Resultado (true, Resultado.INGRESOCORRECTO);
		} catch (Exception e) {
			return new Resultado (false, Resultado.INGRESOFALLIDO, e);
		}
	}

}
