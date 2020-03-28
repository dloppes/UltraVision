package model;

public class Customer {
	
	protected String name;
	protected int phoneNumber;
	protected String email;
	protected String[] collection = new String[4];
	protected String plan;
	
	public Customer(String name, int phoneNumber, String email, String[] collection, String plan) {
		
		this.collection = collection;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.plan = plan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getCollection() {
		return collection;
	}

	public void setCollection(String[] collection) {
		this.collection = collection;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	
}
