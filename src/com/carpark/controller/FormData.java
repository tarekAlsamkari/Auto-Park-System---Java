package com.carpark.controller;

import java.util.ArrayList;
import java.util.List;
import com.carpark.model.entities.Document;
import com.carpark.model.entities.Driver;
import com.carpark.model.entities.Partner;
import com.carpark.model.entities.RoadMap;
import com.carpark.model.entities.RoadMapRow;
import com.carpark.model.entities.Vehicle;
import com.carpark.model.repository.DocumentRepository;
import com.carpark.model.repository.MasterRepository;

public class FormData {

	private List<Vehicle> vehiclesList;
	private List<Partner> clientsList;
	private List<Driver> driversList;
	private List<String> regNumList;
	private Vehicle selectedVehicle;
	private List<Partner> selectedClientsList;
	private RoadMap roadMap;
	String transportType;
	String fuelType;
	public static final String PEOPLE = "People";
	public static final String CARGO = "Cargo";
	public static final String BENZIN = "Benzin";
	public static final String DIESEL = "Diesel";
	private MasterRepository masterRepository = new MasterRepository();
	private DocumentRepository documentRepository = new DocumentRepository();

	public FormData() {
		super();
	}

	public List<Vehicle> getVehiclesList() {
		if (this.vehiclesList == null) {
			this.vehiclesList = this.masterRepository.getAllVehicles();
		}
		return vehiclesList;
	}

	public void setVehiclesList(List<Vehicle> vehiclesList) {
		this.vehiclesList = vehiclesList;
	}

	public RoadMap getRoadMap() {
		return roadMap;
	}

	public void setRoadMap(RoadMap roadMap) {
		this.roadMap = roadMap;
	}

	public MasterRepository getMasterRepository() {
		return masterRepository;
	}

	public DocumentRepository getDocumentRepository() {
		return documentRepository;
	}

	public Vehicle getVehicleData(String regNum) {
		return this.getMasterRepository().getVehicleByRegistrationNumber(regNum);
	}

	public String getBrandModel(String regNum) {
		return this.getVehicleData(regNum).getBrandAndModel();
	}

	public String getFuelType(String regNum) {
		return this.getVehicleData(regNum).getFuelType();
	}

	public Double getKmOnBoard(String regNum) {
		return this.getVehicleData(regNum).getKmOnBoard();
	}

	public String getDriverName(String regNum) {
		return this.getVehicleData(regNum).getDriver().getFullName();
	}

	public List<Partner> getClients() {
		List<Partner> clientPartners = new ArrayList<Partner>();
		for (Partner p : this.getMasterRepository().getAllPartners()) {
			if (p.getType().equals(FormController.PARTNER_CLIENT_TYPE)) {
				clientPartners.add(p);
			}
		}
		return clientPartners;
	}

	public void setClients(List<Partner> clients) {
		this.clientsList = clients;
	}

	public List<Driver> getDrivers() {
		return this.getMasterRepository().getAllDrivers();
	}

	public void setDrivers(List<Driver> drivers) {
		this.driversList = drivers;
	}

	public List<String> getRegNumList() {
		List<String> registrationNumbers = new ArrayList<String>();
		for (Vehicle v : this.getMasterRepository().getAllVehicles()) {
			registrationNumbers.add(v.getRegistrationNumber());
		}
		return registrationNumbers;
	}

	public void setRegNumList(List<String> regNumList) {
		this.regNumList = regNumList;
	}

	public Vehicle getSelectedVehicle() {
		return selectedVehicle;
	}

	public void setSelectedVehicle(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
	}

	public List<Partner> getSelectedClientsList() {
		return selectedClientsList;
	}

	public void setSelectedClientsList(List<Partner> selectedClientsList) {
		this.selectedClientsList = selectedClientsList;
	}
}
