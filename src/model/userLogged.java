package model;

public class userLogged {
	
	protected String username;
	protected String password;
	
	public userLogged(String username, String password) {
		
		this.username = username;
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	

}
