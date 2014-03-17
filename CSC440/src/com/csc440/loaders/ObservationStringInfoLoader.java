package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.ObservationInfoBean;

public class ObservationStringInfoLoader implements BeanLoader<ObservationInfoBean<String>> {

	public List<ObservationInfoBean<String>> loadList(ResultSet rs) throws SQLException {
		List<ObservationInfoBean<String>> list = new ArrayList<ObservationInfoBean<String>>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public void loadCommon(ResultSet rs, ObservationInfoBean<String> oib) throws SQLException {
		oib.setId(rs.getInt("obinfoid"));
		oib.setObid(rs.getInt("obid"));
		oib.setName(rs.getString("name"));
		oib.setInfo(rs.getString("info"));
	}

	public ObservationInfoBean<String> loadSingle(ResultSet rs) throws SQLException {
		ObservationInfoBean<String> ub = new ObservationInfoBean<String>();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps, ObservationInfoBean<String> pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setInt(i++, pb.getObid());
		ps.setString(i++, pb.getName());
		ps.setString(i++, pb.getInfo());
		return ps;
	}

	@Override
	public ObservationInfoBean<String> loadSingle(ResultSet rs, ObservationInfoBean<String> pb) throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
