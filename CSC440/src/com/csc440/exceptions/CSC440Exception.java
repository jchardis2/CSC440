package com.csc440.exceptions;

public class CSC440Exception extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 265675215152213763L;
	String message = null;

	/**
	 * The typical constructor.
	 * 
	 * @param message
	 *            A message to be displayed to the screen.
	 */
	public CSC440Exception(String message) {
		this.message = message;
	}

	/**
	 * For messages which are displayed to the user. Usually, this is a very
	 * general message for security reasons.
	 */
	@Override
	public String getMessage() {
		if (message == null)
			return "An error has occurred. Please see log for details.";
		return message;
	}

	/**
	 * For exceptions which show a lot of technical detail, usually delegated to
	 * a subclass
	 * 
	 * @return
	 */
	public String getExtendedMessage() {
		return "No extended information.";
	}
}
