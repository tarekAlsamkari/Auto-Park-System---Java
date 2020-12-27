package com.carpark.model.repository;

import java.util.List;

import com.carpark.metamodel.AbstractRepository;
import com.carpark.model.entities.Driver;
import com.carpark.model.entities.Partner;
import com.carpark.model.entities.Vehicle;

public class MasterRepository extends AbstractRepository {

	public void addVehicle(Vehicle vehicle) {
		this.create(vehicle);
	}

	public Partner addPartner(Partner partner) {
		return (Partner) this.create(partner);
	}

	public List<Partner> getAllPartners() {
		return this.getEm().createQuery("SELECT p FROM Partner p").getResultList();
	}

	public Driver addDriver(Driver driver) {
		return (Driver) this.create(driver);
	}

	public List<Driver> getAllDrivers() {
		return this.getEm().createQuery("SELECT d FROM Driver d").getResultList();
	}

	public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
		return (Vehicle) this.getEm().createQuery("SELECT v FROM Vehicle v WHERE v.registrationNumber = :registrationNumber")
				.setParameter("registrationNumber", registrationNumber).getSingleResult();
	}

//	public String getDriverByRegistrationNumber(Vehicle vehicle) {
//		return (Driver) this.getEm()
//				.createQuery("SELECT d.fullName FROM Driver d WHERE v.registrationNumber = d.registrationNumber ")
//				.getSingleResult();
//	}

	public List<Vehicle> getAllVehicles() {
		return this.getEm().createQuery("SELECT v FROM Vehicle v").getResultList();
	}

}
