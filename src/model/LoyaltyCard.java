package model;

public class LoyaltyCard {

	protected String customerEmail;
	protected int points;
	protected boolean freeRentAllowed;

	public LoyaltyCard(String customerEmail) {

		this.customerEmail = customerEmail;
		points = 0;

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
