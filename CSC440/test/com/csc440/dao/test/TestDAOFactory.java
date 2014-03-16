package com.csc440.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.csc440.dao.DAOFactory;
import com.csc440.dao.IConnectionDriver;

public class TestDAOFactory extends DAOFactory implements IConnectionDriver {
	private static final String JDBC_URL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl";
	private String username = "jchardis";
	private String password = "000990968";

	private static DAOFactory testInstance;

	public static DAOFactory getTestInstance() {
		if (testInstance == null)
			testInstance = new TestDAOFactory();
		return testInstance;
	}

	private TestDAOFactory() {

	}

	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, username, password);
	}
}
