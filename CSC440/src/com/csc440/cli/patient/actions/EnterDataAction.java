package com.csc440.cli.patient.actions;

import com.csc440.cli.Main;

public class EnterDataAction extends PatientAction implements IPatientAction {

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
		System.out.println("[1] Enter New Observation Data");
		System.out.println("[2] Add a New Observation Type");
	}

	public int executeOption(int actionID) {
		switch (actionID) {
		case 0:
			exit();
			break;
		case 1:
			
			break;
		}
		return -1;
	}
}
