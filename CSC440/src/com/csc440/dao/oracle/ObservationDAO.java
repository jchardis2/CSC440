package com.csc440.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.csc440.beans.ObservationBean;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.DBUtil;
import com.csc440.exceptions.DBException;
import com.csc440.loaders.ObservationLoader;

public class ObservationDAO {
	private DAOFactory factory;
	private ObservationLoader observationLoader;

	public ObservationDAO(DAOFactory factory) {
		this.factory = factory;
		this.observationLoader = new ObservationLoader();
	}

	public ObservationBean getObservationByID(long id) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM observation, observationtype WHERE observation.obid = ? AND observation.observationtypeid = observationtype.obtypeid");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ObservationBean bean = observationLoader.loadSingle(rs);
				rs.close();
				ps.close();
				return bean;
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

	public List<ObservationBean> getObservationsByPatientID(int patientid) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "SELECT * FROM OBSERVATION, OBSERVATIONTYPE WHERE OBSERVATION.OBSERVATIONTYPEID = OBSERVATIONTYPE.OBTYPEID AND OBSERVATION.PATIENTID = ?";
			ps = conn.prepareStatement(selectSQL);
			ps.setInt(1, patientid);
			ResultSet rs = ps.executeQuery();
			List<ObservationBean> bean = observationLoader.loadList(rs);
			rs.close();
			ps.close();
			return bean;
		} catch (SQLException | NamingException e) {

			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	public Integer insertObservationBean(ObservationBean observationBean) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "INSERT INTO OBSERVATION (OBID, PATIENTID, OBSERVATIONTYPEID, OBDATE, OBTIME, RECOREDTIME) " + "VALUES (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(selectSQL);

			ps = observationLoader.loadParameters(ps, observationBean);
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
		PreparedStatement ps = conn.prepareStatement("SELECT observation_seq.CURRVAL FROM dual");
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
}