package com.example.geektrust.io;

import com.example.geektrust.service.AddStationService;

public class OutputProcessor {

	public static String TOTAL_COLLECTION = "TOTAL_COLLECTION  ";
	public static String PASSENGER_TYPE_SUMMARY = "PASSENGER_TYPE_SUMMARY  ";
	public static final String CENTRAL = "CENTRAL";
	public static final String AIRPORT = "AIRPORT";

	public void totalCollection() {

		System.out.println(TOTAL_COLLECTION + AddStationService.stationList.get(CENTRAL).getStationName()+" "
				+ AddStationService.stationList.get(CENTRAL).getTotalTravelChargesCollected() + " "
				+ AddStationService.stationList.get(CENTRAL).getTotalDisocunt());
		System.out.println(PASSENGER_TYPE_SUMMARY);
		AddStationService.stationList.get(CENTRAL).passengerSummaryCalculate();

		System.out.println(TOTAL_COLLECTION + AddStationService.stationList.get(AIRPORT).getStationName()+" "
				+ AddStationService.stationList.get(AIRPORT).getTotalTravelChargesCollected() + " "
				+ AddStationService.stationList.get(AIRPORT).getTotalDisocunt());
		System.out.println(PASSENGER_TYPE_SUMMARY);
		AddStationService.stationList.get(AIRPORT).passengerSummaryCalculate();

	}

}
