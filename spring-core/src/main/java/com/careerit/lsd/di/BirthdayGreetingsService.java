package com.careerit.lsd.di;

import org.springframework.stereotype.Service;

@Service
public class BirthdayGreetingsService implements GreetingService {

	@Override
	public String message() {
		return "HAPPY BIRTHDAY SUJITH";
	}

}
