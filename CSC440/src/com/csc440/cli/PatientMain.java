package com.csc440.cli;

import java.util.Scanner;

import com.csc440.beans.PatientBean;
import com.csc440.cli.patient.actions.EnterDataAction;
import com.csc440.cli.patient.actions.IPatientAction;
import com.csc440.cli.patient.actions.PatientAction;
import com.csc440.cli.patient.actions.ViewDataAction;

public class PatientMain extends PatientAction implements IPatientAction {
	private Scanner scanner;
	private PatientBean patientBean;
	private static PatientMain patientMain;

	public static PatientMain getInstance() {
		if (patientMain == null) {
			patientMain = new PatientMain();
		}
		return patientMain;
	}

	public void init(PatientBean patientBean, Scanner scanner) {
		this.patientBean = patientBean;
		this.scanner = scanner;
	}

	private PatientMain() {
	}

	public void printOptions() {
		System.out.println("[0] Logout");
		System.out.println("[1] Enter Data");
		System.out.println("[2] View Data");
		System.out.println("[3] Clear Alerts");
	}

	@Override
	public void execute() {
		while (shouldRun) {
			printOptions();
			int command = scanner.nextInt();
			getAction(command).execute();
		}

	}

	public IPatientAction getAction(int actionID) {
		switch (actionID) {
		case 0:
			exit();
			break;
		case 1:
			return new EnterDataAction();
		case 2:
			return new ViewDataAction();
		}
		return null;
	}

	@Override
	public void exit() {
		shouldRun = false;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public PatientBean getPatientBean() {
		return patientBean;
	}

	public void setPatientBean(PatientBean patientBean) {
		this.patientBean = patientBean;
	}

}
