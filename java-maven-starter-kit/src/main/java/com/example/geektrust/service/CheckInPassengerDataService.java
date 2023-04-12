package com.example.geektrust.service;

import com.example.geektrust.dto.MetroStation;
import com.example.geektrust.dto.Passenger;
import com.example.geektrust.dto.PassengerType;

public class CheckInPassengerDataService {

	public Passenger checkInData(String input, String passengerType, String station) {
		Passenger passenger = AddPassengerService.passenegerList.get(input);
		passenger.setType(PassengerType.valueOf(passengerType));
		passenger.setMetroStation(station);
		MetroStation metroStation = AddStationService.stationList.get(station);
		if (passengerType.equals(PassengerType.ADULT.toString())) {
			metroStation.totalAdultsTraveled++;
		} else if (passengerType.equals(PassengerType.KID.toString())) {
			metroStation.totalKidsTraveled++;
		} else
			metroStation.totalSeniorsTraveled++;
		passenger.setInitialCostPerJourney(passenger);
		return passenger;
	}

}
