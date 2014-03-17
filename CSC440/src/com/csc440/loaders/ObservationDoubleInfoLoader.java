package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.ObservationInfoBean;

public class ObservationDoubleInfoLoader implements BeanLoader<ObservationInfoBean<Double>> {

	public List<ObservationInfoBean<Double>> loadList(ResultSet rs) throws SQLException {
		List<ObservationInfoBean<Double>> list = new ArrayList<ObservationInfoBean<Double>>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public void loadCommon(ResultSet rs, ObservationInfoBean<Double> oib) throws SQLException {
		oib.setId(rs.getInt("obinfoid"));
		oib.setObid(rs.getInt("obid"));
		oib.setName(rs.getString("name"));
		oib.setInfo(rs.getDouble("info"));
	}

	public ObservationInfoBean<Double> loadSingle(ResultSet rs) throws SQLException {
		ObservationInfoBean<Double> ub = new ObservationInfoBean<Double>();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps, ObservationInfoBean<Double> pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setInt(i++, pb.getObid());
		ps.setString(i++, pb.getName());
		ps.setDouble(i++, pb.getInfo());
		return ps;
	}

	@Override
	public ObservationInfoBean<Double> loadSingle(ResultSet rs, ObservationInfoBean<Double> pb) throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
