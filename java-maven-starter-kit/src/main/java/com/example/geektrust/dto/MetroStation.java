package com.example.geektrust.dto;

import java.util.HashMap;
import java.util.Map;

public class MetroStation {
	public MetroStationName stationName;
	public int totalTravelChargesCollected = 0;
	public int totalDisocunt = 0;
	public int totalAdultsTraveled = 0;
	public int totalKidsTraveled = 0;
	public int totalSeniorsTraveled = 0;

	Map<PassengerType, Integer> passengerSummary = new HashMap<PassengerType, Integer>();

	public MetroStation(String station) {
		this.stationName = MetroStationName.valueOf(station);
	}

	public MetroStationName getStationName() {
		return stationName;
	}

	public int getTotalTravelChargesCollected() {
		return totalTravelChargesCollected;
	}

	public int getTotalDisocunt() {
		return totalDisocunt;
	}


	public void passengerSummaryCalculate() {
		passengerSummary.put(PassengerType.ADULT, totalAdultsTraveled);
		passengerSummary.put(PassengerType.KID, totalKidsTraveled);
		passengerSummary.put(PassengerType.SENIOR_CITIZEN, totalSeniorsTraveled);
		for (PassengerType key : passengerSummary.keySet()) {
			if (passengerSummary.get(key) > 0)
				System.out.println(passengerSummary.get(key) + " " + key);

		}
	}
	
}
