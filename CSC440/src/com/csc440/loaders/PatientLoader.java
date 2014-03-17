package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.PatientBean;

public class PatientLoader implements BeanLoader<PatientBean> {

	public List<PatientBean> loadList(ResultSet rs) throws SQLException {
		List<PatientBean> list = new ArrayList<PatientBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	public void loadCommon(ResultSet rs, PatientBean pb) throws SQLException {
		pb.setID(rs.getInt("patientid"));
		pb.setUsername(rs.getString("username"));
		pb.setPassword(rs.getString("password"));
		pb.setName(rs.getString("name"));
		pb.setDOB(rs.getDate("dob"));
		pb.setAddress(rs.getString("address"));
		pb.setSex(rs.getBoolean("sex"));
		pb.setHealthfriend(rs.getBoolean("healthfriend"));
	}

	public PatientBean loadSingle(ResultSet rs) throws SQLException {
		PatientBean ub = new PatientBean();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps, PatientBean pb)
			throws SQLException {
		int i = 1;
		ps.setLong(i++, pb.getID());
		ps.setString(i++, pb.getUsername());
		ps.setString(i++, pb.getPassword());
		ps.setDate(i++, pb.getDOB());
		ps.setString(i++, pb.getName());
		ps.setString(i++, pb.getAddress());
		ps.setBoolean(i++, pb.getSex());
		ps.setBoolean(i++, pb.getHealthfriend());
		return ps;
	}

	@Override
	public PatientBean loadSingle(ResultSet rs, PatientBean pb)
			throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
