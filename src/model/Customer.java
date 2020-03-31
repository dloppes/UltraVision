package model;

public class Customer {

	protected String fName;
	protected String lName;
	protected int phoneNumber;
	protected String email;
	protected String[] collection = new String[4];
	protected String membership;
	protected String cardNumber;
	protected String cardFunction;

	public Customer(String fName, String lName, int phoneNumber, String email, String[] collection, String membership,
			String cardNumber, String cardFunction) {

		this.collection = collection;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.membership = membership;
		this.cardNumber = cardNumber;
		this.cardFunction = cardFunction;
	}

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
		this.cardNumber = cardNumber;
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
		return membership;
	}

	public void setPlan(String membership) {
		this.membership = membership;
	}

	public String getCardFunction() {
		return cardFunction;
	}

	public void setCardFunction(String cardFunction) {
		this.cardFunction = cardFunction;
	}

}
