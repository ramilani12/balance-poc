package com.ebanx.balance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanx.balance.domain.Account;
import com.ebanx.balance.domain.AccountEvent;
import com.ebanx.balance.domain.Event;


@Service
public class EventAccountTransferImpl implements EventAccountInterface {

	@Autowired
	private AccountService accountService;
	
	
	@Override
	public AccountEvent execute(Event event) {
		
		final Optional<Account> accountOriginOpt = this.accountService.getAccountPerId(event.getOrigin());
		
		final Optional<Account> accDestinationOptional = this.accountService.getAccountPerId(event.getDestination());
		
		if ( !accountOriginOpt.isPresent() || !accDestinationOptional.isPresent()) {
			return null;
		}
		
		
		final AccountEvent accountEvent = new AccountEvent();
		
		Account accOrigin = accountOriginOpt.get();
		
		Account accDestination = accDestinationOptional.get();
		
		accDestination.setBalance(accDestination.getBalance().add(event.getAmount()));
		
		accOrigin.setBalance(accOrigin.getBalance().subtract(event.getAmount()));
		
		//Save Accounts
		this.accountService.saveAccount(accDestination);
		this.accountService.saveAccount(accOrigin);
		
		accountEvent.setOrigin(accOrigin);
		
		accountEvent.setDestination(accDestination);
		
		return accountEvent;
		
	}

}
