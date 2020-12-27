package com.carpark.model.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.carpark.metamodel.AbstractEntity;

@SuppressWarnings("serial")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Document extends AbstractEntity {

	@Temporal(value = TemporalType.DATE)
	private Date releaseDate;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date operatingDate;
	
	private String workUnit;

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getOperatingDate() {
		return operatingDate;
	}

	public void setOperatingDate(Date localDateTime) {
		this.operatingDate = localDateTime;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
}
