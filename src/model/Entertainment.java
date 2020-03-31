package model;

public abstract class Entertainment {

	protected int yearOfRelease;
	protected String title;
	protected String genre;
	protected boolean rented = false;
	
	public Entertainment(int yearOfRelease, String title, String genre, boolean rented) {
		
		this.yearOfRelease = yearOfRelease;
		this.title = title;
		this.genre = genre;
		this.rented = rented;
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
