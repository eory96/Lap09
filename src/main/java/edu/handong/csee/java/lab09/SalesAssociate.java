package edu.handong.csee.java.lab09;

public class SalesAssociate {
	
	private String name;
	private double sales;
	
	public void SalesAssociate() {
		this.name = null;
		this.sales = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSales(double sales) {
		this.sales = sales;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getSales() {
		return this.sales;
	}
}