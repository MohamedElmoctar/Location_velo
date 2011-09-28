/**
 * 
 */
package fr.norsys.formation.locationVelo.service;

import java.sql.SQLException;

import fr.norsys.formation.Location_velo.dao.ClientDAO;
import fr.norsys.formation.locationVelo.vo.Client;

/**
 * @author technomaker04
 *
 */
public interface ClientService {
/**
 * rechercher un client par son Id
 * @param idClient
 * @return
 * @throws SQLException
 */
	public Client findByIdClient(int idClient) throws SQLException;
	public ClientDAO getClientDAO();
	public void setClientDAO(ClientDAO clientDAO);
	
	/**
	 * supprimer le client dont l'id est idClient
	 * @param idClient
	 * @throws SQLException
	 */
	public void deleteClient(int idClient) throws SQLException;
	/**
	 * creer le client "client"
	 * @param client
	 * @throws SQLException
	 */
	public void createClient(Client client) throws SQLException;

}
