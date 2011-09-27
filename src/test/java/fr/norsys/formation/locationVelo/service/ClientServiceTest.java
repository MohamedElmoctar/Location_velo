/**
 * 
 */
package fr.norsys.formation.locationVelo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.Location_velo.dao.ClientDAO;
import fr.norsys.formation.locationVelo.vo.Client;

/**
 * @author technomaker04
 * 
 */
public class ClientServiceTest {

	private ClientDAO clientDAOMock;

	@Before
	public void setUp() throws SQLException {
		clientDAOMock = mock(ClientDAO.class, "clientDAO");
		Client client = new Client();
		client.setIdClient(12);
		client.setNom("toto");
		client.setTelephone("0655444");

		when(clientDAOMock.findById(12)).thenReturn(client);
	}

	/**
	 * etant donné un client dont l'id est 12 quand je cherche dans la BD ce
	 * cleint alors je dois recuperer le client dont l'id est 12
	 * 
	 * @throws Exception
	 */
	@Test
	public void rechercherClientAvecId12() throws Exception {
		ClientService clientService = new ClientServiceImpl();
		clientService.setClientDAO(clientDAOMock);
		Client client = clientService.findByIdClient(12);
		assertNotNull("client trouvé ", client);
		assertEquals(12,client.getIdClient());

	}

}
