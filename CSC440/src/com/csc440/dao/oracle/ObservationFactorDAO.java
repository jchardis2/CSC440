package com.csc440.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.csc440.beans.ObservationFactorBean;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.DBUtil;
import com.csc440.exceptions.DBException;
import com.csc440.loaders.ObservationFactorLoader;

public class ObservationFactorDAO {
	private DAOFactory factory;
	private ObservationFactorLoader observationFactorLoader;

	public ObservationFactorDAO(DAOFactory factory) {
		this.factory = factory;
		this.observationFactorLoader = new ObservationFactorLoader();
	}

	public List<ObservationFactorBean> getObservationsTypes(int observationtypeid) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "Select * from observationfactors where observationtypeid = ?";
			ps = conn.prepareStatement(selectSQL);
			ps.setInt(1, observationtypeid);
			ResultSet rs = ps.executeQuery();
			List<ObservationFactorBean> bean = observationFactorLoader.loadList(rs);
			rs.close();
			ps.close();
			return bean;
		} catch (SQLException | NamingException e) {
			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	public Integer insertObservationFactorBean(ObservationFactorBean observationFactorBean) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "INSERT INTO OBSERVATIONFACTORS (OBFACTORID, OBSERVATIONTYPEID, NAME, FACTORTYPE) " + "VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(selectSQL);

			ps = observationFactorLoader.loadParameters(ps, observationFactorBean);
			ps.executeUpdate();
			Integer rs = getLastID(conn);
			ps.close();
			return rs;
		} catch (SQLException | NamingException e) {

			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	public int getLastID(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT observationfactors_seq.CURRVAL FROM dual");
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

}