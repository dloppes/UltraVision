package model;

public class LiveConcert extends Entertainment{
	
	protected String band;
	
	public LiveConcert(int yearOfRelease, String title, String genre, String band) {
		
		this.band = band;
		this.yearOfRelease = yearOfRelease;
		this.title = title;
		this.genre = genre;
		
	}

	public String getBand() {
		return band;
	}
	
	public void setBand(String band) {
		this.band = band;
	}
}
