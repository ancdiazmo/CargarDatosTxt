package utilestest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Container;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.Test;

import com.utiles.MostradorDeMensajes;

class MostradorDeMensajesTest extends Container{

	@Test
	void muestraMensajeTest () {
		
		//Arrange
		String mensaje = "Hola mundo Test";
		int tipoMensaje = JOptionPane.INFORMATION_MESSAGE;
		MostradorDeMensajes mensajeador = new MostradorDeMensajes ();
		
		//Act
		mensajeador.muestraMensaje(mensaje, tipoMensaje);
		
		//Assert
		assertTrue(true);
	}
}
