package com.csc440.cli;

import java.util.Scanner;

import com.csc440.actions.LoginAction;
import com.csc440.beans.PatientBean;
import com.csc440.beans.UserBean;
import com.csc440.exceptions.DBException;

public class LoginCLAction {

	public UserBean login(Scanner scanner) throws Exception {
		System.out.print("Username: ");
		String username = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();

		LoginAction action = new LoginAction(username, password);
		UserBean userBean;
		userBean = action.login();
		if (userBean == null) {
			throw new Exception("Invalid credentials");
		} else {
			return userBean;
		}
	}
}
