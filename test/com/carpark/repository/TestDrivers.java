package com.carpark.repository;

import java.util.List;

import com.carpark.model.entities.Driver;
import com.carpark.model.repository.MasterRepository;

public class TestDrivers {

	static MasterRepository repo = new MasterRepository();

	public static void main(String[] args) {
		List<Driver> x = repo.getAllDrivers();
		if (x.size() == 0) {
			addDrivers();
			x = repo.getAllDrivers();
		}

		assert x.size() > 0;

	}

	public static void addDrivers() {
		Driver d = null;
		repo.beginTransaction();

		for (int i = 0; i < 3; i++) {
			d = new Driver();
			d.setActive(true);
			d.setDriverLicence("AAABBB553" + i);
			d.setFullName("Ion Popescu " + i);
			d.setPosition("Salesman " + i);
			d.setTelephone("+407305561" + i);

			repo.addDriver(d);
		}
		repo.commitTransaction();
	}
}
