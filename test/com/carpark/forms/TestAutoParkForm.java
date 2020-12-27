package com.carpark.forms;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

import com.carpark.controller.FormController;
import com.carpark.controller.FormData;
import com.carpark.model.entities.Partner;

@SuppressWarnings("deprecation")
public class TestAutoParkForm {

	public static void main(String[] args) {

		FormController form = new FormController();
		FormData formData = form.getFormData();
		initialChecks(form);

		// 1. Load the registration numbers for the dropdown
		Assert.assertTrue("We should have at least two registration numbers to choose from",
				formData.getRegNumList().size() > 2);

		// 2. selectCarRegNum => load Vehicle Data for the selected car
		String selectedRegNum = formData.getRegNumList().get(1);

		Assert.assertTrue(selectedRegNum + " should be a Dacia Duster",
				formData.getBrandModel(selectedRegNum).equals("Dacia Duster"));

		Assert.assertTrue(selectedRegNum + " should have the Diesel fuel type",
				formData.getFuelType(selectedRegNum).equals(FormController.FUEL_TYPE_DIESEL));

		Assert.assertTrue(selectedRegNum + " should have a valid number of KM on board",
				formData.getKmOnBoard(selectedRegNum) > 0);
		formData.setSelectedVehicle(formData.getVehicleData(selectedRegNum));

		// 3. btnAddRoadMap.click() => load all clients in the grid
		Assert.assertTrue("We should have at least three two Clients", formData.getClients().size() > 2);
		// Then the user selects two of the clients in the grid
		List<Partner> selectedClientsList = new ArrayList<Partner>();
		selectedClientsList.add(formData.getClients().get(0));
		selectedClientsList.add(formData.getClients().get(1));
		formData.setSelectedClientsList(selectedClientsList);

		// 4.BtnSave.click() => save RoadMap in DB
		form.createRoadMap();
		Assert.assertTrue("We should have a new RoadMap created", formData.getRoadMap() != null);
		form.saveRoadMap();
	}

	private static void initialChecks(FormController form) {
		Assert.assertTrue("BUG or there are no Vehicles. Make sure you've run TestVehicles first.",
				form.getFormData().getVehiclesList().size() > 0);

		Assert.assertTrue("BUG or there are no Partners of type Client. Make sure you've run TestPartners first.",
				form.getFormData().getClients().size() > 0);

		Assert.assertTrue("BUG or there are no Drivers. Make sure you've run TestDrivers first.",
				form.getFormData().getDrivers().size() > 0);
	}

}
