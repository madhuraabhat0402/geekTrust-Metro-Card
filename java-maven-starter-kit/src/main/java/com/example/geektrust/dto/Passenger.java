package com.example.geektrust.dto;

import com.example.geektrust.configuration.Constants;

public class Passenger {
	public String id;
	public int balance;
	public PassengerType type;
	public int costPerJourney;
	public MetroStationName metroStation;
	public boolean isReturning = false;
	public MetroStationName lastStation;

	public Passenger(String id, int balance) {
		this.id = id;
		this.balance = balance;
	}


	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getCostPerJourney() {
		return costPerJourney;
	}

	public void setCostPerJourney(int costPerJourney) {
		this.costPerJourney = costPerJourney;
	}

	public MetroStationName getMetroStation() {
		return metroStation;
	}

	public void setMetroStation(String metroStation) {
		this.metroStation = MetroStationName.valueOf(metroStation);
	}

	public PassengerType getType() {
		return type;
	}

	public void setType(PassengerType type) {
		this.type = type;
	}

	public int calculateBalance(int balance, int costPerJourney) {
		this.balance = balance - costPerJourney;
		return this.balance;
	}

	public int calculateExtraCharge(int cost) {
		return (int) (cost * (Constants.SERVICE_CHARGE));
	}

	public MetroStationName getLastStaion() {
		return lastStation;
	}

	public void setLastStaion(MetroStationName lastStaion) {
		this.lastStation = lastStaion;
	}

	public boolean getIsReturning() {
		return isReturning;
	}

	public void setReturning(boolean isReturning) {
		this.isReturning = isReturning;
	}

	public void setInitialCostPerJourney(Passenger passenger) {
		if (passenger.getType().equals(PassengerType.ADULT)) {
			passenger.setCostPerJourney(Constants.PRICE_FOR_ADULT);

		} else if (passenger.getType().equals(PassengerType.KID)) {
			passenger.setCostPerJourney(Constants.PRICE_FOR_KID);
		} else
			passenger.setCostPerJourney(Constants.PRICE_FOR_SENIOR_CITIZEN);

	}
}
