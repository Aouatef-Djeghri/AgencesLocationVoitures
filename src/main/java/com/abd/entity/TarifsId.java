package com.abd.entity;

import java.io.Serializable;


public class TarifsId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String modeLocation;
	
	private int numCategorie;

	public TarifsId() {
		super();
	}

	public TarifsId(String modeLocation, int numCategorie) {
		this.modeLocation = modeLocation;
		this.numCategorie = numCategorie;
	}

	
	
}
