package model;

/**
 * 
 * @author Daniel Lopes
 *
 *         The TVBox Object is the only one that does not extend from
 *         Entertainment because all of its attributes are different.
 * 
 */
public class TVBox {

	protected String title;
	protected int season;
	protected int numberOfDisks;
	protected String format;
	protected double price;
	protected boolean rented;
	protected String titleID;

	/*
	 * This constructor is used when I first create the TVBox object, It has no ID
	 * because the ID will be created automatically when inserted into the database.
	 */
	public TVBox(String title, int season, int numberOfDisks, double price, String format) {

		this.title = title;
		this.season = season;
		this.numberOfDisks = numberOfDisks;
		this.price = price;
		this.rented = false;
		this.format = format;
	}

	/*
	 * Once TVBox is inserted into the database I will have its ID, therefore I can
	 * query, get the ID from the database and therefore create an object that has
	 * the attribute ID.
	 */
	public TVBox(String title, int season, int numberOfDisks, double price, String titleID, String format) {

		this.title = title;
		this.season = season;
		this.numberOfDisks = numberOfDisks;
		this.price = price;
		this.rented = false;
		this.titleID = titleID;
		this.format = format;
	}

	public String getTitleID() {
		return titleID;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getNumberOfDisks() {
		return numberOfDisks;
	}

	public void setNumberOfDisks(int numberOfDisks) {
		this.numberOfDisks = numberOfDisks;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
