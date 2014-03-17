package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.ObservationBean;
import com.csc440.beans.ObservationTypeBean;

public class ObservationLoader implements BeanLoader<ObservationBean> {

	public List<ObservationBean> loadList(ResultSet rs) throws SQLException {
		List<ObservationBean> list = new ArrayList<ObservationBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	public void loadCommon(ResultSet rs, ObservationBean pb) throws SQLException {
		pb.setId(rs.getInt("obid"));
		pb.setPatientID(rs.getInt("patientid"));
		pb.setObservationtypeid(rs.getInt("observationtypeid"));
		pb.setObdate(rs.getDate("obdate"));
		pb.setObtime(rs.getTimestamp("obtime"));
		pb.setRecordtime(rs.getTimestamp("recoredtime"));
		ObservationTypeBean observationTypeBean = new ObservationTypeBean();
		observationTypeBean.setId(rs.getInt("obtypeid"));
		observationTypeBean.setName(rs.getString("name"));
		observationTypeBean.setObtype(rs.getString("obtype"));
		pb.setObservationTypeBean(observationTypeBean);
	}

	public ObservationBean loadSingle(ResultSet rs) throws SQLException {
		ObservationBean ub = new ObservationBean();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps, ObservationBean pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setInt(i++, pb.getPatientID());
		ps.setInt(i++, pb.getObservationtypeid());
		ps.setDate(i++, pb.getObdate());
		ps.setTimestamp(i++, pb.getObtime());
		ps.setTimestamp(i++, pb.getRecordtime());
		return ps;
	}

	@Override
	public ObservationBean loadSingle(ResultSet rs, ObservationBean pb) throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
