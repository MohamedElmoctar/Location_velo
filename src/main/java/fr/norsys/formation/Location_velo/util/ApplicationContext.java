package fr.norsys.formation.Location_velo.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDataSource;

public class ApplicationContext {

	private static JDBCDataSource DATASOURCE;

	private static DataSource getApplicationDataSource() {
		if (DATASOURCE == null) {
			DATASOURCE = new JDBCDataSource();
			DATASOURCE.setUrl("jdbc:hsqldb:file:D:/technoMaker/WorkSpace/TpJunit/DB/LocationVelo");
		}
		return DATASOURCE;
	}

	public static Connection getConnexion() throws SQLException {
		DataSource ds = getApplicationDataSource();
		return ds.getConnection();
	}

}
