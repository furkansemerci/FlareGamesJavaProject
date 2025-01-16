package ChildAndParentClasses;

public class ConsoleProduct extends Product {

	private static int IDCount = 100;
	private String brand;
	private int generation;
	private boolean fixed;
	private String color;


	
	public ConsoleProduct(int quantity, String name, double price, boolean secondHand,
			boolean rentable, String brand, int generation, boolean fixed, String color) {
		super(IDCount++, quantity, name, price, secondHand, rentable);
		this.brand = brand;
		this.generation = generation;
		this.fixed = fixed;
		this.color = color;
	}



	@Override
	public String toString() {
		
		String res="";
		if(fixed)
			res += "Yes";
		else
			res+= "No";
		
		return "Console Product Information:\n" + super.toString() + "Brand: " + brand + ", \nGeneration: " + generation + ", \nFixed: " + res
				+ ", \nColor: " + color + "\n\n";
	}



	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public int getGeneration() {
		return generation;
	}


	public void setGeneration(int generation) {
		this.generation = generation;
	}


	public boolean isFixed() {
		return fixed;
	}


	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void tax() {
		// TODO Auto-generated method stub
		
		price+=10;
		
	}
	
}
	
