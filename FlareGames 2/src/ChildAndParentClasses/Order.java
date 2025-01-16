package ChildAndParentClasses;

import Interface.OrderInterface;
import hasAClasses.*;

public class Order implements OrderInterface{
	
	private static int IDCount = 2000; //Start from 2000, increment with each new order
	
	private int orderId;
	private Product product = null;
	private Customer customer = null;
	private double shippingFee;
	
	public Order(Product p, Customer cust)
	{
		product = p;
		customer = cust;
		orderId=IDCount++;
		calculateShippingFee();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Override
	public String toString() {
		return "Order Information:"
				+ "\nOrder Id: " 
				+ orderId + "\n"
				+ "Product name: " + product.getName() + "\n"
				+ "Product Price: $" + product.getPrice() + "\n"
 				+ customer.toString()
				+ "\nShipping Fee: " + shippingFee + "\n\n"
				+ "Total Price: " + getTotalPrice() + "\n\n";
	}
	
	public void calculateShippingFee()
	{
		if(customer.getAddress().contains("Trabzon"))
			shippingFee=100;
		
		else if(customer.getAddress().contains("Tekirdağ"))
			shippingFee=75;
		
		else if(customer.getAddress().contains("Muğla"))
			shippingFee=150;
		
		else if(customer.getAddress().contains("Aksaray"))
			shippingFee=50;
		
		else 
			shippingFee=200;
	}

	public boolean eligibleForDiscount() {  //IDs starting with 1 are all consoles
		
		String str = "" + product.getId();
		
		int initial = Integer.parseInt(str.substring(0, 1));
		
		if(initial == 1)
		 return true;
		
		return false;
		
	}
	
	public double getTotalPrice() {
		
		double sum=product.getPrice();
		
		if(eligibleForDiscount())
			sum-=sum*.1;
		 
		return sum+shippingFee;
		
	}
	
}
