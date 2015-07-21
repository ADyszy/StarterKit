package com.capgemini.taxiV2_betterVersion;

import java.util.List;
import java.util.Observable;

public class TaxiSet extends Observable {

	private List<Taxi> taxies;

	public TaxiSet(List<Taxi> taxies) {
		this.setTaxies(taxies);
	}

	public List<Taxi> getTaxies() {
		return taxies;
	}

	public void setTaxies(List<Taxi> taxies) {
		this.taxies = taxies;
	}

	public void changed() {
		setChanged();
	}

	public String toString() {
		String str = "";
		for (Taxi taxi : taxies) {
			str += taxi + "\n";
		}
		return str;
	}

}
