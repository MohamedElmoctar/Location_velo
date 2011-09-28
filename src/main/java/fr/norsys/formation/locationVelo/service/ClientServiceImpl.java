package fr.norsys.formation.locationVelo.service;

import java.sql.SQLException;

import fr.norsys.formation.Location_velo.dao.ClientDAO;
import fr.norsys.formation.locationVelo.vo.Client;

public class ClientServiceImpl implements ClientService {
	private ClientDAO clientDAO;
/*
 * (non-Javadoc)
 * @see fr.norsys.formation.locationVelo.service.ClientService#findByIdClient(int)
 */
	public Client findByIdClient(int idClient) throws SQLException {
	

		return clientDAO.findById(idClient);
	}

	/**
	 * @return the clientDAO
	 */
	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	/**
	 * @param clientDAO
	 *            the clientDAO to set
	 */
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
/*
 * (non-Javadoc)
 * @see fr.norsys.formation.locationVelo.service.ClientService#deleteClient(int)
 */
	public void deleteClient(int idClient) throws SQLException {
		
		clientDAO.delete(idClient);
		
	}
/*
 * (non-Javadoc)
 * @see fr.norsys.formation.locationVelo.service.ClientService#createClient(fr.norsys.formation.locationVelo.vo.Client)
 */
	public void createClient(Client client) throws SQLException {
		
		clientDAO.create(client);
	}

}
