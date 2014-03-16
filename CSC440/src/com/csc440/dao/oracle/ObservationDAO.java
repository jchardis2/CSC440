package com.csc440.dao.oracle;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.csc440.beans.ObservationBean;
import com.csc440.beans.PatientBean;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.DBUtil;
import com.csc440.exceptions.DBException;
import com.csc440.loaders.ObservationLoader;
import com.csc440.loaders.PatientLoader;

public class ObservationDAO {
	private DAOFactory factory;
	private ObservationLoader observationLoader;

	public ObservationDAO(DAOFactory factory) {
		this.factory = factory;
		this.observationLoader = new ObservationLoader();
	}

	public ObservationBean getPatientByID(long id) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn
					.prepareStatement("SELECT * FROM observation WHERE id = ?");
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

	public List<ObservationBean> getObservationsByPatientID(int patientid)
			throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "Select * from observation where patientid = ?";
			ps = conn.prepareStatement(selectSQL);
			ps.setInt(1, patientid);
			ParameterMetaData pm = ps.getParameterMetaData();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				List<ObservationBean> bean = observationLoader.loadList(rs);
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

}