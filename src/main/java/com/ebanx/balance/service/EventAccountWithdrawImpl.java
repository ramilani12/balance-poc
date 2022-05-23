package com.ebanx.balance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanx.balance.domain.Account;
import com.ebanx.balance.domain.AccountEvent;
import com.ebanx.balance.domain.Event;

@Service
public class EventAccountWithdrawImpl implements EventAccountInterface {

	@Autowired
	private AccountService accountService;
	
	@Override
	public AccountEvent execute(Event event) {
		
		final AccountEvent accountEvent = new AccountEvent();
		
		final Optional<Account> accountOptional = this.accountService.getAccountPerId(event.getOrigin());
		
		if ( ! accountOptional.isPresent()) {
			return null;
		}
		
		Account account = accountOptional.get();
		
		account.setBalance(account.getBalance().subtract(event.getAmount()));
	
		
		//Save Account
		accountEvent.setOrigin(this.accountService.saveAccount(account).get());
		
		return accountEvent;
	}

}
