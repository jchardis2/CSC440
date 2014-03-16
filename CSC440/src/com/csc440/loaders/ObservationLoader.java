package com.csc440.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csc440.beans.OBCategoryBean;
import com.csc440.beans.OBCategoryBean;

public class ObservationLoader implements BeanLoader<OBCategoryBean> {

	public List<OBCategoryBean> loadList(ResultSet rs) throws SQLException {
		List<OBCategoryBean> list = new ArrayList<OBCategoryBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	public void loadCommon(ResultSet rs, OBCategoryBean pb) throws SQLException {
		pb.setId(rs.getInt("id"));
		pb.setPatientID(rs.getInt("patientid"));
		pb.setType(rs.getInt("type"));
		pb.setObdate(rs.getDate("obdate"));
		pb.setTimestamp(rs.getTimestamp("obtime"));
		pb.setRecordtime(rs.getTimestamp("recordtime"));
	}

	public OBCategoryBean loadSingle(ResultSet rs) throws SQLException {
		OBCategoryBean ub = new OBCategoryBean();
		loadCommon(rs, ub);
		return ub;
	}

	public PreparedStatement loadParameters(PreparedStatement ps,
			OBCategoryBean pb) throws SQLException {
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
	public OBCategoryBean loadSingle(ResultSet rs, OBCategoryBean pb)
			throws SQLException {
		loadCommon(rs, pb);
		return pb;
	}

}
