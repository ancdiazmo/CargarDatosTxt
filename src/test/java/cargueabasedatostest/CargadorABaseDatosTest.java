package cargueabasedatostest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cargueabasedatos.CargadorBaseDatos;
import com.db.dao.PersonaDAO;

import queriatorstest.OracleQueryator;
import queriatorstest.Queryator;

class CargadorABaseDatosTest {
	
	private static PersonaDAO personaDAO;
	private static String CONNECTIONSTRING;
	private static String USER;
	private static String PASSWORD;
	
	@BeforeAll
	public static void empezar () {
		personaDAO = new PersonaDAO (); //El DAO llama a HibernateConfig, y hace drop-create de las tablas en oracle
		personaDAO.deleteAll();
		
		CONNECTIONSTRING = "jdbc:oracle:thin:@//localhost:1521/xe";
		USER = "SPRINGUSER";
		PASSWORD = "12345";
	}

	@Test
	void cargarArchivoBaseDatosTest() throws SQLException {
		
		//Arrange
		File archivo = new File ("C:\\Users\\AndresCamilo\\STS-workspace\\CargarDatosTxt\\UtilesArchivosTests\\ArchivoValidotest.csv");
		
		//Act
		CargadorBaseDatos cargador = new CargadorBaseDatos ();
		cargador.cargarArchivoPersonasBaseDatos(archivo);
		//Assert
		String query = "SELECT * FROM PERSONACARGADATOS WHERE NOMBRE LIKE '%Juan Alberto Rincon Bolivar%'";
		ResultSet result = getFromOracle(query);
		assertTrue(result.next());
	}
	
	private ResultSet getFromOracle (String query) {
		Queryator queryator = new OracleQueryator (CONNECTIONSTRING, USER, PASSWORD);
		ResultSet result = queryator.executeQuery(query);
		return result;
	}

}
