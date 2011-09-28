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
	 * étant donné un nouveau client (toto avec id=18) -quand je le souvegarde
	 * dans le BD et que je demande de retourner ce client a partir de BD -alors
	 * je trouve le client (toto avec id=18)
	 * 
	 * @throws Exception
	 */
	@Test
	public void saveClient18DansDBetRetournerLeClient18() throws Exception {
		initClientDao();
		Client client = new Client();
		client.setIdClient(18);
		client.setNom("toto");
		client.setTelephone("0655444");
		clientDAO.create(client);
		Client clientTrouve = clientDAO.findById(18);
		assertNotNull(clientTrouve);
		assertEquals(18, clientTrouve.getIdClient());
		clientDAO.delete(18);

	}

	/**
	 * -etant donné un client dont l'id est 13 -quand je cherche dans la BD ce
	 * cleint - alors je dois recuperer le client dont l'id est 13
	 * 
	 * @throws Exception
	 */
	@Test
	public void rechercherClientAvecId13() throws Exception {

		Client clientTrouve = clientDAO.findById(13);
		assertEquals(13, clientTrouve.getIdClient());

	}

	/**
	 * -etant donné qu'on veux supprimer le client dont l'id =12 -quand on
	 * cherche ce client apres la supression -alors le client retourné doit etre
	 * null
	 * 
	 * @throws SQLException
	 */
	@Test
	public void deleteClient12VerifyQuIlEstNull() throws SQLException {

		clientDAO.delete(12);
		assertNull(clientDAO.findById(12));

	}
}
