package model;

import interfaces.DVD;

public class TVBox implements DVD{
	
	protected String title;
	protected int season;
	protected int numberOfDisks;
	
	public TVBox(String title, int season, int numberOfDisks) {
		
		this.title = title;
		this.season = season;
		this.numberOfDisks = numberOfDisks;
	}

	@Override
	public void dvdFormat() {
		// TODO Auto-generated method stub
		
	}

}
