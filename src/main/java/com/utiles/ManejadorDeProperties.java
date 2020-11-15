package com.utiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ManejadorDeProperties {
	
	//TODO hay que modificar este metodo para que trabaje con un archivo de propeties externo
	public Properties obtenerProperties () throws IOException {
		
		Properties properties = new Properties ();
		FileReader reader = new FileReader ("C:\\CargaDatosConfig\\config.properties");
		properties.load(reader);
		return properties;
	}

}
