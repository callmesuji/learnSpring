package com.careerit.lsd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.careerit.lsd.di.DisplayGreetings;
import com.careerit.lsd.di.GreetingService;

@SpringBootApplication
public class SpringCoreApplication implements CommandLineRunner {
	@Autowired
	private DisplayGreetings displayGreetings;

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		displayGreetings.sendGreetings();
	}

}
