package ChildAndParentClasses;

import hasAClasses.Publisher;

public class GameProduct extends Product {

	private static int IDCount = 300;
	private String supportedConsole;
	private String genre;
	private int year; 
	private String ageRating;
	private Publisher publisher;
	
	
	
	public GameProduct(int quantity, String name, double price, boolean secondHand,
			boolean rentable, String supportedConsole, String genre, int year, String ageRating, String pName, String pCountry) {
		super(IDCount++, quantity, name, price, secondHand, rentable); //assign a unique ID to each added game
		this.supportedConsole = supportedConsole;
		this.genre = genre;
		this.year = year;
		this.ageRating = ageRating;
		publisher = new Publisher(pName,pCountry);
	}


	@Override
	public String toString() {
		return "Game Product Information:\n" + super.toString() + "Supported Console: " + supportedConsole + ", \nGenre: " + genre + ", \nYear: "
				+ year + ", \nAge Rating: " + ageRating + "\n\n";
	}


	public String getSupportedConsole() {
		return supportedConsole;
	}




	public void setSupportedConsole(String supportedConsole) {
		this.supportedConsole = supportedConsole;
	}




	public String getGenre() {
		return genre;
	}




	public void setGenre(String genre) {
		this.genre = genre;
	}




	public int getYear() {
		return year;
	}




	public void setYear(int year) {
		this.year = year;
	}




	public String getAgeRating() {
		return ageRating;
	}




	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}
	
	
	@Override
	public void tax() {
		// TODO Auto-generated method stub
		
		price+=15;
		
	}
	
	
	
	
}
