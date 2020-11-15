package utilestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Container;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.db.domain.PersonaCargaDatos;
import com.utiles.Headers;
import com.utiles.manejadoresarchivos.ManejadorArchivosPersonas;
import com.utiles.manejadoresarchivos.ManejadorDeArchivos;

class ManejadorDeArchivosTest extends Container {
	
	@Test
	void leerRutaArchivoDesdeVentanaTest () {
		
		//Arrange
		ManejadorDeArchivos lector = new ManejadorDeArchivos ();
		//Act
		File archivo = lector.leerRutaArchivoDesdeVentana();
		//Assert
		assertNotNull(archivo);
	}
	
//	985198745	19	M	Juan Alberto Rincon Bolivar
//	985198746	19	M	Juan Alberto Rincon Bolivar
//	985198749	19	M	Juan Alberto Rincon Bolivar
//	9851987458	19	M	Juan Alberto Rincon Bolivar
//	9851987456	19	M	Juan Alberto Rincon Bolivar
//	9851987459	19	M	Juan Alberto Rincon Bolivar
//	9851987453	19	M	Juan Alberto Rincon Bolivar
//	98519874556	19	M	Juan Alberto Rincon Bolivar
//	98519871	19	M	Juan Alberto Rincon Bolivar
	
	@Test
	void obtenerPersonasArchivoTest() {
		
		//Arrange
		ManejadorArchivosPersonas manejador = new ManejadorArchivosPersonas (new File ("C:\\Users\\AndresCamilo\\STS-workspace\\CargarDatosTxt"
				+ "\\UtilesArchivosTests\\ArchivoValidotest.csv"));
		List<PersonaCargaDatos> personasEsperadas = new ArrayList<PersonaCargaDatos> ();
		
		personasEsperadas.add(new PersonaCargaDatos("985198745", 19, "M", "Juan Alberto Rincon Bolivar"));
		personasEsperadas.add(new PersonaCargaDatos("985198746", 19, "M", "Juan Alberto Rincon Bolivar"));
		personasEsperadas.add(new PersonaCargaDatos("985198749", 19, "M", "Juan Alberto Rincon Bolivar"));
		personasEsperadas.add(new PersonaCargaDatos("9851987458", 19, "M", "Juan Alberto Rincon Bolivar"));
		personasEsperadas.add(new PersonaCargaDatos("9851987456", 19, "M", "Juan Alberto Rincon Bolivar"));
		personasEsperadas.add(new PersonaCargaDatos("9851987459", 19, "M", "Juan Alberto Rincon Bolivar"));
		personasEsperadas.add(new PersonaCargaDatos("9851987453", 19, "M", "Juan Alberto Rincon Bolivar"));
		personasEsperadas.add(new PersonaCargaDatos("98519874556", 19, "M", "Juan Alberto Rincon Bolivar"));
		personasEsperadas.add(new PersonaCargaDatos("98519871", 19, "M", "Juan Alberto Rincon Bolivar"));
		
		//Act
		List<PersonaCargaDatos> personasObtenidas = manejador.obtenerPersonasArchivo();
		//Assert
		assertEquals(true, personasEsperadas.equals(personasObtenidas));
		
	}
	
	@Test
	void headerValidoTest () throws IOException {
		
		//Arrange
		ManejadorArchivosPersonas manejador = new ManejadorArchivosPersonas (new File ("C:\\Users\\AndresCamilo\\STS-workspace\\CargarDatosTxt"
				+ "\\UtilesArchivosTests\\ArchivoValidotest.csv"));
		
		//Act
		boolean headerValido = manejador.headerValido();
		
		//Assert
		assertTrue(headerValido);
	}
	
	@Test
	void headerInValidoTest () throws IOException {
		
		//Arrange
		ManejadorArchivosPersonas manejador = new ManejadorArchivosPersonas (new File ("C:\\Users\\AndresCamilo\\STS-workspace\\CargarDatosTxt"
				+ "\\UtilesArchivosTests\\ArchivoAcargarHeaderInvalido.csv"));
		//Act
		boolean headerValido = manejador.headerValido();
		//Assert
		assertFalse(headerValido);
	}
	
	@Test
	void headerInValidoTamañoTest () throws IOException {
		
		//Arrange
		ManejadorArchivosPersonas manejador = new ManejadorArchivosPersonas (new File ("C:\\Users\\AndresCamilo\\STS-workspace\\CargarDatosTxt"
				+ "\\UtilesArchivosTests\\ArchivoAcargarHeaderInvalidoTamaño.csv"));
		//Act
		boolean headerValido = manejador.headerValido();
		
		//Assert
		assertFalse(headerValido);
	}

}
