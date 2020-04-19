package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {

	public class tvBoxClass {
		connection conn = new connection();

		public boolean insertNewTVBox(TVBox tvBox) {

			boolean newTVBox = false;
			// boolean rented=false;

			String query = "INSERT INTO TVBox (season, title, numberOfDisks, rented, price, format) " + "VALUES ( '"
					+ tvBox.getSeason() + "', '" + tvBox.getTitle() + "', '" + tvBox.getNumberOfDisks() + "', '"
					+ tvBox.rented + "', '" + tvBox.getPrice() + "', '" + tvBox.getFormat() + "');";

			newTVBox = conn.ExecuteSet(query);

			return newTVBox;
		}

	
	}

	public class liveConcertClass {
		connection conn = new connection();

		public boolean insertNewLiveConcert(LiveConcert liveConcert) {

			boolean newLiveConcert = false;
			// boolean rented=false;

			String query = "INSERT INTO liveConcert (yearOfRelease, title, genre, rented, band, price, format) "
					+ "VALUES ( '" + liveConcert.getYearOfRelease() + "', '" + liveConcert.getTitle() + "', '"
					+ liveConcert.getGenre() + "', '" + liveConcert.rented + "', '" + liveConcert.getBand() + "', '"
					+ liveConcert.getPrice() + "' , '" + liveConcert.getFormat() + "');";

			newLiveConcert = conn.ExecuteSet(query);

			return newLiveConcert;
		}

	}

	public class movieClass {
		connection conn = new connection();

		public boolean insertNewMovie(Movies movie) {

			boolean newMovie = false;
			// boolean rented=false;

			String query = "INSERT INTO movies (yearOfRelease, title, genre, rented, director, price, format) "
					+ "VALUES ( '" + movie.getYearOfRelease() + "', '" + movie.getTitle() + "', '" + movie.getGenre()
					+ "', '" + movie.rented + "', '" + movie.getDirector() + "', '" + movie.getPrice() + "' , '"
					+ movie.getFormat() + "');";

			newMovie = conn.ExecuteSet(query);

			return newMovie;
		}

	}

	public class musicClass {
		connection conn = new connection();

		public boolean insertNewMusic(Music music) {

			boolean newMusic = false;

			String query = "INSERT INTO music (yearOfRelease, title, genre, rented, singer, price, format) "
					+ "VALUES ( '" + music.getYearOfRelease() + "', '" + music.getTitle() + "', '" + music.getGenre()
					+ "', '" + music.rented + "', '" + music.getSinger() + "', '" + music.getPrice() + "' , '"
					+ music.getFormat() + "');";

			newMusic = conn.ExecuteSet(query);

			return newMusic;
		}

		public Music getMusicDetails(String musicID) {

			Music music;
			ResultSet rs;

			int yearOfRelease = 0;
			String title = "";
			String genre = "";
			String singer = "";
			double price = 0;
			String format = "";

			try {
				conn = new connection();

				String query = "Select * FROM music WHERE musicID = '" + musicID + "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					yearOfRelease = Integer.parseInt(rs.getString("fName"));
					title = rs.getString("lName");
					genre = rs.getString("email");
					singer = rs.getString("cardNumber");
					price = Double.parseDouble(rs.getString("phoneNumber"));
					format = rs.getString("plan");
				}
			} catch (Exception e) {
				System.out.println("SOmething went wrong");
			}

			music = new Music(yearOfRelease, title, genre, price, singer, format);

			return music;

		}

		public Music getMusicDetails() {

			Music music;
			ResultSet rs;

			int yearOfRelease = 0;
			String title = "";
			String genre = "";
			String singer = "";
			double price = 0;
			String format = "";
			boolean rented = false;

			try {
				conn = new connection();

				String query = "Select * FROM music WHERE rented = '" + rented + "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					yearOfRelease = Integer.parseInt(rs.getString("fName"));
					title = rs.getString("lName");
					genre = rs.getString("email");
					singer = rs.getString("cardNumber");
					price = Double.parseDouble(rs.getString("phoneNumber"));
					format = rs.getString("plan");
				}
			} catch (Exception e) {
				System.out.println("SOmething went wrong");
			}

			music = new Music(yearOfRelease, title, genre, price, singer, format);

			return music;

		}

	}

	public class customerClass {

		connection conn = new connection();

		public boolean insertNewCustomer(Customer customer) {

			boolean newCustomer = false;

			String query = "INSERT INTO customer (fName, lName, email, cardNumber, plan, phoneNumber) " + "VALUES ( '"
					+ customer.getfName() + "', '" + customer.getlName() + "', '" + customer.getEmail() + "', '"
					+ customer.getCardNumber() + "' , '" + customer.getPlan() + "', '" + customer.getPhoneNumber()
					+ "');";

			newCustomer = conn.ExecuteSet(query);

			return newCustomer;

		}

		public void newLoyaltyCard(Customer customer) {

			loyaltyCard mermbershipCard = new loyaltyCard(customer);
			int cardPoints = 0;
			int id = 0;

			String query = "SELECT customerID FROM customer WHERE email = '" + customer.getEmail() + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					id = rs.getInt("customerID");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			query = "INSERT INTO loyaltyCard (numberOfPoints, customerID) " + "VALUES ( '" + cardPoints + "', '" + id
					+ "');";

			conn.ExecuteSet(query);

		}

	}

	public class loyaltyCard {

		connection conn = new connection();

		Customer c; // instance of customer
		protected int points;
		protected boolean freeRentAllowed;

		public loyaltyCard(Customer c) {
			// passing the object of c (customer) to attach it to the new card.
			this.c = c;
			points = 0; // zero value because it is a brand new card.

		}

		public void addPoints(int points) {

			this.points += points;

		}

		public boolean availFreeRent() {
			if (this.isfreeRentAllowed()) {
				this.points -= 100;
				setRentAllowed();
				return true;
			} else {
				return false;
			}
		}

		private void setRentAllowed() {
			if (this.points >= 100) {
				this.freeRentAllowed = true;
			} else {
				this.freeRentAllowed = false;
			}
		}

		public int getNumberOfPoints() {
			return points;
		}

		public boolean isfreeRentAllowed() {
			return freeRentAllowed;

		}

	}

	public class updateCustomer {

		connection conn = new connection();

		public boolean updateCustomerDetails(Customer customer, String userID) {

			boolean updatedCustomer = false;

			String query = "UPDATE customer SET fName = '" + customer.getfName() + "', lName = '" + customer.getlName()
					+ "'," + "email = '" + customer.getEmail() + "', cardNumber = '" + customer.getCardNumber()
					+ "', plan = '" + customer.getPlan() + "', phoneNumber = '" + customer.getPhoneNumber() + "'"
					+ "WHERE customerID='" + userID + "';";

			updatedCustomer = conn.ExecuteSet(query);

			return updatedCustomer;

		}

	}

	public int getCardPoints(String email) {
		connection conn = new connection();

		int cardPoints = 0;
		int id = 0;

		String query = "SELECT customerID FROM customer WHERE email = '" + email + "'";
		ResultSet rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				id = rs.getInt("customerID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		query = "SELECT numberOfPoints FROM loyaltyCard WHERE loyaltyCardID = '" + id + "'";
		rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				cardPoints = rs.getInt("numberOfPoints");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cardPoints;

	}

}
