package hasAClasses;

public class Customer {
	
	private static int IDCount = 1000;
	
	private String nameSurname;
	private String address;
	private int custId;
	
	public Customer(String nameSurname, String address) {
		this.nameSurname = nameSurname;
		this.address = address;
		this.custId = IDCount++;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getItemId() {
		return custId;
	}

	public void setItemId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Customer Information:\nName Surname: " + nameSurname + "\nAddress: " + address + "\nCustomer Id:" + custId;
		
	}
	
	
}
