package com.hack.vendorinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hack.vendorinventory"})
public class VendorinventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorinventoryApplication.class, args);
	}

}
