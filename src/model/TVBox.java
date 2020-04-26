package model;

import interfaces.Format;

public class TVBox {

	protected String title;
	protected int season;
	protected int numberOfDisks;
	protected String format;
	protected double price;
	protected boolean rented;
	protected String titleID;

	public TVBox(String title, int season, int numberOfDisks, double price, String format) {

		this.title = title;
		this.season = season;
		this.numberOfDisks = numberOfDisks;
		this.price = price;
		this.rented=false;
		this.format = format;
	}
	
	public TVBox(String title, int season, int numberOfDisks, double price, String titleID, String format) {

		this.title = title;
		this.season = season;
		this.numberOfDisks = numberOfDisks;
		this.price = price;
		this.rented=false;
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
