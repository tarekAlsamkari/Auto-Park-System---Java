package com.carpark.model.repository;

import com.carpark.metamodel.AbstractRepository;
import com.carpark.model.entities.Document;

public class DocumentRepository extends AbstractRepository {

	public Document saveDocument(Document document) {
		if (document.getId() == null)
			document = (Document) this.create(document);
		else
			document = (Document) this.update(document);
		return document;
	}
}
