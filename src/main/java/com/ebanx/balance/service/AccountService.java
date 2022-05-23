package com.ebanx.balance.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ebanx.balance.domain.Account;

@Service
public class AccountService {

	private final Map<String, Account> accounts;

	public AccountService(Map<String, Account> accounts) {
		this.accounts = accounts;
	}

	public Optional<Account> getAccountPerId(final String accountId) {
		return Optional.ofNullable(accounts.get(accountId));
	}
	
	
	public Optional<Account> saveAccount(final Account account) {
		
		this.accounts.put(account.getId(), account);
		
		return Optional.of(account);
	}
	
}
