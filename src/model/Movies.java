package model;

/**
 * 
 * @author Daniel Lopes
 *
 *         The Movie Object extends all the attributes that belong to the
 *         Abstract class Entertainment and add director, format and movieID
 *         that is particular to this class only
 */
public class Movies extends Entertainment {

	private String director;
	private String format;
	private String movieID;

	/*
	 * This constructor is used when I first create the Movie object, It has no ID
	 * because the ID will be created automatically when inserted into the database.
	 */
	public Movies(int yearOfRelease, String title, String genre, double price, String director, String format) {
		super(yearOfRelease, title, genre, price, director);

		this.director = director;
		this.format = format;
	}

	/*
	 * Once Movie is inserted into the database I will have its ID, therefore I can
	 * query, get the ID from the database and therefore create an object that has
	 * the attribute ID.
	 */
	public Movies(int yearOfRelease, String title, String genre, double price, String director, String format,
			String movieID) {
		super(yearOfRelease, title, genre, price, director);

		this.movieID = movieID;
		this.director = director;
		this.format = format;

	}

	public String getMovieID() {
		return movieID;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
