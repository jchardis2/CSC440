package com.csc440.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.csc440.beans.ObservationInfoBean;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.DBUtil;
import com.csc440.exceptions.DBException;
import com.csc440.loaders.ObservationDoubleInfoLoader;
import com.csc440.loaders.ObservationIntInfoLoader;
import com.csc440.loaders.ObservationStringInfoLoader;

public class ObservationInfoDAO {
	private DAOFactory factory;
	private ObservationIntInfoLoader observationIntInfoLoader = new ObservationIntInfoLoader();
	private ObservationStringInfoLoader observationStringInfoLoader = new ObservationStringInfoLoader();
	private ObservationDoubleInfoLoader observationDoubleInfoLoader = new ObservationDoubleInfoLoader();

	public ObservationInfoDAO(DAOFactory factory) {
		this.factory = factory;
	}

	public List<ObservationInfoBean<Integer>> getObservationIntInfo(int observationid) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "Select * from observationintinfo where obid = ?";
			ps = conn.prepareStatement(selectSQL);
			ps.setInt(1, observationid);
			ResultSet rs = ps.executeQuery();
			List<ObservationInfoBean<Integer>> bean = observationIntInfoLoader.loadList(rs);
			rs.close();
			ps.close();
			return bean;
		} catch (SQLException | NamingException e) {
			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	public List<ObservationInfoBean<String>> getObservationStringInfo(int observationid) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "Select * from observationstringinfo where obid = ?";
			ps = conn.prepareStatement(selectSQL);
			ps.setInt(1, observationid);
			ResultSet rs = ps.executeQuery();
			List<ObservationInfoBean<String>> bean = observationStringInfoLoader.loadList(rs);
			rs.close();
			ps.close();
			return bean;
		} catch (SQLException | NamingException e) {
			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	public List<ObservationInfoBean<Double>> getObservationDoubleInfo(int observationid) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "Select * from observationdoubleinfo where obid = ?";
			ps = conn.prepareStatement(selectSQL);
			ps.setInt(1, observationid);
			ResultSet rs = ps.executeQuery();
			List<ObservationInfoBean<Double>> bean = observationDoubleInfoLoader.loadList(rs);
			rs.close();
			ps.close();
			return bean;
		} catch (SQLException | NamingException e) {
			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	public void insertObservationInfoBean(ObservationInfoBean<?> observationBean) throws DBException {
		System.out.println(observationBean.getInfo().getClass());
	}

	public void insertObservationIntInfoBean(ObservationInfoBean<Integer> observationInfoBean) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "INSERT INTO OBSERVATIONINTINFO (OBINFOID, OBID, NAME, INFO) VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(selectSQL);
			ps = observationIntInfoLoader.loadParameters(ps, observationInfoBean);
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
		} catch (SQLException | NamingException e) {

			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}
	}

	public void insertObservationStringInfoBean(ObservationInfoBean<String> observationInfoBean) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "INSERT INTO OBSERVATIONSTRINGINFO (OBINFOID, OBID, NAME, INFO) VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(selectSQL);
			ps = observationStringInfoLoader.loadParameters(ps, observationInfoBean);
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
		} catch (SQLException | NamingException e) {
			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}

	}

	public void insertObservationDoubleInfoBean(ObservationInfoBean<Double> observationInfoBean) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			String selectSQL = "INSERT INTO OBSERVATIONDOUBLEINFO (OBINFOID, OBID, NAME, INFO) VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(selectSQL);
			ps = observationDoubleInfoLoader.loadParameters(ps, observationInfoBean);
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
		} catch (SQLException | NamingException e) {
			throw new DBException(e);
		} finally {
			DBUtil.closeConnection(conn, ps);
		}

	}

}