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

public class PassengerTest {

	AddPassengerService addPassengerService;
	CheckInService passengerService;
	CheckInPassengerDataService checkInPassengerDataService;
	

	@BeforeEach
	public void setup() {
		addPassengerService = new AddPassengerService();
		passengerService = new CheckInService();
		checkInPassengerDataService = new CheckInPassengerDataService();
		AddStationService.insertStationData();
		
	}

	@Test
	public void checkInserviceTestSuccess() {
		Passenger passenger = addPassengerService.addPassenger("MC1", 500);
		checkInPassengerDataService.checkInData("MC1", PassengerType.KID.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger);
		Assert.assertEquals(passenger.getBalance(), 500 - passenger.getCostPerJourney());
	}

	@Test
	public void checkInserviceTestBalanceNotEnough() {
		Passenger passenger = addPassengerService.addPassenger("MC2", 50);
		checkInPassengerDataService.checkInData("MC2", PassengerType.ADULT.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger);
		Assert.assertEquals(passenger.getBalance(), 0);
		Assert.assertEquals(AddStationService.stationList.get("AIRPORT").totalTravelChargesCollected, 203);
	}

	@Test
	public void checkInserviceTestReturning() {
		Passenger passenger = addPassengerService.addPassenger("MC3", 150);
		checkInPassengerDataService.checkInData("MC3", PassengerType.ADULT.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger);
		checkInPassengerDataService.checkInData("MC3", PassengerType.ADULT.toString(), "CENTRAL");
		passengerService.checkInPassenger(passenger);
		Assert.assertEquals(passenger.getBalance(), 0);
		Assert.assertEquals(AddStationService.stationList.get("AIRPORT").totalTravelChargesCollected, 201);
	}

	@Test
	public void checkInserviceTestFalseReturning() {
		Passenger passenger = addPassengerService.addPassenger("MC4", 150);
		checkInPassengerDataService.checkInData("MC4", PassengerType.ADULT.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger);
		checkInPassengerDataService.checkInData("MC4", PassengerType.ADULT.toString(), "AIRPORT");
		passengerService.checkInPassenger(passenger);
		Assert.assertEquals(passenger.getBalance(), 0);
		Assert.assertEquals(AddStationService.stationList.get("AIRPORT").totalTravelChargesCollected, 405);
	}

}
