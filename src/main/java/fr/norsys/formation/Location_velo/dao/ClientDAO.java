package fr.norsys.formation.Location_velo.dao;

import java.sql.SQLException;

import fr.norsys.formation.locationVelo.vo.Client;

public interface ClientDAO {
/**
 * creer le client
 * @param client
 * @throws SQLException
 */
	public void create(Client client) throws SQLException;
/**
 * rechrecher le client dont l'id est idClient
 * @param idClient
 * @return
 * @throws SQLException
 */
	public Client findById(int idClient) throws SQLException;
	
	/**
	 * supprimer le client dont l'id est idClient
	 * @param idClient
	 * @throws SQLException
	 */

	public void delete(int idClient) throws SQLException;

}
