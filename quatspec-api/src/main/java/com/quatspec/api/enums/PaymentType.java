package com.quatspec.api.enums;

public enum PaymentType {

	BALANCE ("BAL"), ADVANCE ("ADV"), ARREAR ("ARR"), DUE("DUE");

	private String code;

	private PaymentType(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public String toString() {
		return this.code;
	}
}
