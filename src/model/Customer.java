package model;

public class Customer {

	protected Membership membership;
	protected String fName;
	protected String lName;
	protected String phoneNumber;
	protected String email;
	protected Object[] collection = new Object[4];// object instead of string
	protected String plan;
	protected String cardNumber;
	protected String customerID;
	protected Customer c;

	public Customer(String fName, String lName, String phoneNumber, String email, String plan, String cardNumber) {

		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.plan = plan;
		this.cardNumber = cardNumber;

	}


//------------------------------------------------------------------------------------------------------------------------------------------//	

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public boolean validateCardNumber(String cardNumber) {

		if (!cardNumber.matches("[0-9]+")) {

			System.out.println("Invalid card details. ONLY NUMBERS AREA ACCEPTED");
			return false;
		}

		int cardlength = cardNumber.length();

		if (cardlength != 16) {
			System.out.println("It is missing numbers, please insert the 16 numbers required for a valid card!");
			return false;
		}

		else {
			return true;
		}

	}

	public void setCardNumber(String cardNumber) {
		if (validateCardNumber(cardNumber) == true)
			this.cardNumber = cardNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Object[] getCollection() {
		return collection;
	}

	public void setCollection(Object[] collection) {
		this.collection = collection;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
