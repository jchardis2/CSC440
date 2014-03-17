package com.csc440.cli.patient.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csc440.beans.ObservationBean;
import com.csc440.beans.ObservationInfoBean;
import com.csc440.cli.Main;
import com.csc440.cli.PatientMain;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.oracle.ObservationDAO;
import com.csc440.dao.oracle.ObservationInfoDAO;
import com.csc440.exceptions.DBException;

public class ViewDataAction extends PatientAction implements IPatientAction {

	@Override
	public void execute() {
		while (shouldRun) {
			printOptions();
			int command = Main.getScanner().nextInt();
			executeOption(command);
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

			try {

				System.out.println("Enter start date [mm/dd/yyyy]: ");
				Main.getScanner().nextLine();
				Date startDate = getDate();
				System.out.println("Enter end date [mm/dd/yyyy]: ");
				Date endDate = getDate();

				ObservationDAO observationDAO = new ObservationDAO(DAOFactory.getProductionInstance());
				List<ObservationBean> observationBeans = observationDAO.getObservationsByPatientID(PatientMain.getInstance().getPatientBean().getID());
				int count = 1;
				for (ObservationBean observationBean : observationBeans) {
					ObservationInfoDAO infoDAO = new ObservationInfoDAO(DAOFactory.getProductionInstance());
					System.out.print("Observation " + count + ":");
					System.out.println("\tObservation Type: " + observationBean.getObservationTypeBean().getName());
					List<ObservationInfoBean<String>> infoBeansString = infoDAO.getObservationStringInfo(observationBean.getId());
					for (ObservationInfoBean<String> observationInfoBean : infoBeansString) {
						System.out.println("\t\t" + observationInfoBean.getName() + ": " + observationInfoBean.getInfo());
					}
					List<ObservationInfoBean<Double>> infoBeansDouble = infoDAO.getObservationDoubleInfo(observationBean.getId());
					for (ObservationInfoBean<Double> observationInfoBean : infoBeansDouble) {
						System.out.println("\t\t" + observationInfoBean.getName() + ": " + observationInfoBean.getInfo());
					}
					List<ObservationInfoBean<Integer>> infoBeansInt = infoDAO.getObservationIntInfo(observationBean.getId());
					for (ObservationInfoBean<Integer> observationInfoBean : infoBeansInt) {
						System.out.println("\t\t" + observationInfoBean.getName() + ": " + observationInfoBean.getInfo());
					}
					count++;
				}

			} catch (ParseException e) {
				System.out.println("Improper dates!");
			} catch (DBException e) {
				System.out.println(e.getMessage());
			}
			;

			break;
		}
		return -1;
	}

	public Date getDate() throws ParseException {
		String cmDate = Main.getScanner().nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.parse(cmDate);
	}
}
