package com.ubs.opsit.interviews.exception;

public class UnsupportedDateFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsupportedDateFormatException(String message) {
		super(message);
	}

	public UnsupportedDateFormatException(String message, Throwable th) {
		super(message, th);
	}
}
