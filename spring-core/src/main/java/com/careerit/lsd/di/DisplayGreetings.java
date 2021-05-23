package com.careerit.lsd.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DisplayGreetings {
	@Autowired
	private GreetingService greetingService;
 
	public void sendGreetings() {
		System.out.println(greetingService.message());

	}

}
