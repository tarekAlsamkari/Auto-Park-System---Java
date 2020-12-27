package com.carpark.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class RoadMap extends Document {

	private Integer roadMapNumber;
	private String vehicleRegistrationNum;
	private String transportType;
	private double outsideSpecificConsum;
	private double townSpecificConsumption;
	private double outTownKm;
	private double townKm;

	@ManyToOne
	private Driver driver;

	public RoadMap() {
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Integer getRoadMapNumber() {
		return roadMapNumber;
	}

	public void setRoadMapNumber(Integer roadMapNumber) {
		this.roadMapNumber = roadMapNumber;
	}

	public String getVehicleRegistrationNum() {
		return vehicleRegistrationNum;
	}

	public void setVehicleRegistrationNum(String vehicleRegistrationNum) {
		this.vehicleRegistrationNum = vehicleRegistrationNum;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public double getOutsideSpecificConsum() {
		return outsideSpecificConsum;
	}

	public void setOutsideSpecificConsum(double outsideSpecificConsum) {
		this.outsideSpecificConsum = outsideSpecificConsum;
	}

	public double getTownSpecificConsumption() {
		return townSpecificConsumption;
	}

	public void setTownSpecificConsumption(double townSpecificConsumption) {
		this.townSpecificConsumption = townSpecificConsumption;
	}

	public double getOutTownKm() {
		return outTownKm;
	}

	public void setOutTownKm(double outTownKm) {
		this.outTownKm = outTownKm;
	}

	public double getTownKm() {
		return townKm;
	}

	public void setTownKm(double townKm) {
		this.townKm = townKm;
	}
}
