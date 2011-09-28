package fr.norsys.formation.Location_velo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.norsys.formation.locationVelo.vo.Client;

public class ClientDAOImpl implements ClientDAO {

	Connection connexion;

	private String createQuery = "INSERT INTO CLIENT( ID_CLIENT, NOM, TELEPHONE ) VALUES (?, ?, ?)";
	private String findById = "SELECT ID_CLIENT, NOM, TELEPHONE FROM CLIENT WHERE ID_CLIENT=?";
	private String deleteQuery = "DELETE FROM CLIENT WHERE ID_CLIENT=?";

	/**
	 * @param connexion
	 */
	public ClientDAOImpl(Connection connexion) {
		this.connexion = connexion;
	}

	public void create(Client client) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = connexion.prepareStatement(createQuery);

		stmt.setInt(1, client.getIdClient());
		stmt.setString(2, client.getNom());
		stmt.setString(3, client.getTelephone());
		stmt.executeUpdate();
		stmt.close();

		// Client clientRes = mapResultSetToClient(res);
		// stmt.executeUpdate();

		// return clientRes;
	}

	public Client findById(int idClient) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement stmt = connexion.prepareStatement(findById);
		stmt.setInt(1, idClient);
		ResultSet rs = stmt.executeQuery();
		Client clientRes = mapResultSetToClient(rs);
		stmt.close();
		return clientRes;
	}

	private Client mapResultSetToClient(ResultSet rs) throws SQLException {
		List<Client> clientList = new ArrayList<Client>();
		Client client = new Client();
		while (rs.next()) {
			client.setIdClient(rs.getInt("ID_CLIENT"));
			client.setNom(rs.getString("NOM"));
			client.setTelephone(rs.getString("TELEPHONE"));
			clientList.add(client);

		}
		if (!clientList.isEmpty()) {
			return clientList.get(0);
		} else {
			return null;
		}
	}

	public void delete(int idClient) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement stmt = connexion.prepareStatement(deleteQuery);
		stmt.setInt(1, idClient);
		stmt.executeUpdate();
		stmt.close();

	}
}
