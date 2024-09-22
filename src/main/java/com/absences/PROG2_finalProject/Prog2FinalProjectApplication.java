package com.absences.PROG2_finalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.absences.PROG2_finalProject")
public class Prog2FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Prog2FinalProjectApplication.class, args);
	}

}
