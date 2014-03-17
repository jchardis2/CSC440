package com.csc440.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.csc440.beans.ObservationBean;
import com.csc440.beans.ObservationTypeBean;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.DBUtil;
import com.csc440.exceptions.DBException;
import com.csc440.loaders.ObservationTypeLoader;

public class ObservationTypeDAO {
	private DAOFactory factory;
	private ObservationTypeLoader observationTypeLoader;

	public ObservationTypeDAO(DAOFactory factory) {
		this.factory = factory;
		this.observationTypeLoader = new ObservationTypeLoader();
	}

	public ObservationTypeBean getPatientByID(long id) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn
					.prepareStatement("SELECT * FROM observationtype WHERE obypteid = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ObservationTypeBean bean = observationTypeLoader.loadSingle(rs);
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

	public List<ObservationTypeBean> getObservationsTypes() throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "Select * from observationtype";
			ps = conn.prepareStatement(selectSQL);
			ResultSet rs = ps.executeQuery();
			List<ObservationTypeBean> bean = observationTypeLoader.loadList(rs);
			rs.close();
			ps.close();
			return bean;
		} catch (SQLException | NamingException e) {
			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}
	
	public Integer insertObservationBean(ObservationTypeBean observationTypeBean) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "INSERT INTO OBSERVATIONTYPE (OBTYPEID, NAME, OBTYPE) " + "VALUES (?, ?, ?)";
			ps = conn.prepareStatement(selectSQL);

			ps = observationTypeLoader.loadParameters(ps, observationTypeBean);
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
		PreparedStatement ps = conn.prepareStatement("SELECT observationtype_seq.CURRVAL FROM dual");
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

}