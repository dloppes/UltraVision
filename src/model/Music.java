package model;

/**
 * 
 * @author Daniel Lopes
 *
 *         The Music Object extends all the attributes that belong to the
 *         Abstract class Entertainment and add musicID and singer that is
 *         particular to this class only
 */
public class Music extends Entertainment {

	protected String singer;
	protected String musicID;

	/*
	 * This constructor is used when I first create the Music object, It has no ID
	 * because the ID will be created automatically when inserted into the database.
	 */
	public Music(String yearOfRelease, String title, String genre, double price, String singer, String format) {
		super(yearOfRelease, title, genre, price, format);

		this.singer = singer;
		this.rented = false;
	}

	/*
	 * Once Music is inserted into the database I will have its ID, therefore I can
	 * query, get the ID from the database and therefore create an object that has
	 * the attribute ID.
	 */
	public Music(String yearOfRelease, String title, String genre, double price, String singer, String format,
			String musicID) {
		super(yearOfRelease, title, genre, price, format);

		this.singer = singer;
		this.rented = false;
		this.musicID = musicID;

	}

	public String getMusicID() {
		return musicID;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
