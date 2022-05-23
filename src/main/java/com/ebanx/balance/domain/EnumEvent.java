package com.ebanx.balance.domain;

public enum EnumEvent {
	
	
	DEPOSIT("deposit"),
	WITHDRAW("withdraw"),
	TRANSFER("transfer");
	
	private String type;
	
	private EnumEvent(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
