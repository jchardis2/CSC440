package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.ObservationTypeBean;

public class ObservationTypeLoader implements BeanLoader<ObservationTypeBean> {

	public List<ObservationTypeBean> loadList(ResultSet rs) throws SQLException {
		List<ObservationTypeBean> list = new ArrayList<ObservationTypeBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	public void loadCommon(ResultSet rs, ObservationTypeBean observationTypeBean)
			throws SQLException {
		observationTypeBean.setId(rs.getInt("obtypeid"));
		observationTypeBean.setName(rs.getString("name"));
		observationTypeBean.setObtype(rs.getString("obtype"));
	}

	public ObservationTypeBean loadSingle(ResultSet rs) throws SQLException {
		ObservationTypeBean ub = new ObservationTypeBean();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps,
			ObservationTypeBean pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setString(i++, pb.getName());
		ps.setString(i++, pb.getObtype());
		return ps;
	}

	@Override
	public ObservationTypeBean loadSingle(ResultSet rs, ObservationTypeBean pb)
			throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
