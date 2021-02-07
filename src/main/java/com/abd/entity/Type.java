package com.abd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TYPE")
public class Type implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMTYPE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numType;
	
	@Column(name = "LIBTYPE")
	private String libType;
	
	public Type() {
		super();
	}

	public Type( String libType) {
		super();
		this.libType = libType;
	}
	
	public Type(int numType, String libType) {
		super();
		this.numType = numType;
		this.libType = libType;
	}

	public int getNumType() {
		return numType;
	}

	public void setNumType(int numType) {
		this.numType = numType;
	}

	public String getLibType() {
		return libType;
	}

	public void setLibType(String libType) {
		this.libType = libType;
	}

	@Override
	public String toString() {
		return "Type [numType=" + numType + ", libType=" + libType + "]";
	}

}
