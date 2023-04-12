package com.example.geektrust.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.geektrust.dto.Passenger;
import com.example.geektrust.dto.PassengerType;
import com.example.geektrust.io.OutputProcessor;
import com.example.geektrust.service.AddPassengerService;
import com.example.geektrust.service.AddStationService;
import com.example.geektrust.service.CheckInPassengerDataService;
import com.example.geektrust.service.CheckInService;

import junit.framework.Assert;

public class OutputProcessorTest {
	AddPassengerService addPassengerService;
	CheckInService passengerService;
	CheckInPassengerDataService checkInPassengerDataService;
	OutputProcessor outputProcessor;

	@BeforeEach
	public void setup() {
		addPassengerService = new AddPassengerService();
		passengerService = new CheckInService();
		checkInPassengerDataService = new CheckInPassengerDataService();
		AddStationService.insertStationData();
		outputProcessor = new OutputProcessor();

	}

	@Test
	public void passengerCountByTypeDescending() {
		Passenger passenger = addPassengerService.addPassenger("MC1", 150);
		checkInPassengerDataService.checkInData("MC1", PassengerType.ADULT.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger);
		Passenger passenger2 = addPassengerService.addPassenger("MC2", 150);
		checkInPassengerDataService.checkInData("MC2", PassengerType.KID.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger2);
		Passenger passenger3 = addPassengerService.addPassenger("MC3", 150);
		checkInPassengerDataService.checkInData("MC3", PassengerType.KID.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger3);
		outputProcessor.totalCollection();
		Assert.assertEquals(AddStationService.stationList.get("AIRPORT").totalTravelChargesCollected, 301);
	}

	@Test
	public void equalPassengerCounSortByType() {
		Passenger passenger = addPassengerService.addPassenger("MC1", 150);
		checkInPassengerDataService.checkInData("MC1", PassengerType.ADULT.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger);
		Passenger passenger2 = addPassengerService.addPassenger("MC2", 150);
		checkInPassengerDataService.checkInData("MC2", PassengerType.KID.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger2);
		Passenger passenger3 = addPassengerService.addPassenger("MC3", 150);
		checkInPassengerDataService.checkInData("MC3", PassengerType.SENIOR_CITIZEN.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger3);
		outputProcessor.totalCollection();
		Assert.assertEquals(AddStationService.stationList.get("AIRPORT").totalTravelChargesCollected, 351);
	}

}
