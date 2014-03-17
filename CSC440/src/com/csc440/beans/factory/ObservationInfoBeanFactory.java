package com.csc440.beans.factory;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.csc440.beans.ObservationInfoBean;

public class ObservationInfoBeanFactory {
	private Scanner scanner;

	public ObservationInfoBeanFactory(Scanner scanner) {
		this.scanner = scanner;
	}

	public ObservationInfoBean readObservation(String factorType) throws InputMismatchException {
		switch (factorType) {
		case "int":
			int intFactor = scanner.nextInt();
			ObservationInfoBean<Integer> intInfoBean = new ObservationInfoBean<>();
			intInfoBean.setInfo(intFactor);
			return intInfoBean;
		case "string":
			String stringFactor = scanner.next();
			ObservationInfoBean<String> stringInfoBean = new ObservationInfoBean<>();
			stringInfoBean.setInfo(stringFactor);
			return stringInfoBean;
		case "double":
			double doubleFactor = scanner.nextDouble();
			ObservationInfoBean<Double> infoBean = new ObservationInfoBean<>();
			infoBean.setInfo(doubleFactor );
			return infoBean;
		default:
			break;
		}

		return null;
	}
}
