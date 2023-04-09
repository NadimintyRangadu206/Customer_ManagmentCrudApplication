package com.customermanagment.exception;

public class CustomerException extends RuntimeException {


	private static final long serialVersionUID = 4739879539320660133L;
	private final int errorCode;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public CustomerException(int errorCode, String message) {

		super(message);
		this.errorCode = errorCode;

	}

	@Override
	public String toString() {
		return "CustomerException [errorCode=" + errorCode + "]";
	}

}
