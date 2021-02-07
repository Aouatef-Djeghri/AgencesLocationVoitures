package com.abd.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="VILLE")
public class Ville implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPCLI")
	private int codePostal;
	
	@Column(name = "VILLCLI")
	private String nomVille;
	
	public Ville() {
		super();
	}

	public Ville(int codePostal, String nomVille) {
		super();
		this.codePostal = codePostal;
		this.nomVille = nomVille;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	@Override
	public String toString() {
		return "Ville [codePostal=" + codePostal + ", nomVille=" + nomVille + "]";
	}
	
	
	
	
}
