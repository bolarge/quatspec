package com.quaspec.persistence.enums;

/**
 * @author bolarge
 *
 */
public enum BillStatus {
	
	DUE("D"), PAID("P");
	
	private String code;

	private BillStatus(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.code;
	}

}
