package model;

public class Music extends Entertainment{
	
	protected String singer;
	
	public Music(int yearOfRelease, String title, String genre, String singer) {
		
		this.singer = singer;
		this.yearOfRelease = yearOfRelease;
		this.title = title;
		this.genre = genre;
		
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	

}
