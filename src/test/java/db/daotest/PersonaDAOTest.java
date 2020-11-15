package db.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.db.dao.PersonaDAO;
import com.db.domain.PersonaCargaDatos;

import queriatorstest.OracleQueryator;
import queriatorstest.Queryator;

class PersonaDAOTest {
	
	private static PersonaDAO personaDAO;
	private static String CONNECTIONSTRING;
	private static String USER;
	private static String PASSWORD;
	
	@BeforeAll
	public static void empezar () {
		personaDAO = new PersonaDAO ();
		personaDAO.deleteAll();
		CONNECTIONSTRING = "jdbc:oracle:thin:@//localhost:1521/xe";
		USER = "SPRINGUSER";
		PASSWORD = "12345";
	}
	
	@Test
	void saveTest () throws SQLException {
		//Arrange
		PersonaCargaDatos persona = new PersonaCargaDatos ("1026150", 26, "H", "El gordis");
		//Act
		personaDAO.save(persona);
		//Assert
		String query = "SELECT * FROM PERSONACARGADATOS WHERE CEDULA = 1026150";
		ResultSet result = getFromOracle(query);
		assertTrue(result.next());
	}
	
	@Test
	void updateTest () throws SQLException {
		//Arrange
		PersonaCargaDatos persona = new PersonaCargaDatos ("1026151", 26, "H", "El gordis");
		//Act
		personaDAO.save(persona);
		persona = new PersonaCargaDatos ("1026151", 26, "H", "El gordis actualizado");
		personaDAO.update(persona);
		//Assert
		String query = "SELECT * FROM PERSONACARGADATOS WHERE CEDULA = 1026151";
		ResultSet result = getFromOracle(query);
		result.next();
		assertEquals("El gordis actualizado", result.getString(4));
	}
	
	@Test 
	void deleteTest () throws SQLException {
		//Arrange
		PersonaCargaDatos persona = new PersonaCargaDatos ("1026152", 26, "H", "El gordis");
		//Act
		personaDAO.save(persona);
		persona = new PersonaCargaDatos ("1026152", 26, "H", "El gordis");
		personaDAO.delete(persona);
		//Assert
		String query = "SELECT * FROM PERSONACARGADATOS WHERE CEDULA = '1026152'";
		ResultSet result = getFromOracle(query);
		assertFalse(result.next());
	}
	
	@Test
	void selectPersonas () {
		//Arrange
		PersonaCargaDatos persona1 = new PersonaCargaDatos ("1026153SelectTest", 26, "H", "El gordis");
		PersonaCargaDatos persona2 = new PersonaCargaDatos ("1026154SelectTest", 26, "H", "El gordis");
		PersonaCargaDatos persona3 = new PersonaCargaDatos ("1026155SelectTest", 26, "H", "El gordis");
		PersonaCargaDatos persona4 = new PersonaCargaDatos ("1026156SelectTest", 26, "H", "El gordis");
		
		personaDAO.save(persona1);
		personaDAO.save(persona2);
		personaDAO.save(persona3);
		personaDAO.save(persona4);
		
		List<PersonaCargaDatos> personasEsperadas = new ArrayList<PersonaCargaDatos> ();
		personasEsperadas.add(persona1);
		personasEsperadas.add(persona2);
		personasEsperadas.add(persona3);
		personasEsperadas.add(persona4);
		
		//Act
		List<PersonaCargaDatos> personasObtenido = personaDAO.get("FROM PersonaCargaDatos WHERE cedula like '%SelectTest%'");
		//Assert
		assertEquals(true, personasEsperadas.equals(personasObtenido));
	}
	
//	@Test
//	public void deleteAllTest () {
//		personaDAO.deleteAll();
//	}
	
	private ResultSet getFromOracle (String query) {
		Queryator queryator = new OracleQueryator (CONNECTIONSTRING, USER, PASSWORD);
		ResultSet result = queryator.executeQuery(query);
		return result;
	}

}
