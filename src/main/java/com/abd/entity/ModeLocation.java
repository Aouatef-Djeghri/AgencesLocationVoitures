package com.abd.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="MODE_LOCATION")
public class ModeLocation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MODELOC")
	private String modLocation;
	
	@Column(name = "DESCMODELOC")
	private String descModeLocation;

	public ModeLocation() {
		super();
	}

	public ModeLocation(String modLocation, String descModeLocation) {
		super();
		this.modLocation = modLocation;
		this.descModeLocation = descModeLocation;
	}

	public String getModLocation() {
		return modLocation;
	}

	public void setModLocation(String modLocation) {
		this.modLocation = modLocation;
	}

	public String getDescModeLocation() {
		return descModeLocation;
	}

	public void setDescModeLocation(String descModeLocation) {
		this.descModeLocation = descModeLocation;
	}
	
	
	@Override
	public String toString() {
		return "ModeLocation [modLocation=" + modLocation + ", descModeLocation=" + descModeLocation + "]";
	}
	
}
