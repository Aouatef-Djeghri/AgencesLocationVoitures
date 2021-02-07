package com.abd.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="ETAT_CONTRAT")
public class EtatContrat implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ETATCONT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int etatCont;
	
	@Column(name = "LIBETATCONT")
	private String libEtatContart;

	public EtatContrat() {
		super();
	}

	public EtatContrat(String libEtatContart) {
		super();
		this.libEtatContart = libEtatContart;
	}
	
	public EtatContrat(int etatCont, String libEtatContart) {
		super();
		this.etatCont = etatCont;
		this.libEtatContart = libEtatContart;
	}

	public int getEtatCont() {
		return etatCont;
	}

	public void setEtatCont(int etatCont) {
		this.etatCont = etatCont;
	}

	public String getLibEtatContart() {
		return libEtatContart;
	}

	public void setLibEtatContart(String libEtatContart) {
		this.libEtatContart = libEtatContart;
	}

	@Override
	public String toString() {
		return "EtatContrat [etatCont=" + etatCont + ", libEtatContart=" + libEtatContart + "]";
	}

	
}
