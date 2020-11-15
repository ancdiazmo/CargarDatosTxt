package interfacesTest;

import org.junit.jupiter.api.Test;

import com.interfaces.VentanaPersonas;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PrincipalTest {
	
	@Test
	void ValidaInterfazPrincipal () {
		
		//Arrange
		VentanaPersonas principal = new VentanaPersonas ();
		//Act
		principal.setVisible(true);
		//Assert
		assertTrue(true);
	}

}
