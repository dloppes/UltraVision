package model;

public class TVBox {

	protected String title;
	protected int season;
	protected int numberOfDisks;
	protected Format format = Format.DVD;

	public TVBox(String title, int season, int numberOfDisks) {

		this.title = title;
		this.season = season;
		this.numberOfDisks = numberOfDisks;
	}

}
