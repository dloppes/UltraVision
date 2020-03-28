package model;

public class Movies extends Entertainment {

	private String director;

	public Movies(int yearOfRelease, String title, String genre, String director) {

		this.director = director;
		this.yearOfRelease = yearOfRelease;
		this.title = title;
		this.genre = genre;

	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
