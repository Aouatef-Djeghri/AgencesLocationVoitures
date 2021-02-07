package com.abd.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="CONTRAT")
public class Contrat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="NUMCONTR")
	private int numContrat;
	
	@Column(name ="DATEDCONTR")
	private Date datDContrat;
	
	@Column(name ="DATEFCONTR")
	private Date datFContrat;
	
	@Column(name ="CAUTION")
	private int caution;
	
	@Column(name ="KMDEP")
	private int kmDep;
	
	@Column(name ="KMRET")
	private int kmRet;
	
	@Column(name ="ETATCONT")
	private int etatContrat;
	
	@Column(name ="NUMCLI")
	private int numClient;
	
	@Column(name ="VEHICULEIMMATRICULATION")
	private int vehiculeImmatriculation;
	
	@Column(name ="MODELOCATION")
	private String modeLocation;

	public Contrat() {
		super();
	}
	
	public Contrat(Date datDContrat, Date datFContrat, int caution, int kmDep, int kmRet,
			int etatContrat, int numClient, int vehiculeImmatriculation, String modeLocation) {
		super();
		this.datDContrat = datDContrat;
		this.datFContrat = datFContrat;
		this.caution = caution;
		this.kmDep = kmDep;
		this.kmRet = kmRet;
		this.etatContrat = etatContrat;
		this.numClient = numClient;
		this.vehiculeImmatriculation = vehiculeImmatriculation;
		this.modeLocation = modeLocation;
	}


	public Contrat(int numContrat, Date datDContrat, Date datFContrat, int caution, int kmDep, int kmRet,
			int etatContrat, int numClient, int vehiculeImmatriculation, String modeLocation) {
		super();
		this.numContrat = numContrat;
		this.datDContrat = datDContrat;
		this.datFContrat = datFContrat;
		this.caution = caution;
		this.kmDep = kmDep;
		this.kmRet = kmRet;
		this.etatContrat = etatContrat;
		this.numClient = numClient;
		this.vehiculeImmatriculation = vehiculeImmatriculation;
		this.modeLocation = modeLocation;
	}


	public int getNumContrat() {
		return numContrat;
	}


	public void setNumContrat(int numContrat) {
		this.numContrat = numContrat;
	}


	public Date getDatDContrat() {
		return datDContrat;
	}


	public void setDatDContrat(Date datDContrat) {
		this.datDContrat = datDContrat;
	}


	public Date getDatFContrat() {
		return datFContrat;
	}


	public void setDatFContrat(Date datFContrat) {
		this.datFContrat = datFContrat;
	}


	public int getCaution() {
		return caution;
	}


	public void setCaution(int caution) {
		this.caution = caution;
	}


	public int getKmDep() {
		return kmDep;
	}


	public void setKmDep(int kmDep) {
		this.kmDep = kmDep;
	}




	public int getKmRet() {
		return kmRet;
	}


	public void setKmRet(int kmRet) {
		this.kmRet = kmRet;
	}


	public int getEtatContrat() {
		return etatContrat;
	}


	public void setEtatContrat(int etatContrat) {
		this.etatContrat = etatContrat;
	}


	public int getNumClient() {
		return numClient;
	}


	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}


	public int getVehiculeImmatriculation() {
		return vehiculeImmatriculation;
	}


	public void setVehiculeImmatriculation(int vehiculeImmatriculation) {
		this.vehiculeImmatriculation = vehiculeImmatriculation;
	}


	public String getModeLocation() {
		return modeLocation;
	}


	public void setModeLocation(String modeLocation) {
		this.modeLocation = modeLocation;
	}


	@Override
	public String toString() {
		return "Contrat [numContrat=" + numContrat + ", datDContrat=" + datDContrat + ", datFContrat=" + datFContrat
				+ ", caution=" + caution + ", kmDep=" + kmDep + ", kmRet=" + kmRet + ", etatContrat=" + etatContrat
				+ ", numClient=" + numClient + ", vehiculeImmatriculation=" + vehiculeImmatriculation
				+ ", modeLocation=" + modeLocation + "]";
	}
	
}
