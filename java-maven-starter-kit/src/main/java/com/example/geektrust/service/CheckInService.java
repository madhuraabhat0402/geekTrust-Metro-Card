package com.example.geektrust.service;

import com.example.geektrust.dto.MetroStation;
import com.example.geektrust.dto.MetroStationName;
import com.example.geektrust.dto.Passenger;

public class CheckInService {
	private static final int DIVIDE_BY_TWO=2;
	private static final int ZERO_BALANCE=0;
	

	public void checkInPassenger(Passenger passenger) {
		MetroStationName station = passenger.getMetroStation();
		int costPerJourney = checkIfPassengerIsReturning(passenger,station);
		int balance = passenger.getBalance();
		if (isBalanceEnough(balance, costPerJourney)) {
			passenger.calculateBalance(balance, costPerJourney);
			chargesCollectedAtStation(AddStationService.stationList.get(station.toString()), costPerJourney);
		} else {
			int serviceCharge = passenger.calculateExtraCharge(costPerJourney - balance);
			chargesCollectedAtStation(AddStationService.stationList.get(station.toString()),
					costPerJourney + serviceCharge);
			passenger.setBalance(ZERO_BALANCE);
		}
		passenger.setLastStaion(station);
		passenger.setReturning(!passenger.getIsReturning());
	}

	private int checkIfPassengerIsReturning(Passenger passenger, MetroStationName station) {
		int costPerJourney = passenger.getCostPerJourney();
		if (passenger.isReturning && passenger.lastStation != station) {
			costPerJourney = passenger.getCostPerJourney() / DIVIDE_BY_TWO;
			calculateDiscountGivenAtStations(station, costPerJourney);
		}
		return costPerJourney;
	}

	private void chargesCollectedAtStation(MetroStation metroStation, int costPerJourney) {
		metroStation.totalTravelChargesCollected += costPerJourney;

	}

	private void calculateDiscountGivenAtStations(MetroStationName station, int costPerJourney) {
		AddStationService.stationList.get(station.toString()).totalDisocunt += costPerJourney;
	}

	private boolean isBalanceEnough(int balance, int costPerJourney) {
		if (balance < costPerJourney) {
			return false;
		}
		return true;
	}

}
