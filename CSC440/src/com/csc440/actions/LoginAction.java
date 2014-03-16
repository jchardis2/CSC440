package com.csc440.actions;

import com.csc440.beans.HealthProfessionalBean;
import com.csc440.beans.PatientBean;
import com.csc440.beans.UserBean;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.oracle.HealthCareProfessionalDAO;
import com.csc440.dao.oracle.PatientDAO;
import com.csc440.exceptions.DBException;
import com.csc440.loaders.HealthProfessionalLoader;

public class LoginAction {

	public UserBean userBean;
	public String username;
	public String password;

	public LoginAction(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginAction() {

	}

	public UserBean login() throws DBException {

		PatientDAO patientDAO = new PatientDAO(
				DAOFactory.getProductionInstance());
		PatientBean patientBean = patientDAO.getPatientByCredentials(username,
				password);
		if (patientBean != null) {
			return patientBean;
		} else { // check for HealthProfessional
			HealthCareProfessionalDAO careProfessionalDAO = new HealthCareProfessionalDAO(
					DAOFactory.getProductionInstance());
			HealthProfessionalBean healthProfessionalBean = careProfessionalDAO
					.getPatientByCredentials(username, password);
			if (healthProfessionalBean != null) {
				return healthProfessionalBean;
			}
		}
		return null;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
