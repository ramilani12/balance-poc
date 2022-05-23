package com.ebanx.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanx.balance.domain.AccountEvent;
import com.ebanx.balance.domain.EnumEvent;
import com.ebanx.balance.domain.Event;

@Service
public class EventService {

	@Autowired
	private EventAccountDepositImpl depositEvent;
	
	@Autowired
	private EventAccountWithdrawImpl withdrawImpl;
	
	@Autowired
	private EventAccountTransferImpl transfImpl;
	
	public AccountEvent execute (final Event event) {
		
		if (EnumEvent.DEPOSIT.getType().equalsIgnoreCase(event.getType())) {
			
			return this.depositEvent.execute(event);
			
		} else if (EnumEvent.WITHDRAW.getType().equalsIgnoreCase(event.getType())) {
			
			return this.withdrawImpl.execute(event);
			
			
		} else if ( EnumEvent.TRANSFER.getType().equalsIgnoreCase(event.getType()) ) {
			
			return this.transfImpl.execute(event);
			
		} else {
		
			throw new IllegalArgumentException("Operation not allowed: " + event.getType());
			
		}
		
	}
	
}
