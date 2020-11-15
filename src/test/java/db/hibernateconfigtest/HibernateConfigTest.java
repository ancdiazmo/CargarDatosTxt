package db.hibernateconfigtest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import com.db.hibernateconfig.HibernateConfig;

class HibernateConfigTest {
	
	@Test
	void getSessionTest () {
		
		//Arrange
		Session session = HibernateConfig.getSession(); 
		//Act
		//Assert
		assertNotNull(session);
		
	}

}
