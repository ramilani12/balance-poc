package com.ebanx.balance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanx.balance.domain.Account;
import com.ebanx.balance.domain.AccountEvent;
import com.ebanx.balance.domain.Event;

@Service
public class EventAccountDepositImpl implements EventAccountInterface {

	@Autowired
	private AccountService accountService;
	
	@Override
	public AccountEvent execute(Event event) {

		Optional<Account> accountExist = this.accountService.getAccountPerId(event.getDestination());
		
		final AccountEvent accountEvent = new AccountEvent();
		
		Account acc = null;
		
		if (! accountExist.isPresent()) {
			//Cria a conta
			acc = new Account(event.getDestination(), event.getAmount());
			
		} else {
			
			//A conta existe, realiza o deposito no saldo atual
			acc = accountExist.get();
			acc.setBalance(acc.getBalance().add(event.getAmount()));
		
		}
		
		
		accountEvent.setDestination(this.accountService.saveAccount(acc).get());
		return accountEvent;
		
	}
	
	
	

}
