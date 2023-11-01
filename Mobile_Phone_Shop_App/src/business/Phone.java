package business;

public class Phone {
	
	private int phoneID;
	private String name;
	private String brand;
	private int price;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public Phone(int phoneID, String name, String brand, int price) {
		this.phoneID = phoneID;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	

	public int getPhoneID() {
		return phoneID;
	}

	public void setPhoneID(int phoneID) {
		this.phoneID = phoneID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
}
