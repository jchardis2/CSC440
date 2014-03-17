package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.ObservationFactorBean;

public class ObservationFactorLoader implements
		BeanLoader<ObservationFactorBean> {

	public List<ObservationFactorBean> loadList(ResultSet rs)
			throws SQLException {
		List<ObservationFactorBean> list = new ArrayList<ObservationFactorBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	public void loadCommon(ResultSet rs, ObservationFactorBean ofb)
			throws SQLException {
		ofb.setId(rs.getInt("obfactorid"));
		ofb.setObservationtypeid(rs.getInt("observationtypeid"));
		ofb.setName(rs.getString("name"));
		ofb.setFactorType(rs.getString("factortype"));
	}

	public ObservationFactorBean loadSingle(ResultSet rs) throws SQLException {
		ObservationFactorBean ub = new ObservationFactorBean();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps,
			ObservationFactorBean pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setInt(i++, pb.getObservationtypeid());
		ps.setString(i++, pb.getName());
		ps.setString(i++, pb.getFactorType());
		return ps;
	}

	@Override
	public ObservationFactorBean loadSingle(ResultSet rs,
			ObservationFactorBean pb) throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
