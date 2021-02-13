package com.abd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VEHICULE")
public class Vehicule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IMMATRICULATION")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int immatriculation;
	
	@Column(name = "COULEUR")
	private String couleur;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "NUMAG")
	private int numAgence;
	
	@Column(name = "NUMMOD")
	private int numModele;
	
	@Column(name = "NUMTYPE")
	private int numType;
	
	@Column(name = "NUMCAT")
	private int numcat;

	
	public Vehicule() {
		super();
	}

	public Vehicule(String couleur, int age, int numAgence, int numModele, int numType,
			int numcat) {
		super();
		this.couleur = couleur;
		this.age = age;
		this.numAgence = numAgence;
		this.numModele = numModele;
		this.numType = numType;
		this.numcat = numcat;
	}
	
	public Vehicule(int immatriculation, String couleur, int age, int numAgence, int numModele, int numType,
			int numcat) {
		super();
		this.immatriculation = immatriculation;
		this.couleur = couleur;
		this.age = age;
		this.numAgence = numAgence;
		this.numModele = numModele;
		this.numType = numType;
		this.numcat = numcat;
	}

	public int getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(int immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(int numAgence) {
		this.numAgence = numAgence;
	}

	public int getNumModele() {
		return numModele;
	}

	public void setNumModele(int numModele) {
		this.numModele = numModele;
	}

	public int getNumType() {
		return numType;
	}

	public void setNumType(int numType) {
		this.numType = numType;
	}

	public int getNumcat() {
		return numcat;
	}

	public void setNumcat(int numcat) {
		this.numcat = numcat;
	}

	@Override
	public String toString() {
		return "Vehicule [immatriculation=" + immatriculation + ", couleur=" + couleur + ", age=" + age + ", numAgence="
				+ numAgence + ", numModele=" + numModele + ", numType=" + numType + ", numcat=" + numcat
				+ "]";
	}

	
	
	
	
}
