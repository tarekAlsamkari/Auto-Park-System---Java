package com.carpark.repository;

import java.util.List;

import com.carpark.controller.FormController;
import com.carpark.model.entities.Partner;
import com.carpark.model.repository.MasterRepository;

public class TestPartners {

	static MasterRepository repo = new MasterRepository();

	public static void main(String[] args) {
		List<Partner> x = repo.getAllPartners();
		if (x.size() == 0) {
			addPartners();
			x = repo.getAllPartners();
		}

		assert x.size() > 0;

	}

	public static void addPartners() {
		Partner p = null;
		repo.beginTransaction();

		for (int i = 0; i < 6; i++) {
			p = new Partner();
			p.setAddress("Strada Dimitrie Cantemir " + i + ", 410473, Iasi");
			p.setEmail("contact@abcsrl" + i + ".com");
			p.setName("ABC SRL " + i);
			p.setPhoneNumber("+4025943135" + i);
			p.setType(FormController.PARTNER_CLIENT_TYPE);

			repo.addPartner(p);
		}
		repo.commitTransaction();
	}
}
