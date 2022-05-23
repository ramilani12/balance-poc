package com.ebanx.balance.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AccountEvent {
	
	private Account origin;
	
	private Account destination;

	public Account getOrigin() {
		return origin;
	}

	public void setOrigin(Account origin) {
		this.origin = origin;
	}

	public Account getDestination() {
		return destination;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

}
