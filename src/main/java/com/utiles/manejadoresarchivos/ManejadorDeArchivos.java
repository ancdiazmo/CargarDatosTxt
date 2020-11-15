package com.utiles.manejadoresarchivos;

import java.awt.Container;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import javax.swing.JFileChooser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * La clase LectorDeArchivos tiene como objetivo centralizar el codigo con el que se leen archivos por
 * pantalla
 * @author AndresCamilo
 *
 */

public class ManejadorDeArchivos extends Container {
	
	private static final long serialVersionUID = 1L;
	
	protected Reader reader;
	protected CSVFormat formato;
	protected CSVParser parser;
	protected List<CSVRecord> csv;
	protected String [] header;
	
	public ManejadorDeArchivos () {}
	
	public ManejadorDeArchivos (File archivo, String[] header) {
		try {
			this.header = header;
			reader = new FileReader (archivo.getAbsolutePath());
			formato = CSVFormat.EXCEL.withDelimiter(';').withHeader(header);
			parser = formato.parse(reader);
			csv = parser.getRecords(); //El parser.getRecords solo se puede ejecutar una vez ya que el parser se vacia
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File leerRutaArchivoDesdeVentana () {
		JFileChooser leeRuta = new JFileChooser ();
		leeRuta.showOpenDialog(this);
		File archivo = leeRuta.getSelectedFile();
		return archivo;
	}

	public boolean headerValido () {
		CSVRecord headerActual = csv.get(0);
		boolean valido = true;
		int contador = 0;
		if (headerActual.size() == header.length) {
			for (String campo: headerActual) {
				if (!campo.equalsIgnoreCase(header[contador])) {
					valido = false;
				}
				contador++;
			}
		}
		else {
			valido = false;
		}
		return valido;
	}
}
