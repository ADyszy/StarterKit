package com.capgemini.taxi;

import java.util.Comparator;

public class TaxiComparator implements Comparator<Taxi> {
	
	private User user; // TODO: not used because of efficiency. Work in progress.

	public TaxiComparator(User user) {
		this.user = user;
	}

	public int compare(Taxi o1, Taxi o2) {
		double dist1 = o1.distanceToUser(user);
		double dist2 = o2.distanceToUser(user);

		if (dist1 > dist2)
			return 1;
		if (dist1 < dist2)
			return -1;
		return 0; 
	}
}
