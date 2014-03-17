package com.csc440.util;

public class ObservationUtil {

	public static enum observationTypes {
		Physiological, Behavioral, Psychological;

		public static int getType(String type) {
			switch (type) {
			case "Physiological":
				return 0;
			case "Behavioral":
				return 1;
			case "Psychological":
				return 2;
			}
			return -1;

		}

		public static String getType(int type) {
			switch (type) {
			case 0:
				return "Physiological";
			case 1:
				return "Behavioral";
			case 2:
				return "Psychological";
			}
			return null;

		}
	}
	
	public static enum factorTypes {
		STRING, INT, DOUBLE;

		public static int getType(String type) {
			switch (type) {
			case "string":
				return 0;
			case "int":
				return 1;
			case "double":
				return 2;
			}
			return -1;

		}

		public static String getType(int type) {
			switch (type) {
			case 0:
				return "string";
			case 1:
				return "int";
			case 2:
				return "double";
			}
			return null;

		}
	}
}
