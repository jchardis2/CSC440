package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.ObservationInfoBean;

public class ObservationInfoLoader<T> implements BeanLoader<ObservationInfoBean<T>> {

	public List<ObservationInfoBean<T>> loadList(ResultSet rs) throws SQLException {
		List<ObservationInfoBean<T>> list = new ArrayList<ObservationInfoBean<T>>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public void loadCommon(ResultSet rs, ObservationInfoBean<T> oib) throws SQLException {
		oib.setId(rs.getInt("obinfoid"));
		oib.setObid(rs.getInt("obid"));
		oib.setName(rs.getString("name"));
		Object info = rs.getObject("info");
		oib.setInfo((T) info);
	}

	public ObservationInfoBean<T> loadSingle(ResultSet rs) throws SQLException {
		ObservationInfoBean<T> ub = new ObservationInfoBean<T>();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps, ObservationInfoBean<T> pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setInt(i++, pb.getObid());
		ps.setString(i++, pb.getName());
		ps.setObject(i++, pb.getInfo());
		return ps;
	}

	@Override
	public ObservationInfoBean<T> loadSingle(ResultSet rs, ObservationInfoBean<T> pb) throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
