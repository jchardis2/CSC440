package com.csc440.cli;

import java.util.Scanner;

import com.csc440.beans.HealthProfessionalBean;
import com.csc440.beans.PatientBean;
import com.csc440.beans.UserBean;

public class Main {
	public static Scanner scanner;
	public static UserBean userBean = null;
	public static boolean debug = false;

	public static void main(String args[]) {
		setSystemProperties();
		scanner = new Scanner(System.in);

		while (true) {
			userBean = login();
			if (userBean instanceof PatientBean) {
				PatientMain patientMain = new PatientMain(
						(PatientBean) userBean, scanner);
				patientMain.execute();
			} else if (userBean instanceof HealthProfessionalBean) {

			}
			logout();
		}

	}

	public static UserBean login() {
		LoginCLAction loginCLAction = new LoginCLAction();
		while (userBean == null) {
			try {
				return loginCLAction.login(scanner);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	public static void setSystemProperties() {
		debug = Boolean.parseBoolean(System.getProperty("Debug"));
	}

	public static void logout() {
		userBean = null;
	}

	public static Scanner getScanner() {
		return scanner;
	}

}
