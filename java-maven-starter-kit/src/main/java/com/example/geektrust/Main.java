package com.example.geektrust;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.example.geektrust.io.InputFileProcess;
import com.example.geektrust.service.AddStationService;

public class Main {

	public static void main(String[] args) throws IOException {
		String fileName =args[0];
		Path path = Paths.get(fileName);
		Scanner scanner = new Scanner(path);
		InputFileProcess processor = new InputFileProcess();
		AddStationService.insertStationData();
		processor.processPassengerData(scanner);
		scanner.close();
	}
}
