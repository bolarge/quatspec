package com.quatspec.persistence.enums;

/**
 * @author bolarge
 *
 */
public enum AddressType {
	
	Billing("B"), Residence("R"), Corporate("C"), Government("G");
	
	private String code;

	private AddressType(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.code;
	}

}
