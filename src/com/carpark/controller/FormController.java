package com.carpark.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.carpark.model.entities.Partner;
import com.carpark.model.entities.RoadMap;
import com.carpark.model.entities.RoadMapRow;
import com.carpark.model.entities.Vehicle;

@ManagedBean
@SessionScoped
public class FormController {
	private FormData formData = new FormData();
	public static final String TRANSPORT_TYPE_PEOPLE = "People";
	public static final String TRANSPORT_TYPE_CARGO = "Cargo";
	public static final String FUEL_TYPE_BENZIN = "Benzin";
	public static final String FUEL_TYPE_DIESEL = "Diesel";
	public static final String PARTNER_CLIENT_TYPE = "client";
	public static final String PARTNER_PROVIDER_TYPE = "provider";
	public static final String DEFAULT_TRANSPORT_TYPE = TRANSPORT_TYPE_CARGO;

	public void createRoadMap() {
		Vehicle vehicle = this.getFormData().getSelectedVehicle();
		RoadMap roadMap = new RoadMap();
		roadMap.setTransportType(DEFAULT_TRANSPORT_TYPE);
		roadMap.setRoadMapNumber(new Random().nextInt());
		roadMap.setOperatingDate(new Date());
		roadMap.setDriver(vehicle.getDriver());

		List<Partner> clients = formData.getSelectedClientsList();
		for (Partner c : clients) {
			RoadMapRow roadMapRow = new RoadMapRow();
			roadMapRow.setPartner(c);
			roadMapRow.setRoadmap(roadMap);
			this.formData.getMasterRepository().create(roadMapRow);
		}

		this.formData.setRoadMap(roadMap);
	}

	public void saveRoadMap() {
		this.getFormData().getDocumentRepository().beginTransaction();
		this.getFormData().getDocumentRepository().saveDocument(this.getFormData().getRoadMap());
		this.getFormData().getDocumentRepository().commitTransaction();
	}

	public FormData getFormData() {
		return formData;
	}
}