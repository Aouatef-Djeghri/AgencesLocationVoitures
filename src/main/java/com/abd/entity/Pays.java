package com.abd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYS")
public class Pays implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMPAY")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numPays;
	
	@Column(name = "NOMPAY")
	private String nomPays;
	
	@Column(name = "NBRHABITANT")
	private int nbrHabitant;
	

	public Pays() {
		super();
	}

	public Pays(String nomPays, int nbrHabitant) {
		super();
		this.nomPays = nomPays;
		this.nbrHabitant = nbrHabitant;
	}
	
	public Pays(int numPays, String nomPays, int nbrHabitant) {
		super();
		this.numPays = numPays;
		this.nomPays = nomPays;
		this.nbrHabitant = nbrHabitant;
	}

	public int getNumPays() {
		return numPays;
	}

	public void setNumPays(int numPays) {
		this.numPays = numPays;
	}

	public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public int getNbrHabitant() {
		return nbrHabitant;
	}

	public void setNbrHabitant(int nbrHabitant) {
		this.nbrHabitant = nbrHabitant;
	}

	@Override
	public String toString() {
		return "Pays [numPays=" + numPays + ", nomPays=" + nomPays + ", nbrHabitant=" + nbrHabitant + "]";
	}
	
	
	
}
