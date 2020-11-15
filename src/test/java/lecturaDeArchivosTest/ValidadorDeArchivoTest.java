package lecturaDeArchivosTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import org.junit.jupiter.api.Test;

import com.lecturadearchivos.ValidadorDeArchivo;
import com.utiles.Resultado;

class ValidadorDeArchivoTest {
	
	@Test
	void esArchivoValidoTest () {
		
		//Arrange
		File archivo = new File ("C:\\Users\\AndresCamilo\\STS-workspace\\CargarDatosTxt\\UtilesArchivosTests\\ArchivoValidotest.csv");
		ValidadorDeArchivo validador = new ValidadorDeArchivo (archivo);
		
		//Act
		Resultado archivoValido = validador.esArchivoValidoDePersonas();
		
		//Assert
		assertNotNull(validador.getArchivo());
		assertTrue(archivoValido.getResultado());
	}
	
}
