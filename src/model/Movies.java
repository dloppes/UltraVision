package model;

import interfaces.DVD;

public class Movies extends Entertainment implements DVD {

	private String director;

	public Movies(int yearOfRelease, String title, String genre, boolean rented, String director) {
		super(yearOfRelease, title, genre, rented);
		// TODO Auto-generated constructor stub

		this.director = director;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public void dvdFormat() {
		// TODO Auto-generated method stub

	}

}
