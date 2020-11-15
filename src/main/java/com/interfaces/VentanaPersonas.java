package com.interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cargueabasedatos.CargadorBaseDatos;
import com.lecturadearchivos.ValidadorDeArchivo;
import com.utiles.MostradorDeMensajes;
import com.utiles.OperacionesConStrings;
import com.utiles.Resultado;
import com.utiles.manejadoresarchivos.ManejadorDeArchivos;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.io.File;

public class VentanaPersonas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private File archivoACargar;

	public VentanaPersonas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 310);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrincipalTitulo = new JLabel("Cargue masivo de personas");
		lblPrincipalTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipalTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPrincipalTitulo.setBounds(29, 60, 338, 40);
		contentPane.add(lblPrincipalTitulo);
		
		Canvas cnvPrincipalBanner = new Canvas();
		cnvPrincipalBanner.setBackground(new Color(0, 0, 128));
		cnvPrincipalBanner.setBounds(10, 10, 560, 26);
		contentPane.add(cnvPrincipalBanner);
		
		JLabel lblPrincipalIngresaRuta = new JLabel("Ingresar personas");
		lblPrincipalIngresaRuta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipalIngresaRuta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrincipalIngresaRuta.setBounds(29, 129, 235, 26);
		contentPane.add(lblPrincipalIngresaRuta);
		
		JLabel lblPrincipalNombreArchivoPersonas = new JLabel("");
		lblPrincipalNombreArchivoPersonas.setBounds(256, 175, 224, 14);
		contentPane.add(lblPrincipalNombreArchivoPersonas);
		
		JButton btnCargarArchivoPersonas = new JButton("Ingresar archivo");
		btnCargarArchivoPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCargarArchivoPersonas.addActionListener(e -> {
			ManejadorDeArchivos lector = new ManejadorDeArchivos ();
			File archivo = lector.leerRutaArchivoDesdeVentana();
			if (archivo != null) {
				ValidadorDeArchivo validador = new ValidadorDeArchivo(archivo);
				Resultado resultado = validador.esArchivoValidoDePersonas();
				
				if (resultado.getResultado()) {
					String nombreArchivo = OperacionesConStrings.obtenerNombreDeArchivo(archivo);
					lblPrincipalNombreArchivoPersonas.setText(nombreArchivo);
					archivoACargar = archivo;
				}
				else {
					MostradorDeMensajes mensajeador = new MostradorDeMensajes ();
					mensajeador.muestraMensaje(resultado.getMensaje(), 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCargarArchivoPersonas.setBounds(54, 166, 187, 23);
		contentPane.add(btnCargarArchivoPersonas);
		
		JButton btnEnviarPersonasABaseDatos = new JButton("Comenzar carga");
		btnEnviarPersonasABaseDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnviarPersonasABaseDatos.addActionListener(e -> {
			CargadorBaseDatos cargarBD = new CargadorBaseDatos();
			if (archivoACargar != null) {
				Resultado resultadoOperacion = cargarBD.cargarArchivoPersonasBaseDatos(archivoACargar);
				if (resultadoOperacion.getResultado()) {
					MostradorDeMensajes mensajeador = new MostradorDeMensajes ();
					mensajeador.muestraMensaje(resultadoOperacion.getMensaje(), 
							JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					MostradorDeMensajes mesajeador = new MostradorDeMensajes ();
					mesajeador.muestraMensaje(resultadoOperacion.getMensaje(), 
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				MostradorDeMensajes mesajeador = new MostradorDeMensajes ();
				mesajeador.muestraMensaje("Debe de ingresar un archivo valido antes de cargar.", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnEnviarPersonasABaseDatos.setBounds(54, 200, 187, 23);
		contentPane.add(btnEnviarPersonasABaseDatos);
		
		JSeparator separatorPersonas = new JSeparator();
		separatorPersonas.setBounds(10, 114, 560, 124);
		contentPane.add(separatorPersonas);
		
		JLabel lblPrincipalNombreArchivoCarros = new JLabel("");
		lblPrincipalNombreArchivoCarros.setBounds(256, 328, 224, 14);
		contentPane.add(lblPrincipalNombreArchivoCarros);
	}
}
