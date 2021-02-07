package com.abd.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="AGENCE")
public class Agence implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="NUMAG")
	private int numAg;
	
	@Column(name ="NOMAG")
	private String nomAg;
	
	@Column(name ="NBREMPLOYES")
	private int nbrEmplyes;
	
	@Column(name ="PAYSNUMPAY")
	private int numPays;
	
	public Agence() {
		super();
	}

	public Agence(String nomAg, int nbrEmplyes, int numPays) {
		super();
		this.nomAg = nomAg;
		this.nbrEmplyes = nbrEmplyes;
		this.numPays = numPays;
	}
	
	public Agence(int numAg, String nomAg, int nbrEmplyes, int numPays) {
		super();
		this.numAg = numAg;
		this.nomAg = nomAg;
		this.nbrEmplyes = nbrEmplyes;
		this.numPays = numPays;
	}


	public int getNumAg() {
		return numAg;
	}

	public void setNumAg(int numAg) {
		this.numAg = numAg;
	}

	public String getNomAg() {
		return nomAg;
	}

	public void setNomAg(String nomAg) {
		this.nomAg = nomAg;
	}

	public int getNbrEmplyes() {
		return nbrEmplyes;
	}

	public void setNbrEmplyes(int nbrEmplyes) {
		this.nbrEmplyes = nbrEmplyes;
	}

	public int getNumPays() {
		return numPays;
	}

	public void setNumPays(int numPays) {
		this.numPays = numPays;
	}
	

	@Override
	public String toString() {
		return "Agence [numAg=" + numAg + ", nomAg=" + nomAg + ", nbrEmplyes=" + nbrEmplyes + ", numPays=" + numPays
				+ "]";
	}
}
