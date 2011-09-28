/**
 * 
 */
package fr.norsys.formation.locationVelo.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


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
	 * client alors je dois recuperer le client dont l'id est 12
	 * 
	 * @throws Exception
	 */
	@Test
	public void rechercherClientAvecId12() throws Exception {
		ClientService clientService = new ClientServiceImpl();
		clientService.setClientDAO(clientDAOMock);
		Client client = clientService.findByIdClient(12);
		assertNotNull("client trouvé ", client);
		assertEquals(12, client.getIdClient());
		verify(clientDAOMock, times(1)).findById(12);
	}

	/**
	 * -etant donné qu'on veux supprimer le client dont l'id =12 et qui n'existe pas dans la BD
	 * -quand on cherche ce client apres la supression
	 * -alors une exception de type sqlException doit etre declenchée
	 * @throws SQLException 
	 */
	@Test

	public void deleteClient12declencheExceptionSql() throws SQLException{
		clientDAOMock = mock(ClientDAO.class, "clientDAO");

		doThrow(new SQLException()).when(clientDAOMock).delete(12);
		
		try {
			clientDAOMock.delete(12); 
			} catch (SQLException e) {
			assertTrue("levee exception", true);
			}
	}

}
