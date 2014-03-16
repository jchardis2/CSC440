package com.csc440.cli.patient.actions;

public abstract class PatientAction implements IPatientAction {
	protected boolean shouldRun = true;

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		shouldRun = false;
	}

	@Override
	public void printOptions() {
		// TODO Auto-generated method stub

	}
}
