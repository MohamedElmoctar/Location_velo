/**
 * 
 */
package fr.norsys.formation.Location_velo.util;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 * @author technomaker04
 *
 */
public class ApplicationContextTest {
	


	@Test
	public void testConnexion() throws SQLException {
		Connection conn=ApplicationContext.getConnexion();
		assertNotNull("la connexion est bien etabli", conn);
		
	
	}

}
