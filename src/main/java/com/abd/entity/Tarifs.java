package com.abd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="TARIFS")
@IdClass(TarifsId.class)
public class Tarifs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MODELOC")
	private String modeLocation;
	
	@Id
	@Column(name = "NUMCAT")
	private int numCategorie;
	
	@Column(name = "COUTBASE")
	private int coutBase;
	
	@Column(name = "KMFORFAIT")
	private int kmFrofait;

	
	public Tarifs() {
		super();
	}

//	public Tarifs(int numCategorie, int coutBase, int kmFrofait) {
//		super();
//		this.numCategorie = numCategorie;
//		this.coutBase = coutBase;
//		this.kmFrofait = kmFrofait;
//	}
	
	public Tarifs(String modeLocation, int numCategorie, int coutBase, int kmFrofait) {
		super();
		this.modeLocation = modeLocation;
		this.numCategorie = numCategorie;
		this.coutBase = coutBase;
		this.kmFrofait = kmFrofait;
	}

	public String getModeLocation() {
		return modeLocation;
	}

	public void setModeLocation(String modeLocation) {
		this.modeLocation = modeLocation;
	}

	public int getNumCategorie() {
		return numCategorie;
	}

	public void setNumCategorie(int numCategorie) {
		this.numCategorie = numCategorie;
	}

	public int getCoutBase() {
		return coutBase;
	}

	public void setCoutBase(int coutBase) {
		this.coutBase = coutBase;
	}

	public int getKmFrofait() {
		return kmFrofait;
	}

	public void setKmFrofait(int kmFrofait) {
		this.kmFrofait = kmFrofait;
	}

	@Override
	public String toString() {
		return "Tarifs [modeLocation=" + modeLocation + ", numCategorie=" + numCategorie + ", coutBase=" + coutBase
				+ ", kmFrofait=" + kmFrofait + "]";
	}
	
	
	
}
