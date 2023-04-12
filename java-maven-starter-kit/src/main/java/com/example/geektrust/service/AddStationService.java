package com.example.geektrust.service;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.dto.MetroStation;
import com.example.geektrust.dto.Passenger;

public class AddStationService {
	public static final String CENTRAL = "CENTRAL";
	public static final String AIRPORT = "AIRPORT";

	public static Map<String, MetroStation> stationList = new HashMap<String, MetroStation>();

	
	public static void insertStationData() {
		stationList.put(CENTRAL, new MetroStation(CENTRAL));
		stationList.put(AIRPORT, new MetroStation(AIRPORT));

	}
}
