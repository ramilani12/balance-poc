package com.ebanx.balance;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.ebanx.balance.domain.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class SeedingApplicationDataConfiguration {

    private Map<String , Account> accounts = new HashMap<String, Account>();
    
    @Bean
    public Map<String , Account> accounts() {
    	
    	final Account account1 = new Account("123" , new BigDecimal(120));
    	
    	this.accounts.put(account1.getId(), account1);
    	
    	return this.accounts;
    }
    
    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }
}
