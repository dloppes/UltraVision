package model;

import javax.swing.JOptionPane;

/**
 * 
 * @author Daniel Lopes
 *
 *         Customer object and all of particular methods for Customer
 */
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

	/*
	 * This constructor is used when I first create the customer object, It has no
	 * ID because the ID will be created automatically when inserted into the
	 * database.
	 */
	public Customer(String fName, String lName, String phoneNumber, String email, String plan, String cardNumber) {

		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.plan = plan;
		this.cardNumber = cardNumber;

	}

	/*
	 * Once the customer is inserted into the database I will have an ID, therefore
	 * I can query and get the ID from the system.
	 */
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

	public int totalPointsEarned() {

		/*
		 * This method gets the total of points that the customer is due for shopping
		 * titles - 10 points per titles and returns the integer.
		 */
		int totalPointsEarned = Integer.parseInt(
				JOptionPane.showInputDialog("Please insert how many points this customer earned in this transaction"));

		return totalPointsEarned;
	}

	public double totalDiscount() {

		/*
		 * This method gets the total of discount that the customer is due for having
		 * reached 100 points on his loyaltyCard
		 */

		double finalDiscount = Double.parseDouble(
				JOptionPane.showInputDialog("Please insert how much is the discount due to this customer"));

		return finalDiscount;
	}

	public double totalToPay(double priceTitle, double priceScreen, double discount) {

		/*
		 * This method gets three variables, title price, screen price (which could be
		 * zero if first shop or the previous title price) and discount and returns the
		 * result of it.
		 */

		return priceTitle + priceScreen - discount;

	}

	public int totalNumberOfTitlesRented(Customer customer) {

		/*
		 * method to go through database and check with every table how many titles that
		 * customer has rented already
		 */

		Queries queries = new Queries();
		Queries.liveConcertClass totalLiveConcertTitlesRented = queries.new liveConcertClass();
		Queries.musicClass totalMusicTitlesRented = queries.new musicClass();
		Queries.tvBoxClass totalTVBoxTitlesRented = queries.new tvBoxClass();
		Queries.movieClass totalMovieTitlesRented = queries.new movieClass();

		int totalLiveConcert = totalLiveConcertTitlesRented.numberOfLiveConcertRented(customer);
		int totalMusic = totalMusicTitlesRented.numberOfMusicRented(customer);
		int totalTVBox = totalTVBoxTitlesRented.numberOfTVBoxRented(customer);
		int totalMovie = totalMovieTitlesRented.numberOfMovieRented(customer);

		int count = totalLiveConcert + totalMusic + totalTVBox + totalMovie;

		return count; // it returns the total amount rented in the 4 tables.

	}

	public boolean validateMusicPlan(Customer customer) {
		/*
		 * Simply validates if the customer can rent music Titles, He has to be ML
		 * (plan) or Premium
		 */
		boolean validMembership = false;

		if (customer.getPlan().toString().equalsIgnoreCase("ML")
				|| customer.getPlan().toString().equalsIgnoreCase("PR")) {

			return validMembership = true;
		} else {
			return validMembership;
		}

	}

	public boolean validateMoviePlan(Customer customer) {
		/*
		 * Simply validates if the customer can rent movie Titles, He has to be VL
		 * (plan) or Premium
		 */
		boolean validMembership = false;

		if (customer.getPlan().toString().equalsIgnoreCase("VL")
				|| customer.getPlan().toString().equalsIgnoreCase("PR")) {

			return validMembership = true;
		} else {
			return validMembership;
		}

	}

	public boolean validateTVBoxPlan(Customer customer) {
		/*
		 * Simply validates if the customer can rent TVBox Titles, He has to be TV
		 * (plan) or Premium
		 */
		boolean validMembership = false;

		if (customer.getPlan().toString().equalsIgnoreCase("TV")
				|| customer.getPlan().toString().equalsIgnoreCase("PR")) {

			return validMembership = true;
		} else {
			return validMembership;
		}

	}

	public boolean validateLiveConcertPlan(Customer customer) {
		/*
		 * Simply validates if the customer can rent music Live Concert, He has to be ML
		 * (plan) or Premium
		 */
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
