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

	public Client findByIdClient(int idClient) throws SQLException;
	public ClientDAO getClientDAO();
	public void setClientDAO(ClientDAO clientDAO);

}
