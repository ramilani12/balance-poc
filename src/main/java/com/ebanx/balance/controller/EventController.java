package com.ebanx.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.balance.domain.AccountEvent;
import com.ebanx.balance.domain.Event;
import com.ebanx.balance.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	
	@Autowired
	private EventService eventService;
	
	@PostMapping
	public ResponseEntity<Object> event(@RequestBody final Event event) {

		AccountEvent accountEvent = eventService.execute(event);

		
		//Conta Nao Existe
		if (accountEvent == null) {
			return new ResponseEntity<Object>(0 , HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<Object>(accountEvent , HttpStatus.CREATED);
	}
	
}
