package fr.norsys.formation.Location_velo.dao;

import java.sql.SQLException;

import fr.norsys.formation.locationVelo.vo.Client;

public interface ClientDAO {

	public void create(Client client) throws SQLException;

	public Client findById(int idClient) throws SQLException;

	public void delete(int idClient) throws SQLException;

}
