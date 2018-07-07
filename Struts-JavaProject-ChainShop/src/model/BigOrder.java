package model;

import java.util.ArrayList;

public class BigOrder {
	private ArrayList<Order> singleorders;
	private Order order;
	private double totalprice;
	
	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public ArrayList<Order> getSingleorders() {
		return singleorders;
	}

	public void setSingleorders(ArrayList<Order> singleorders) {
		this.singleorders = singleorders;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
