package com.carpark.model.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.carpark.metamodel.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Vehicle extends AbstractEntity {

	private String registrationNumber;
	private String brandAndModel;
	private String ChassisSeries;
	private Double kmOnBoard;
	private String fuelType;

	@OneToOne
	private Driver driver;

	public Vehicle() {
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBrandAndModel() {
		return brandAndModel;
	}

	public void setBrandAndModel(String brandAndModel) {
		this.brandAndModel = brandAndModel;
	}

	public String getChassisSeries() {
		return ChassisSeries;
	}

	public void setChassisSeries(String ChassisSeries) {
		this.ChassisSeries = ChassisSeries;
	}

	public Double getKmOnBoard() {
		return kmOnBoard;
	}

	public void setKmOnBoard(Double kmOnBoard) {
		this.kmOnBoard = kmOnBoard;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
}
