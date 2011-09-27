package fr.norsys.formation.Location_velo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import fr.norsys.formation.Location_velo.util.ApplicationContext;
import fr.norsys.formation.locationVelo.vo.Client;

/**
 * @author technomaker04
 * 
 */
public class IClientDAOTest {
	
	private ClientDAO clientDAO;
	
	@Before
	public void initClientDao() throws SQLException {
		Connection connexion = ApplicationContext.getConnexion();
	 clientDAO = new ClientDAOImpl(connexion);
	
	}

	/**
	 * étant donné la classe ClientDAO -quand je l'initialise -elle doit etre
	 * differente de null
	 */
	@Test
	public void initClientDaoEtVerifieQuelleNePasNull() throws Exception {

		assertNotNull(clientDAO);

	}

	/**
	 * étant donné un nouveau client (toto avec id=13) -quand je le souvegarde
	 * dans le BD -et que je demande de retourner ce client a partir de BD
	 * -alors je trouve le client (toto avec id=13)
	 * 
	 * @throws Exception
	 */
	@Test
	public void saveClient13DansDBetRetournerLeClient13() throws Exception {
		initClientDao();
		Client client = new Client();
		client.setIdClient(13);
		client.setNom("toto");
		client.setTelephone("0655444");
		clientDAO.create(client);
		Client clientTrouve = clientDAO.findById(13);
		assertNotNull(clientTrouve);
		assertEquals(13, clientTrouve.getIdClient());
		clientDAO.delete(13);

	}

	/**
	 * etant donné un client dont l'id est 12 quand je cherche dans la BD ce
	 * cleint alors je dois recuperer le client dont l'id est 12
	 * 
	 * @throws Exception
	 */
	@Test
	public void rechercherClientAvecId12() throws Exception {

	
		Client clientTrouve = clientDAO.findById(12);
		assertEquals(12, clientTrouve.getIdClient());

	}


	/**
	 * etant donné qu'in veux supprimer le client dont l'id =12 quand on cherche
	 * ce client apres la supression alors le client retourné doit etre null
	 */

	public void deleteClient12VerifyQuIlEstNull() throws SQLException {

	
		clientDAO.delete(12);
		assertNull(clientDAO.findById(12));

	}
}
