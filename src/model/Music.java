package model;

public class Music extends Entertainment {

	protected String singer;

	public Music(int yearOfRelease, String title, String genre, double price, String singer, String format) {
		super(yearOfRelease, title, genre, price, format);
		// TODO Auto-generated constructor stub

		this.singer = singer;
		this.rented = false;
		
		
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
