package com.csc440.cli.patient.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.csc440.cli.Main;

public class ViewObservationAction extends PatientAction implements
		IPatientAction {

	@Override
	public void execute() {
		while (shouldRun) {
			printOptions();
		}
	}

	@Override
	public void exit() {
		super.exit();

	}

	@Override
	public void printOptions() {
		System.out.println("[0] Back");
		System.out.println("[1] View Observations");
	}

	public int executeOption(int actionID) {
		switch (actionID) {
		case 0:
			exit();
			break;
		case 1:
			try {
				System.out.println("Enter start date [mm/dd/yyyy]");
				Date startDate = getDate();
				System.out.println("Enter end date [mm/dd/yyyy]");
				Date endDate = getDate();
				
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		return -1;
	}

	public Date getDate() throws ParseException {
		String cmDate = Main.getScanner().nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		return dateFormat.parse(cmDate);
	}
}
