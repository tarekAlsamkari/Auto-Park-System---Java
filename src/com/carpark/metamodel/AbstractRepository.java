package com.carpark.metamodel;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class AbstractRepository implements TransactionManagement {

	private static EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();

	public void beginTransaction() {
		this.getEm().getTransaction().begin();
	}

	public void commitTransaction() {
		this.getEm().getTransaction().commit();
	}

	public Object create(Object o) {
		this.getEm().persist(o);
		return o;
	}

	public Object update(Object o) {
		Object managedEntity = AbstractRepository.em.merge(o);
		return managedEntity;
	}

	public void delete(Object o) {
		this.getEm().remove(o);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		AbstractRepository.em = em;
	}
}
