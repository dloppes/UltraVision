package model;

public class Customer {

	protected String fName;
	protected String lName;
	protected int phoneNumber;
	protected String email;
	protected String[] collection = new String[4];// object instead of string
	protected String plan;
	protected String cardNumber;
	protected Customer c;

	public Customer(String fName, String lName, int phoneNumber, String email, String[] collection, String plan,
			String cardNumber) {

		this.collection = collection;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.plan = plan;
		this.cardNumber = cardNumber;
		loyaltyCard mermbershipCard = new loyaltyCard(c);

	}
//-------------------------------------------------Inner Class - Loyalty Card -------------------------------------------------------------// 		
		public class loyaltyCard {

			Customer c; // instance of customer
			protected int points;
			protected boolean freeRentAllowed;

			public loyaltyCard(Customer c) { 
				// passing the object of c (customer) to attach it to the new card.
				this.c = c;
				points = 0; // zero value because it is a brand new card.

			}

			public void addPoints(int points) {

				this.points += points;

			}

			public boolean availFreeRent() {
				if (this.isfreeRentAllowed()) {
					this.points -= 100;
					setRentAllowed();
					return true;
				} else {
					return false;
				}
			}

			private void setRentAllowed() {
				if (this.points >= 100) {
					this.freeRentAllowed = true;
				} else {
					this.freeRentAllowed = false;
				}
			}

			public int getNumberOfPoints() {
				return points;
			}

			public boolean isfreeRentAllowed() {
				return freeRentAllowed;

			}

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
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

}
