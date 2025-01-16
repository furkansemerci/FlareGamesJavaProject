package ChildAndParentClasses;
import Interface.*;

public abstract class Product {
	
	protected int id, quantity;
	protected String name;
	protected double price;
	protected boolean secondHand,rentable;
	protected static int numOfItems = 0;
	
	
	public Product(int id, int quantity, String name, double price, boolean secondHand,
			boolean rentable) {
		this.id = id;
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.secondHand = secondHand;
		this.rentable = rentable;
		numOfItems++;
	}
	
	
	public void incrementQuantity(int quantity) {
		this.quantity +=quantity;
	}

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}



	public boolean isSecondHand() {
		return secondHand;
	}




	public void setSecondHand(boolean secondHand) {
		this.secondHand = secondHand;
	}




	public boolean isRentable() {
		return rentable;
	}




	public void setRentable(boolean rentable) {
		this.rentable = rentable;
	}




	public static int getNumOfItems() {
		return numOfItems;
	}




	public static void setNumOfItems(int numOfItems) {
		Product.numOfItems = numOfItems;
	}




	@Override
	public String toString() {
		String res = "";
		
		res+="Item ID: " + id + "\nItem Name : " + name + "\nQuantity: " + quantity +
		"\nPrice: " + price + "\nStatus: ";
		
		if(secondHand)
			res += "Second Hand\n";
		
		else
			res += "New\n";
		
		res += "Rentability: ";
		
		if(!rentable)
			res += "Not ";
		
		res += "Rentable\n";
		 
		
		return res;
	}

	public boolean decrementQuantity() {
		
		if(getQuantity()< 1)
			return false;
		
		setQuantity(getQuantity()-1);
		return true;
		
	}
	
	public abstract void tax();
	

	
}
