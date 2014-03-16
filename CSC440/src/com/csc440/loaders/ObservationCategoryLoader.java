package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.ObservationBean;

public class ObservationCategoryLoader implements BeanLoader<ObservationBean> {

	public List<ObservationBean> loadList(ResultSet rs) throws SQLException {
		List<ObservationBean> list = new ArrayList<ObservationBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	public void loadCommon(ResultSet rs, ObservationBean pb)
			throws SQLException {
		pb.setId(rs.getInt("id"));
		pb.setPatientID(rs.getInt("patientid"));
		pb.setType(rs.getInt("type"));
		pb.setObdate(rs.getDate("obdate"));
		pb.setTimestamp(rs.getTimestamp("obtime"));
		pb.setRecordtime(rs.getTimestamp("recordtime"));
	}

	public ObservationBean loadSingle(ResultSet rs) throws SQLException {
		ObservationBean ub = new ObservationBean();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps,
			ObservationBean pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setInt(i++, pb.getPatientID());
		ps.setInt(i++, pb.getType());
		ps.setDate(i++, pb.getObdate());
		ps.setTimestamp(i++, pb.getTimestamp());
		ps.setTimestamp(i++, pb.getRecordtime());
		return ps;
	}

	@Override
	public ObservationBean loadSingle(ResultSet rs, ObservationBean pb)
			throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
