package model;

public class Music extends Entertainment {

	protected String singer;
	protected String musicID;

	public Music(int yearOfRelease, String title, String genre, double price, String singer, String format) {
		super(yearOfRelease, title, genre, price, format);
		// TODO Auto-generated constructor stub

		this.singer = singer;
		this.rented = false;
	}
	
	public Music(int yearOfRelease, String title, String genre, double price, String singer, String format, String musicID) {
		super(yearOfRelease, title, genre, price, format);
		// TODO Auto-generated constructor stub

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
