package model;

/**
 * 
 * @author Daniel Lopes
 *
 *         This object UserLogged is called and used to verify that the inserts
 *         by the employee is correct. It is assigned with the information typed
 *         on the login page.
 */
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
