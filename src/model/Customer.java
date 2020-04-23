package model;

public class Customer {

	protected Membership membership;
	protected String fName;
	protected String lName;
	protected String phoneNumber;
	protected String email;
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

	// constructor that has the ID
	public Customer(String fName, String lName, String phoneNumber, String email, String plan, String cardNumber,
			String customerID) {

		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.plan = plan;
		this.cardNumber = cardNumber;
		this.customerID = customerID;
	}

//------------------------------------------------------------------------------------------------------------------------------------------//	

	public boolean validateMusicPlan(Customer customer) {

		boolean validMembership = false;

		if (customer.getPlan().toString().equalsIgnoreCase("ML")
				|| customer.getPlan().toString().equalsIgnoreCase("PR")) {

			return validMembership = true;
		} else {
			return validMembership;
		}

	}

	public boolean validateMoviePlan(Customer customer) {

		boolean validMembership = false;

		if (customer.getPlan().toString().equalsIgnoreCase("VL")
				|| customer.getPlan().toString().equalsIgnoreCase("PR")) {

			return validMembership = true;
		} else {
			return validMembership;
		}

	}

	public boolean validateTVBoxPlan(Customer customer) {

		boolean validMembership = false;

		if (customer.getPlan().toString().equalsIgnoreCase("TV")
				|| customer.getPlan().toString().equalsIgnoreCase("PR")) {

			return validMembership = true;
		} else {
			return validMembership;
		}

	}

	public boolean validateLiveConcertPlan(Customer customer) {

		boolean validMembership = false;

		if (customer.getPlan().toString().equalsIgnoreCase("ML")
				|| customer.getPlan().toString().equalsIgnoreCase("PR")) {

			return validMembership = true;
		} else {
			return validMembership;
		}

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

	public void setCardNumber(String cardNumber) {
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

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getCustomerID() {
		return customerID;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

}
