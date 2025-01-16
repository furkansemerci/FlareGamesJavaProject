package hasAClasses;


public class Publisher {
	private String publisherName;
	private String country;
	
	public Publisher(String name, String country)
	{
		this.publisherName=name;
		this.country=country;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Publisher "
				+ "\nPublisher Name: " + publisherName 
				+ "\nCountry: " + country + "\n";
	}
	
	
}
