package com.quatspec.api.enums;

public enum CustomerType {

	HOUSEHOLD("HHD"), CORPORATE("COP"), GOVERNMENT("GVT"), RELIGOUS("RLG"), NGO("NGO");
	
	private String code;

	private CustomerType(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.code;
	}
}
