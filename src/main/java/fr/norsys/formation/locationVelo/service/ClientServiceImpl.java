package fr.norsys.formation.locationVelo.service;

import java.sql.SQLException;

import fr.norsys.formation.Location_velo.dao.ClientDAO;
import fr.norsys.formation.locationVelo.vo.Client;

public class ClientServiceImpl implements ClientService {
	private ClientDAO clientDAO;

	public Client findByIdClient(int idClient) throws SQLException {
		// TODO Auto-generated method stub

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

}
