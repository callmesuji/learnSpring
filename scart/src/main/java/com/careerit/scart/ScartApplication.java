package com.careerit.scart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.careerit.scart.dao.ProductDao;

@SpringBootApplication
public class ScartApplication implements CommandLineRunner {
	@Autowired
	ProductDao productDao;

	public static void main(String... args) {
		SpringApplication.run(ScartApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}

}
