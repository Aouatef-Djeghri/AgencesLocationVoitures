package com.abd.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMCLI")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numCli;
	
	@Column(name = "NOMCLI")
	private String nomCli;
	
	@Column(name = "PRENCLI")
	private String prenomCli;
	
	@Column(name = "ADRCLI")
	private String adresseCli;
	
	@Column(name = "NUMPREMIS")
	private int numPermis;
	
	@Column(name = "TELCLI")
	private int telCli;
	
	@Column(name = "VILLECPCLI")
	private int villeCli;

	
	public Client() {
		super();
	}

	public Client(String nomCli, String prenomCli, String adresseCli, int numPermis, int telCli,
			int villeCli) {
		super();
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.adresseCli = adresseCli;
		this.numPermis = numPermis;
		this.telCli = telCli;
		this.villeCli = villeCli;
	}
	
	public Client(int numCli, String nomCli, String prenomCli, String adresseCli, int numPermis, int telCli,
			int villeCli) {
		super();
		this.numCli = numCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.adresseCli = adresseCli;
		this.numPermis = numPermis;
		this.telCli = telCli;
		this.villeCli = villeCli;
	}

	public int getNumCli() {
		return numCli;
	}

	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getPrenomCli() {
		return prenomCli;
	}

	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}

	public String getAdresseCli() {
		return adresseCli;
	}

	public void setAdresseCli(String adresseCli) {
		this.adresseCli = adresseCli;
	}

	public int getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(int numPermis) {
		this.numPermis = numPermis;
	}

	public int getTelCli() {
		return telCli;
	}

	public void setTelCli(int telCli) {
		this.telCli = telCli;
	}

	public int getVilleCli() {
		return villeCli;
	}

	public void setVilleCli(int villeCli) {
		this.villeCli = villeCli;
	}

	@Override
	public String toString() {
		return "Client [numCli=" + numCli + ", nomCli=" + nomCli + ", prenomCli=" + prenomCli + ", adresseCli="
				+ adresseCli + ", numPermis=" + numPermis + ", telCli=" + telCli + ", villeCli=" + villeCli + "]";
	}
	
	
	
	
	
}
