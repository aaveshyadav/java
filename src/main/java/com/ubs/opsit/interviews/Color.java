package com.ubs.opsit.interviews;

/**
 * An enum to define the colors used in Berlin clock.
 * 
 * @author Aavesh Yadav
 *
 */
public enum Color {

	RED("R"), YELLOW("Y");

	/**
	 * The code for the corresponding enum.
	 */
	private String code;

	/**
	 * The constructor.
	 * 
	 * @param code
	 *            the code of the enum
	 */
	Color(String code) {
		this.code = code;
	}

	/**
	 * Returns the code of the corresponding enum.
	 * 
	 * @return the code of the enum
	 */
	public String getCode() {
		return code;
	}

}
