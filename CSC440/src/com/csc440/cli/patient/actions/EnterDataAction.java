package com.csc440.cli.patient.actions;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import com.csc440.beans.ObservationBean;
import com.csc440.beans.ObservationFactorBean;
import com.csc440.beans.ObservationInfoBean;
import com.csc440.beans.ObservationTypeBean;
import com.csc440.beans.factory.ObservationInfoBeanFactory;
import com.csc440.cli.Main;
import com.csc440.cli.PatientMain;
import com.csc440.dao.DAOFactory;
import com.csc440.dao.oracle.ObservationDAO;
import com.csc440.dao.oracle.ObservationFactorDAO;
import com.csc440.dao.oracle.ObservationInfoDAO;
import com.csc440.dao.oracle.ObservationTypeDAO;
import com.csc440.util.ObservationUtil;

public class EnterDataAction extends PatientAction implements IPatientAction {

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
		System.out.println("[1] Enter New Observation Data");
		System.out.println("[2] Add a New Observation Type");
	}

	public int executeOption(int actionID) {
		ObservationTypeDAO observationTypeDAO = new ObservationTypeDAO(DAOFactory.getProductionInstance());
		switch (actionID) {
		case 0:
			exit();
			break;
		case 1:

			try {
				List<ObservationTypeBean> observationTypeBeans = observationTypeDAO.getObservationsTypes();
				for (int i = 0; i < observationTypeBeans.size(); i++) {
					System.out.println("[" + i + "] " + observationTypeBeans.get(i).getName());
				}
				int obTypeSelected = Main.getScanner().nextInt();

				ObservationFactorDAO observationFactorDAO = new ObservationFactorDAO(DAOFactory.getProductionInstance());
				List<ObservationFactorBean> observationFactorBeans = observationFactorDAO.getObservationsTypes(observationTypeBeans.get(obTypeSelected).getId());
				System.out.println("Please enter the appropriate information: ");

				// Setup the observation bean
				ObservationBean ob = new ObservationBean();
				ob.setPatientID(PatientMain.getInstance().getPatientBean().getID());
				int obTypeID = ObservationUtil.observationTypes.getType(observationTypeBeans.get(obTypeSelected).getObtype());
				ob.setObservationtypeid(obTypeID);
				ob.setObdate(new Date(System.currentTimeMillis()));
				ob.setObtime(new Timestamp(System.currentTimeMillis()));
				ob.setRecordtime(new Timestamp(System.currentTimeMillis()));
				ob.setObservationTypeBean(observationTypeBeans.get(obTypeSelected));

				// Get the observation factors
				getObservationFactors(observationFactorBeans, ob);

				ObservationDAO observationDAO = new ObservationDAO(DAOFactory.getProductionInstance());
				int obid = observationDAO.insertObservationBean(ob);
				ob.setId(obid);

				for (ObservationInfoBean<?> observationInfoBean : ob.getObservationInfo()) {
					observationInfoBean.setObid(obid);
					ObservationInfoDAO infoDAO = new ObservationInfoDAO(DAOFactory.getProductionInstance());
					infoDAO.insertObservationInfoBean(observationInfoBean);
					if (observationInfoBean.getInfo().getClass().getName().equals("java.lang.Integer")) {
						infoDAO.insertObservationIntInfoBean((ObservationInfoBean<Integer>) observationInfoBean);
					} else if (observationInfoBean.getInfo().getClass().getName().equals("java.lang.String")) {
						infoDAO.insertObservationStringInfoBean((ObservationInfoBean<String>) observationInfoBean);
					} else if (observationInfoBean.getInfo().getClass().getName().equals("java.lang.Double")) {
						infoDAO.insertObservationDoubleInfoBean((ObservationInfoBean<Double>) observationInfoBean);
					}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			try {

				ObservationTypeBean observationTypeBean = new ObservationTypeBean();
				System.out.println("Name: ");
				Main.getScanner().nextLine();
				String name = Main.getScanner().nextLine();
				observationTypeBean.setName(name);
				System.out.println("What is your observation type: ");
				System.out.println("Behavioral [0]");
				System.out.println("Physiological [1]");
				System.out.println("Psychological [2]");
				int type = Main.getScanner().nextInt();
				observationTypeBean.setObtype(ObservationUtil.observationTypes.getType(type));

				int obtypeid = observationTypeDAO.insertObservationBean(observationTypeBean);
				observationTypeBean.setId(obtypeid);

				// Get the factors for this observation type
				System.out.println("Number of factors in this observation: ");
				Main.getScanner().nextLine();
				int factors = Main.getScanner().nextInt();
				ArrayList<ObservationFactorBean> factorBeans = new ArrayList<>();
				if (factors > 0) {
					for (int i = 0; i < factors; i++) {
						System.out.println("------------------------------");
						System.out.println("Factor " + i + ": ");
						System.out.println("What is the name of this factor: ");
						Main.getScanner().nextLine();
						String factorName = Main.getScanner().nextLine();
						System.out.println("What is your factor type: ");
						System.out.println("String/Text [0]");
						System.out.println("Integer [1]");
						System.out.println("Double/Real Number [2]");
						int factorstype = Main.getScanner().nextInt();
						ObservationFactorBean factorBean = new ObservationFactorBean(0, observationTypeBean.getId(), factorName, ObservationUtil.factorTypes.getType(factorstype));
						factorBeans.add(factorBean);

						ObservationFactorDAO factorDAO = new ObservationFactorDAO(DAOFactory.getProductionInstance());
						factorDAO.insertObservationFactorBean(factorBean);
					}
					System.out.println("------------------------------");
				} else {
					throw new InvalidInputException("Invalid Number");
				}
			} catch (InvalidInputException | InputMismatchException e) {
				System.out.println("Invalid Input");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		return -1;
	}

	private void getObservationFactors(List<ObservationFactorBean> observationFactorBeans, ObservationBean ob) {
		for (ObservationFactorBean observationFactorBean : observationFactorBeans) {
			System.out.print(observationFactorBean.getName() + "[" + observationFactorBean.getFactorType() + "]: ");
			ObservationInfoBeanFactory beanFactory = new ObservationInfoBeanFactory(Main.getScanner());
			ObservationInfoBean<?> oib = beanFactory.readObservation(observationFactorBean.getFactorType());
			oib.setName(observationFactorBean.getName());
			ob.getObservationInfo().add(oib);
			System.out.println();
		}
	}
}
