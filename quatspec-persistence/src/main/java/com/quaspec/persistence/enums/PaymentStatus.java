package com.quaspec.persistence.enums;

public enum PaymentStatus {

	INITIATED ("INI"), PENDING ("PND"), FAILED ("FAI"), COMPLETED ("CMP"), PARTIAL_PAYMENT ("PCP");
	
	private String code;

	private PaymentStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public String toString() {
		return this.code;
	}
	
	

}
