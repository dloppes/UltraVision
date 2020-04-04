package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connection {

	Statement stmt;

	public connection() {
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dbServer = "jdbc:mysql://apontejaj.com:3306/daniel?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "";
			String query = "SELECT * FROM user";

			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password);

			// Get a statement from the connection
			Statement stmt = conn.createStatement();

			// Execute the query
			ResultSet rs = stmt.executeQuery(query);

			// Loop through the result set
			while (rs.next()) {
				System.out.println(
						rs.getString("id") + "\t" + rs.getString("first_name") + "\t" + rs.getString("second_name"));
			}

			// Close the result set, statement and the connection
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public ResultSet executeQuery(String query) {

		try {
			ResultSet rs = stmt.executeQuery(query);

			return rs;
		} catch (SQLException ex) {
			Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);

			return null;
		}

	}

	public void ExecuteSet(String query) {
		try {
			stmt.execute(query);

		} catch (SQLException ex) {
			Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);

		}

	}
}