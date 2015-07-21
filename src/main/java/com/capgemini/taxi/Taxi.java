package com.capgemini.taxi;

import java.util.List;
import java.util.Random;

public class Taxi extends Thread {

	private double distanceToUser; // for better efficiency. TODO it better.

	private static int lastId = 0;
	private int id;
	private Position position;
	private boolean free = true;
	private CitySpace citySpace;

	public static void clearLastID(){ //For tests
		lastId = 0;
	}
	
	private synchronized static int autoincrementId() {
		return (++lastId);
	}

	public boolean isFree() {
		return free;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position taxiPosition) {
		this.position = taxiPosition;
	}

	public int getXPosition() {
		return this.position.getXPosition();
	}

	public void setXPosition(int xPosition) {
		this.position.setXPosition(xPosition);
	}

	public int getYPosition() {
		return this.position.getYPosition();
	}

	public void setYPosition(int yPosition) {
		this.position.setYPosition(yPosition);
	}

	public void setPosition(int xPosition, int yPosition) {
		this.position.setPosition(xPosition, yPosition);
	}

	public CitySpace getCitySpace() {
		return citySpace;
	}

	public void setCitySpace(CitySpace citySpace) {
		this.citySpace = citySpace;
	}

	public int getTaxiId() {
		return id;
	}

	public void setTaxiId(int id) {
		this.id = id;
	}

	// PositionOutOfBoundsException tylko po to, zeby taksowki nie uciekaly zbyt
	// szybko. Wlasciwie do symulacji tylko.
	public Taxi(CitySpace citySpace, int xPosition, int yPosition) throws PositionOutOfBoundsException {
		synchronized (citySpace) {
			this.setCitySpace(citySpace);
			Position p = new Position(xPosition, yPosition);
			if (!inBoundsOfCitySpace(p))
				throw new PositionOutOfBoundsException("Taxi is out of bounds");
			this.setPosition(p);
			setTaxiId(autoincrementId());
			takePlace();
		}
	}

	boolean inBoundsOfCitySpace(Position p) {
		if (citySpace.getxSize() <= p.getXPosition() || citySpace.getySize() <= p.getYPosition())
			return false; 
		return true;
	}

	public void makeRandomStep() {

		Random rand = new Random();
		int stepX = rand.nextInt(3) - 1;
		int stepY = rand.nextInt(3) - 1;

		while (!stepAtXAxis(stepX))
			stepX = rand.nextInt(3) - 1;
		while (!stepAtYAxis(stepY))
			stepY = rand.nextInt(3) - 1;
		
	}

	private boolean stepAtXAxis(int stepSize) {
		synchronized (citySpace) {
			int newPos = position.getXPosition() + stepSize;
			if (newPos < citySpace.getxSize() - 1 && newPos >= 0) {
				position.setXPosition(position.getXPosition() + stepSize);
				return true;
			}
			return false;
		}
	}

	private boolean stepAtYAxis(int stepSize) {
		synchronized (citySpace) {
			int newPos = position.getYPosition() + stepSize;
			if (newPos < citySpace.getySize() - 1 && newPos >= 0) {
				position.setYPosition(position.getYPosition() + stepSize);
				return true;
			}
			return false;
		}
	}

	public String toString() {
		return new String("id : " + getTaxiId() + " (" + getXPosition() + "," + getYPosition() + ")");
	}

	public double distanceToUser(User user) {
		return distanceToUser = distanceToPosiotion(user.getPosition());
	}

	public double getDistanceToUser() {
		return distanceToUser;
	}

	public double distanceToPosiotion(Position p) {
		synchronized (citySpace.getTaxies()) {
			return position.getDistanceTo(p);
		}
	}

	public static void printTaxiList(List<Taxi> taxies, User user) {
		synchronized (taxies) {
			for (Taxi taxi : taxies) {
				System.out.println(taxi + " , distance to user: " + (int) taxi.distanceToUser(user));
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			makeRandomStep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void takePlace() {
		if (citySpace == null)
			throw new NullPointerException("Trying to occupy non existing citySpace");
		citySpace.addTaxiToCitySpace(this);
	}

}
