package com.capgemini.taxiV2;

import java.util.Comparator;

public class TaxiComparator implements Comparator<Taxi> {

	private User user;

	public TaxiComparator(User user) {
		this.user = user;
	}

	public int compare(Taxi o1, Taxi o2) {
		double dist1 = o1.getPosition().getDistanceTo(user.getPosition());
		double dist2 = o2.getPosition().getDistanceTo(user.getPosition());

		if (dist1 > dist2)
			return 1;
		if (dist1 < dist2)
			return -1;
		return 0;
	}

}