package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee {

	protected int employeeID;
	protected String fName;
	protected String lName;
	protected String username;
	protected String password;
	protected userLogged user;

	public Employee() {
	
	}
	public Employee(int employeeID, String fName, String lName, String username, String password) {
		this.employeeID = employeeID;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
	}

	public class employeeLogin {

		public boolean loginValidator(userLogged user) {
			
			connection conn = new connection();

			boolean login = false;

			String query = "SELECT * FROM employee WHERE username = '" + user.getUsername()
					+ "' AND password = '" + user.getPassword() + "';";

			ResultSet rs = conn.executeQuery(query);

			try {
				login = rs.next();
			} catch (SQLException ex) {
				Logger.getLogger(employeeLogin.class.getName()).log(Level.SEVERE, null, ex);
			}

			return login;
		}

	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
