package com.ubs.opsit.interviews.exception;

public class ValueOutOfRangeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValueOutOfRangeException(String message) {
		super(message);
	}

	public ValueOutOfRangeException(String message, Throwable th) {
		super(message, th);
	}

}
