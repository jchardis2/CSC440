package com.csc440.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.csc440.beans.HealthProfessionalBean;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.DBUtil;
import com.csc440.exceptions.DBException;
import com.csc440.loaders.HealthProfessionalLoader;

public class HealthCareProfessionalDAO {
	private DAOFactory factory;
	private HealthProfessionalLoader healthProfessionalLoader;

	public HealthCareProfessionalDAO(DAOFactory factory) {
		this.factory = factory;
		this.healthProfessionalLoader = new HealthProfessionalLoader();
	}

	/**
	 * Returns the user's information for a given ID
	 * 
	 * @param id
	 *            The ID of the user to retrieve.
	 * @return A UserBean representing the user.
	 * @throws DBException
	 */
	public HealthProfessionalBean getPatientByID(long id) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn
					.prepareStatement("SELECT * FROM healthprofessional WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				HealthProfessionalBean hcfb = healthProfessionalLoader
						.loadSingle(rs);
				rs.close();
				ps.close();
				return hcfb;
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
	public HealthProfessionalBean getPatientByCredentials(String username,
			String password) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn
					.prepareStatement("SELECT * FROM  healthprofessional WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				HealthProfessionalBean hcpb = healthProfessionalLoader
						.loadSingle(rs);
				rs.close();
				ps.close();
				return hcpb;
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
}
