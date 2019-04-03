package com.ssi;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int pcode;
	private String pname;
	private int price;
	private Blob picture;
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	
	
	
}
