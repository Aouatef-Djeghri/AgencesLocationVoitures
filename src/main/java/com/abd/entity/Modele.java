package com.abd.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="MODELE")
public class Modele implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMMOD")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numModel;
	
	@Column(name = "MARQUE")
	private String marque;
	
	public Modele() {
		super();
	}

	public Modele(String marque) {
		super();
		this.marque = marque;
	}
	
	public Modele(int numModel, String marque) {
		super();
		this.numModel = numModel;
		this.marque = marque;
	}

	public int getNumModel() {
		return numModel;
	}

	public void setNumModel(int numModel) {
		this.numModel = numModel;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Modele [numModel=" + numModel + ", marque=" + marque + "]";
	}	
	
}
