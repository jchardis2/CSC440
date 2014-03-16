package com.csc440.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * This bean provides the instance of the currently logged in user
 * 
 * @author Jimmy Hardison
 */
@SessionScoped
@ManagedBean(name = "loggedInPatientBean")
public class LoggedInPatientBean extends PatientBean {
	private static final long serialVersionUID = 67331987141558728L;

	/**
	 * This bean provides the instance of the currently logged in user
	 */
	public LoggedInPatientBean() {

	}
}
