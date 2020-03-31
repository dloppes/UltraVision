package model;

public class Music extends Entertainment {

	protected String singer;

	public Music(int yearOfRelease, String title, String genre, boolean rented, String singer) {
		super(yearOfRelease, title, genre, rented);
		// TODO Auto-generated constructor stub
		
		this.singer = singer;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
