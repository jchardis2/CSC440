package com.csc440.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * Produces the JDBC connection from Tomcat's JDBC connection pool (defined in
 * context.xml). Produces and exception when running the unit tests because
 * they're not being run through Tomcat.
 * 
 * 
 * 
 */
public class ProductionConnectionDriver implements IConnectionDriver {
	// Specify JDBC URL
	private static final String JDBC_URL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl";
	private String username = "jchardis";
	private String password = "000990968";

	public ProductionConnectionDriver() {
	}

	public Connection getConnection() throws SQLException, NamingException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(JDBC_URL, username, password);
	}
}
