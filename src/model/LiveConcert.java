package model;

import interfaces.BluRay;

public class LiveConcert extends Entertainment implements BluRay{
	
	protected String band;
	
	public LiveConcert(int yearOfRelease, String title, String genre, boolean rented, String band) {
		super(yearOfRelease, title, genre, rented);
		// TODO Auto-generated constructor stub
		
		this.band = band;
	}
	
	
	public String getBand() {
		return band;
	}
	
	public void setBand(String band) {
		this.band = band;
	}


	@Override
	public void bluRayFormat() {
		// TODO Auto-generated method stub
		
	}
}
