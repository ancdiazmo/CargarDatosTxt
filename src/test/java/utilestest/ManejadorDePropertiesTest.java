package utilestest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.junit.jupiter.api.Test;
import com.utiles.ManejadorDeProperties;

class ManejadorDePropertiesTest {
	
	@Test
	void obtenerPropertiesTest () throws IOException {
		
		//Arrange
		ManejadorDeProperties manejador = new ManejadorDeProperties ();
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "SPRINGUSER";
		String pass = "12345";
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
//		String HBM2 = "create-drop";
		
		//Act
		Properties properties = manejador.obtenerProperties();
		
		//Assert
		assertEquals(driver, properties.getProperty(Environment.DRIVER));
		assertEquals(user, properties.getProperty(Environment.USER));
		assertEquals(pass, properties.getProperty(Environment.PASS));
		assertEquals(url, properties.getProperty(Environment.URL));
//		assertEquals(HBM2, properties.getProperty(Environment.HBM2DDL_AUTO));
	}

}
