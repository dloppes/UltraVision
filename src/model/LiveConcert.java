package model;

public class LiveConcert extends Entertainment {

	protected String band;
	protected Format format = Format.BLURAY;

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

}
