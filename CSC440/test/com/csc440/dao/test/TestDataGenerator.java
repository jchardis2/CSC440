package com.csc440.dao.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.csc440.dao.DAOFactory;

public class TestDataGenerator {
	public static void main(String[] args) throws IOException, SQLException,
			NamingException {
		TestDataGenerator gen = new TestDataGenerator();
		gen.clearAllTables();
		gen.standardData();

	}

	private String DIR = "sql/data";

	private DAOFactory factory;

	public TestDataGenerator() {
		this.factory = TestDAOFactory.getTestInstance();
	}

	public TestDataGenerator(String projectHome, DAOFactory factory) {
		this.DIR = projectHome + "src/main/resources/sql/data";
		this.factory = factory;
	}

	public void clearAllTables() throws SQLException, FileNotFoundException,
			IOException, NamingException {
		new DBBuilder(factory).executeSQLFile(DIR + "/deleteFromAllTables.sql");
	}

	public void standardData() throws FileNotFoundException, IOException,
			SQLException, NamingException {
		standardPatients();
		standardTypes();
		standardPatientTypes();
		standardObservations();
		standardObservationTypes();
		standardObservationInfo();
		standardObservationFactors();
	}

	public void standardPatients() throws SQLException, FileNotFoundException,
			IOException, NamingException {
		new DBBuilder(factory).executeSQLFile(DIR + "/standardPatients.sql");
	}

	public void standardPatientTypes() throws SQLException,
			FileNotFoundException, IOException, NamingException {
		new DBBuilder(factory)
				.executeSQLFile(DIR + "/standardPatientTypes.sql");
	}

	public void standardTypes() throws SQLException, FileNotFoundException,
			IOException, NamingException {
		new DBBuilder(factory).executeSQLFile(DIR + "/standardTypes.sql");
	}

	public void standardObservations() throws SQLException,
			FileNotFoundException, IOException, NamingException {
		new DBBuilder(factory)
				.executeSQLFile(DIR + "/standardObservations.sql");
	}

	public void standardObservationTypes() throws SQLException,
			FileNotFoundException, IOException, NamingException {
		new DBBuilder(factory).executeSQLFile(DIR
				+ "/standardObservationTypes.sql");
	}

	public void standardObservationInfo() throws SQLException,
			FileNotFoundException, IOException, NamingException {
		new DBBuilder(factory).executeSQLFile(DIR
				+ "/standardObservationInfo.sql");
	}

	public void standardObservationFactors() throws SQLException,
			FileNotFoundException, IOException, NamingException {
		new DBBuilder(factory).executeSQLFile(DIR
				+ "/standardObservationFactors.sql");
	}

}