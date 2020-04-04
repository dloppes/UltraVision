package model;

import interfaces.CD;

public class Music extends Entertainment implements CD{

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

	@Override
	public void cdFormat() {
		// TODO Auto-generated method stub
		
	}

}
