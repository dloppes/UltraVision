package model;

/**
 * 
 * @author Daniel Lopes
 *
 *         This abstract class has all the attributes that are common amongst
 *         all titles. They will be able to extend it and add any other
 *         attribute that is particular to that object.
 */
public abstract class Entertainment {

	protected int yearOfRelease;
	protected String title;
	protected String genre;
	protected boolean rented = false;
	protected double price;
	protected String format;

	public Entertainment(int yearOfRelease, String title, String genre, double price, String format) {

		this.yearOfRelease = yearOfRelease;
		this.title = title;
		this.genre = genre;
		this.rented = false;
		this.price = price;
		this.format = format;
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

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

}
