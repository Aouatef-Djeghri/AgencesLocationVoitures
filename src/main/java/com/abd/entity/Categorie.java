package com.abd.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CATEGORIE")
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="NUMCAT")
	private int numCat;
	
	@Column(name ="LIBCAT")
	private String libCat;

	
	public Categorie() {
		super();
	}

	public Categorie(String libCat) {
		super();
		this.libCat = libCat;
	} 
	
	public Categorie(int numCat, String libCat) {
		super();
		this.numCat = numCat;
		this.libCat = libCat;
	}

	public int getNumCat() {
		return numCat;
	}

	public void setNumCat(int numCat) {
		this.numCat = numCat;
	}

	public String getLibCat() {
		return libCat;
	}

	public void setLibCat(String libCat) {
		this.libCat = libCat;
	}

	@Override
	public String toString() {
		return "Categorie [numCat=" + numCat + ", libCat=" + libCat + "]";
	}
	
}
