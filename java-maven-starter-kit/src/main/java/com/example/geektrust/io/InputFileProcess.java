package com.example.geektrust.io;

import java.util.Scanner;

import com.example.geektrust.dto.Passenger;
import com.example.geektrust.service.AddPassengerService;
import com.example.geektrust.service.CheckInPassengerDataService;
import com.example.geektrust.service.CheckInService;

public class InputFileProcess {

	private static final int SUBSTRING_BALANCE = 7;
	private static final int SUBSTRING_CHECK_IN = 8;

	AddPassengerService addPassengerService = new AddPassengerService();
	CheckInPassengerDataService checkInPassengerDataService = new CheckInPassengerDataService();

	public void processPassengerData(Scanner scanner) {

		while (scanner.hasNext()) {
			String input = scanner.next();

			if (input.contains("BALANCE")) {
				input = input.substring(SUBSTRING_BALANCE);
				//String balance = scanner.next();
				int balance=scanner.nextInt();
				addPassengerService.addPassenger(input, balance);

			} else if (input.contains("CHECK_IN")) {
				input = input.substring(SUBSTRING_CHECK_IN);
				String passengerType = scanner.next();
				String station = scanner.next();
				Passenger passenger = checkInPassengerDataService.checkInData(input, passengerType, station);
				metroCardComputation(passenger);
			} else if (input.equals("PRINT_SUMMARY")) {
				OutputProcessor oprocessor = new OutputProcessor();
				oprocessor.totalCollection();
				break;
			}
		}

	}

	private void metroCardComputation(Passenger passenger) {
		CheckInService passengerService = new CheckInService();
		passengerService.checkInPassenger(passenger);

	}

}
