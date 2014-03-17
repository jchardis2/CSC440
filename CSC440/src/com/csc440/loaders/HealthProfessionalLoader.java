package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.HealthProfessionalBean;

public class HealthProfessionalLoader implements
		BeanLoader<HealthProfessionalBean> {

	public List<HealthProfessionalBean> loadList(ResultSet rs)
			throws SQLException {
		List<HealthProfessionalBean> list = new ArrayList<HealthProfessionalBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	public void loadCommon(ResultSet rs, HealthProfessionalBean pb)
			throws SQLException {
		pb.setId(rs.getInt("healthprofessionalid"));
		pb.setUsername(rs.getString("username"));
		pb.setPassword(rs.getString("password"));
		pb.setType(rs.getString("type"));
		pb.setName(rs.getString("name"));
		pb.setClinic(rs.getString("clinic"));
	}

	public HealthProfessionalBean loadSingle(ResultSet rs) throws SQLException {
		HealthProfessionalBean ub = new HealthProfessionalBean();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps,
			HealthProfessionalBean pb) throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getId());
		ps.setString(i++, pb.getUsername());
		ps.setString(i++, pb.getPassword());
		ps.setString(i++, pb.getType());
		ps.setString(i++, pb.getName());
		ps.setString(i++, pb.getClinic());
		return ps;
	}

	@Override
	public HealthProfessionalBean loadSingle(ResultSet rs,
			HealthProfessionalBean pb) throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
