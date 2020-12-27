package com.carpark.repository;

import java.util.List;
import java.util.Random;

import com.carpark.controller.FormController;
import com.carpark.model.entities.Vehicle;
import com.carpark.model.repository.MasterRepository;

public class TestVehicles {

	static MasterRepository repo = new MasterRepository();

	public static void main(String[] args) {
		List<Vehicle> x = repo.getAllVehicles();
		if (x.size() == 0) {
			addVehicles();
			x = repo.getAllVehicles();
		}

		assert x.size() > 0;
	}

	public static void addVehicles() {
		Vehicle v = null;
		repo.beginTransaction();

		for (int i = 0; i < 3; i++) {
			v = new Vehicle();
			v.setBrandAndModel("Dacia Duster");
			v.setChassisSeries("1545348999" + i);
			v.setDriver(repo.getAllDrivers().get(i));
			v.setFuelType(FormController.FUEL_TYPE_DIESEL);
			v.setKmOnBoard(new Random().nextDouble() * 1000000);
			v.setRegistrationNumber("IS-1" + i + "PSI");

			repo.addVehicle(v);
		}
		repo.commitTransaction();
	}
}
