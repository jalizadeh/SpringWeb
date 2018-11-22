package com.jalizadeh.springweb.model;

public class Car {
	private int carid;
	private String manufacturer;
	private int model;
	
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Car [carid=" + carid + ", manufacturer=" + manufacturer + ", model=" + model + "]";
	}
	
	
}
