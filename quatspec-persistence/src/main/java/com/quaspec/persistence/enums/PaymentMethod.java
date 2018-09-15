package com.quaspec.persistence.enums;

public enum PaymentMethod {

	TRANSFER ("TRF"), CASH ("CSH"), CHEQUE ("CHQ"), DEBIT("DBT");

	private String code;

	private PaymentMethod(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public String toString() {
		return this.code;
	}
}
