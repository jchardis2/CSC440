package com.csc440.cli.patient.actions;

import com.csc440.cli.Main;

public class ViewDataAction extends PatientAction implements IPatientAction {

	@Override
	public void execute() {
		while (shouldRun) {
			printOptions();
			int command = Main.getScanner().nextInt();
		}
	}

	@Override
	public void exit() {
		super.exit();

	}

	@Override
	public void printOptions() {
		System.out.println("[0] Back");
		System.out.println("[1] View My Alerts");
		System.out.println("[2] View Observations");
	}

	public int executeOption(int actionID) {
		switch (actionID) {
		case 0:
			exit();
			break;
		case 1:
			
			break;
			
		case 2:
			
			break;
		}
		return -1;
	}
}
