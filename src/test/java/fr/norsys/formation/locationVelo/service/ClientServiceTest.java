/**
 * 
 */
package fr.norsys.formation.locationVelo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import fr.norsys.formation.Location_velo.dao.ClientDAO;
import fr.norsys.formation.locationVelo.vo.Client;

/**
 * @author technomaker04
 * 
 */
public class ClientServiceTest {

	private ClientDAO clientDAOMock;
	private ClientService clientService;

	@Before
	public void setUp() throws SQLException {
		clientService = new ClientServiceImpl();

		clientDAOMock = mock(ClientDAO.class, "clientDAO");

		clientService.setClientDAO(clientDAOMock);

	}

	/**
	 * etant donné un client dont l'id est 12 quand je cherche dans la BD ce
	 * client alors je dois recuperer le client dont l'id est 12
	 * 
	 * @throws Exception
	 */
	@Test
	public void rechercherClientAvecId12() throws Exception {

		Client client = new Client();
		client.setIdClient(12);
		client.setNom("toto");
		client.setTelephone("0655444");

		when(clientDAOMock.findById(12)).thenReturn(client);

		Client clientTrouve = clientService.findByIdClient(12);
		assertNotNull("client trouvé ", clientTrouve);
		assertEquals(12, clientTrouve.getIdClient());

	}

	/**
	 * -etant donné qu'on veux supprimer le client dont l'id =12 et qui n'existe
	 * pas dans la BD -quand on cherche ce client apres la supression -alors une
	 * exception de type sqlException doit etre declenchée
	 * 
	 * @throws SQLException
	 */
	@Test
	public void deleteClient12declencheExceptionSql() throws SQLException {

		doThrow(new SQLException()).when(clientDAOMock).delete(12);

		try {
			clientService.deleteClient(12);
			fail();
		} catch (SQLException e) {
			assertTrue("levee exception", true);
		}
	}

	/**
	 * -etant donné un client dont l'id est 14 à ajouter dans la BD -quand je
	 * l'ajoute - alors je veux que ce clien(id=14) ne peut pas etre a jouter a
	 * nouveau (la methode create(client14))est executé et une et une seule fois
	 */
	@Test
	public void uniciteAjoutClient14() throws Exception {

		Client client14 = new Client();
		client14.setIdClient(14);
		client14.setNom("titi");

		// simuler l'existence du client14 dans la BD
		when(clientDAOMock.findById(14)).thenReturn(client14);
		clientService.createClient(client14);

		assertEquals(14, clientDAOMock.findById(14).getIdClient());
		// s'assurer que la methode create appelée avec le parametre client14
		// s'execute une fois et une seule
		verify(clientDAOMock, times(1)).create(client14);

	}

	/**
	 * Etant donné un objet client espionné Quand j'accede à son Id (avec le
	 * getIdClient) Alors l'id par defaut est 101
	 */

	@Test
	public void clientSpyIddefault101() throws Exception {
		Client client = new Client();
		Client clientSpy = spy(client);
		when(clientSpy.getIdClient()).thenReturn(101);
		assertEquals(101, clientSpy.getIdClient());
	}

	/**
	 * Etant donné des objets client13 et client14 quand je veux ajouter les
	 * deux objets Alors il faut que l'abjet client13 soit ajouté avant l'objet
	 * client14
	 */
	@Test
	public void verifyOrderCreationClient() throws Exception {

		Client client14 = new Client();
		client14.setIdClient(14);
		client14.setNom("titi");

		Client client13 = new Client();
		client13.setIdClient(13);
		client13.setNom("tyou");
		client13.setTelephone("0655444");

		InOrder ordre = inOrder(clientDAOMock);

		clientService.createClient(client13);
		clientService.createClient(client14);

		ordre.verify(clientDAOMock).create(client13);
		ordre.verify(clientDAOMock).create(client14);

	}

	/**
	 * Etant donné un objet client Quand je fait appel a ce client et que je
	 * retourne son id Alors je veux que l'id s'incremente a chaque appel
	 * jusqu'au 3eme appel
	 */

	@Test
	public void testSuccessionDAppels() throws Exception {
		Client client = new Client();
		client.setIdClient(1);
		assertNotNull(client);
		assertEquals(1, client.getIdClient());

		Client clientMock = mock(Client.class);
		when(clientMock.getIdClient()).thenReturn(1, 2, 3);
		assertEquals(1, clientMock.getIdClient());
		assertEquals(2, clientMock.getIdClient());
		assertEquals(3, clientMock.getIdClient());
	}

}
