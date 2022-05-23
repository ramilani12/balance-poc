package com.ebanx.balance.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.balance.domain.Account;
import com.ebanx.balance.service.AccountService;

@RestController
@RequestMapping("/balance")
public class BalanceController {

	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping
	public ResponseEntity<Object> getAccount(@RequestParam(value="account_id") String accountId) {
	
		Optional<Account> accOptional = this.accountService.getAccountPerId(accountId);
		
		if (!accOptional.isPresent()) {
			return new ResponseEntity<Object>(0 , HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(accOptional.get().getBalance());
	}
	
}
