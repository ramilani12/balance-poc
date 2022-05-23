package com.ebanx.balance.service;

import com.ebanx.balance.domain.AccountEvent;
import com.ebanx.balance.domain.Event;

public interface EventAccountInterface {
	
	/**
	 * Executa uma ação na Conta Corrente
	 * @param event
	 * @return {@link AccountEvent}
	 */
	public AccountEvent execute(final Event event);
	

}
