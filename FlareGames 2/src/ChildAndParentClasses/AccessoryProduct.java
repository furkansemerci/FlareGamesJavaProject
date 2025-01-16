package ChildAndParentClasses;


public class AccessoryProduct extends Product{
	
	
	private static int IDCount = 500;
	
	private String type;
	private String brand;
	private boolean original;
	
	
	public AccessoryProduct(int quantity, String name, double price, boolean secondHand,
			boolean rentable, String type, String brand, boolean original) {
		super(IDCount++, quantity, name, price, secondHand, rentable);
		this.type = type;
		this.brand = brand;
		this.original = original;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}
	
	@Override
	public String toString() {
		String yn = "";
		if (original==true) {
			yn="It is orginal accessory product";
		}
		else {
			yn="It is not original product";
		}
		return  "Accessory Information:\n"
				+ super.toString()
				+ "Type: " + type 
				+ "\nBrand: " + brand 
				+ "\nOriginal: " + yn + "\n\n";
	}

	@Override
	public void tax() {
		// TODO Auto-generated method stub
		
		price+=5;
		
	}
	
}
