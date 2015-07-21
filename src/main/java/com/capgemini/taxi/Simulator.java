package com.capgemini.taxi;

import java.util.Random;

public class Simulator {
	public static final int NUMER_OF_TAXIES = 2000000;
	public static final int CITY_SIZE = 100000; // jako bok kwadratu


	private static void threadInit() {
		CitySpace citySpace = new CitySpace(CITY_SIZE, CITY_SIZE);
		User user = new User(citySpace, new Position(0, 0));
		Random r = new Random();
		Taxi t = null; 
		try {
			System.out.println("Generating tax threads..");
			for (int i = 0; i < NUMER_OF_TAXIES; i++) {
				t = new Taxi(citySpace, r.nextInt(CITY_SIZE), r.nextInt(CITY_SIZE));
				t.start();
			}
			System.out.println("done."); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		threadSimulation(user);
	}

	private static void threadSimulation(User user) {
		while (true) {
			user.findTaxies();
			user.printUsersTaxies();
			System.out.println("==============");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	private static void stepByStepInit() {
		CitySpace citySpace = new CitySpace(CITY_SIZE, CITY_SIZE);
		User user = new User(citySpace, new Position(0, 0));
		Random r = new Random();
		try {
			Taxi t = null;
			System.out.println("Generating taxies..");
			for (int i = 0; i < NUMER_OF_TAXIES; i++) {
				t = new Taxi(citySpace, r.nextInt(CITY_SIZE), r.nextInt(CITY_SIZE));
			}
			System.out.println("done. " + t.getTaxiId() + " taxies in the city.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		stepByStepSimulation(user);
	}

	private static void stepByStepSimulation(User user) {
		while (true) {
			System.out.println("==============");
			for (Taxi taxi : user.citySpace.getTaxies()) {
				taxi.makeRandomStep();
			}
			user.findTaxies();
			user.printUsersTaxies();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		threadInit();
	}

}