package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.ObservationInfoBean;

public class ObservationIntInfoLoader implements BeanLoader<ObservationInfoBean<Integer>> {

	public List<ObservationInfoBean<Integer>> loadList(ResultSet rs) throws SQLException {
		List<ObservationInfoBean<Integer>> list = new ArrayList<ObservationInfoBean<Integer>>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public void loadCommon(ResultSet rs, ObservationInfoBean<Integer> oib) throws SQLException {
		oib.setId(rs.getInt("obinfoid"));
		oib.setObid(rs.getInt("obid"));
		oib.setName(rs.getString("name"));
		oib.setInfo(rs.getInt("info"));
	}

	public ObservationInfoBean<Integer> loadSingle(ResultSet rs) throws SQLException {
		ObservationInfoBean<Integer> ub = new ObservationInfoBean<Integer>();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps, ObservationInfoBean<Integer> pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setInt(i++, pb.getObid());
		ps.setString(i++, pb.getName());
		ps.setInt(i++, pb.getInfo());
		return ps;
	}

	@Override
	public ObservationInfoBean<Integer> loadSingle(ResultSet rs, ObservationInfoBean<Integer> pb) throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
