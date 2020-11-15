package com.utiles;

import java.awt.Container;
import javax.swing.JOptionPane;

/**
 * La clase MostradorDeMensajes tiene como proposito centralizar el codigo que muestra los mensajes por 
 * pantalla
 * @author AndresCamilo
 *
 */
public class MostradorDeMensajes extends Container{

	public void muestraMensaje (String mensaje, int tipoMensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", tipoMensaje);
	}
}
