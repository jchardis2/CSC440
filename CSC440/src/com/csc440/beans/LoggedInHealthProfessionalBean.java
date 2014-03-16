package com.csc440.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * This bean provides the instance of the currently logged in user
 * 
 * @author Jimmy Hardison
 */
@SessionScoped
@ManagedBean(name = "loggedInHealthProfessionalBean")
public class LoggedInHealthProfessionalBean extends HealthProfessionalBean {
	
	public LoggedInHealthProfessionalBean(int id, String type, String name,
			String clinic) {
		super(id, type, name, clinic);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 67331987141558728L;

	/**
	 * This bean provides the instance of the currently logged in user
	 */
	public LoggedInHealthProfessionalBean() {

	}
}
