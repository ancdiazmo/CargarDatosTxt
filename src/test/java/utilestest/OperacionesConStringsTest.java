package utilestest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import org.junit.jupiter.api.Test;

import com.utiles.OperacionesConStrings;

class OperacionesConStringsTest {
	
	@Test
	void obtenerNombreDeArchivoTest () {
		//Arrange
		File valorAProbar = new File ("C:\\Users\\AndresCamilo\\STS-workspace\\CargarDatosTxt\\UtilesArchivosTests\\Archivo a cargar test.txt");
		//Act
		String valorEsperado = "Archivo a cargar test.txt";
		String valorOptenido = OperacionesConStrings.obtenerNombreDeArchivo(valorAProbar);
		//Assert
		assertEquals(valorEsperado, valorOptenido);
	}
	
}
