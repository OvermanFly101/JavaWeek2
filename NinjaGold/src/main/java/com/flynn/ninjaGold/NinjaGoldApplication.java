package com.flynn.ninjaGold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NinjaGoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjaGoldApplication.class, args);
		
		int min = 0;
		int max = 50;
		int randomInt = (int) Math.floor(Math.random() * (max-min+1) + min);
		System.out.println("Random number between " + min + " and " + max + ". Number: " + randomInt);
		
		
		
		Gold treasure = new Gold();
		treasure.addGold(randomInt);
		System.out.println( "Treasure: " + treasure.getGold());
	}

}
