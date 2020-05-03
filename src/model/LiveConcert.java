package model;

/**
 * 
 * @author Daniel Lopes
 *
 *         The Live Concert Object extends all the attributes that belong to the
 *         Abstract class Entertainment and add up band, format and Live Concert
 *         ID that is particular to this class only
 */
public class LiveConcert extends Entertainment {

	protected String band;
	protected String format;
	protected String liveConcertID;

	/*
	 * This constructor is used when I first create the LiveConcert object, It has
	 * no ID because the ID will be created automatically when inserted into the
	 * database.
	 */
	public LiveConcert(int yearOfRelease, String title, String genre, double price, String band, String format) {
		super(yearOfRelease, title, genre, price, band);

		this.band = band;
		this.format = format;
	}

	/*
	 * Once LiveConcert is inserted into the database I will have its ID, therefore
	 * I can query, get the ID from the database and therefore create an object that
	 * has the attribute ID.
	 */
	public LiveConcert(int yearOfRelease, String title, String genre, double price, String band, String format,
			String liveConcertID) {
		super(yearOfRelease, title, genre, price, band);

		this.liveConcertID = liveConcertID;
		this.band = band;
		this.format = format;

	}

	public String getLiveConcertID() {
		return liveConcertID;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

}
