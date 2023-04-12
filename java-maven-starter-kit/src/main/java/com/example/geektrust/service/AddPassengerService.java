package com.example.geektrust.service;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.dto.Passenger;

public class AddPassengerService {
	public static Map<String, Passenger> passenegerList = new HashMap<String, Passenger>();

	public Passenger addPassenger(String id, int balance) {
		passenegerList.put(id, new Passenger(id, balance));
		return passenegerList.get(id);	
	}
}