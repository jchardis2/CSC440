package com.csc440.dao.oracle;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.csc440.beans.PatientBean;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.DBUtil;
import com.csc440.exceptions.DBException;
import com.csc440.loaders.PatientLoader;

public class PatientDAO {
	private DAOFactory factory;
	private PatientLoader patientLoader;

	public PatientDAO(DAOFactory factory) {
		this.factory = factory;
		this.patientLoader = new PatientLoader();
	}

	/**
	 * Returns the user's information for a given ID
	 * 
	 * @param id
	 *            The ID of the user to retrieve.
	 * @return A UserBean representing the user.
	 * @throws DBException
	 */
	public PatientBean getPatientByID(long id) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM patients WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PatientBean pat = patientLoader.loadSingle(rs);
				rs.close();
				ps.close();
				return pat;
			} else {
				rs.close();
				ps.close();
				return null;
			}
		} catch (SQLException | NamingException e) {

			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	/**
	 * Returns the user's information for given credentials
	 * 
	 * @param id
	 *            The ID of the user to retrieve.
	 * @return A UserBean representing the user.
	 * @throws DBException
	 */
	public PatientBean getPatientByCredentials(String username, String password)
			throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "Select * from patients where username = ? AND password = ?";
			ps = conn.prepareStatement(selectSQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ParameterMetaData pm = ps.getParameterMetaData();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PatientBean pat = patientLoader.loadSingle(rs);
				rs.close();
				ps.close();
				return pat;
			} else {
				rs.close();
				ps.close();
				return null;
			}
		} catch (SQLException | NamingException e) {

			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	public String getPreparedStatement(PreparedStatement ps) {
		Class stmt1 = ps.getClass();
		java.lang.reflect.Field mem;
		try {
			mem = stmt1.getField("sql");
			return (String) mem.get(ps);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
