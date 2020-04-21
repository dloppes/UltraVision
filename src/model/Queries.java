package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

		public String[][] getAvailableTVBox() {

			boolean rented = false;
			int row = 0;
			String[] columnNames = new String[] { "Title ID", "Title", "Season", "Number of Disks", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			String query = "Select * FROM TVBox WHERE rented = '" + rented + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					data[row][0] = rs.getString("titleID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("season");
					data[row][3] = rs.getString("numberOfDisks");
					data[row][4] = rs.getString("format");
					data[row][5] = rs.getString("price");

					row++;

				}

			} catch (Exception e) {

			}

			return data;

		}

		public String[][] getRentedTVBox() {

			boolean rented = false;
			int row = 0;
			String[] columnNames = new String[] { "Title ID", "Title", "Season", "Number of Disks", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			String query = "Select * FROM TVBox WHERE rented = '" + rented + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					data[row][0] = rs.getString("titleID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("season");
					data[row][3] = rs.getString("numberOfDisks");
					data[row][4] = rs.getString("format");
					data[row][5] = rs.getString("price");

					row++;

				}

			} catch (Exception e) {

			}

			return data;

		}
		
		public TVBox searchTVBoxTitle(String tvBoxTitle) {

			ResultSet rs = null;
			int titleID = 0;
			String title="";
			String format = "";
			int numberOfDisks=0;
			double price = 0;
			int season = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM TVBox WHERE  title = '" + tvBoxTitle + "' AND rented = '" + rented +  "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					titleID = Integer.parseInt(rs.getString("titleID"));
					season = Integer.parseInt(rs.getString("season"));
					title = rs.getString("title");
					price = Double.parseDouble(rs.getString("price"));
					format = rs.getString("format");
					numberOfDisks = Integer.parseInt(rs.getString("numberOfDisks"));
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Title you are looking for is not available at the moment");
			}

			 TVBox tvBox = new TVBox(  title,  season,  numberOfDisks,  price);
			return tvBox;
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

		public String[][] getAvailableLiveConcert() {

			boolean rented = false;
			int row = 0;
			String[] columnNames = new String[] { "Band ID", "Title", "Band", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			String query = "Select * FROM liveConcert WHERE rented = '" + rented + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					data[row][0] = rs.getString("bandID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("band");
					data[row][3] = rs.getString("genre");
					data[row][4] = rs.getString("format");
					data[row][5] = rs.getString("price");

					row++;

				}

			} catch (Exception e) {

			}

			return data;

		}

		public String[][] getRentedLiveConcert() {

			boolean rented = false;
			int row = 0;
			String[] columnNames = new String[] { "Band ID", "Title", "Band", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			String query = "Select * FROM liveConcert WHERE rented = '" + rented + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					data[row][0] = rs.getString("bandID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("band");
					data[row][3] = rs.getString("genre");
					data[row][4] = rs.getString("format");
					data[row][5] = rs.getString("price");

					row++;

				}

			} catch (Exception e) {

			}

			return data;

		}
		
		public LiveConcert searchLiveConcertTitle(String liveTitle) {

			ResultSet rs = null;
			int bandID = 0;
			String title = "";
			String band = "";
			String genre = "";
			String format = "";
			double price = 0;
			int yearOfRelease = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM liveConcert WHERE  title = '" + liveTitle + "' AND rented = '" + rented +  "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					bandID = Integer.parseInt(rs.getString("bandID"));
					yearOfRelease = Integer.parseInt(rs.getString("yearOfRelease"));
					title = rs.getString("title");
					genre = rs.getString("genre");
					band = rs.getString("band");
					price = Double.parseDouble(rs.getString("price"));
					format = rs.getString("format");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Title you are looking for is not available at the moment");
			}

			 LiveConcert liveConcert = new LiveConcert( yearOfRelease,  title,  genre,  price,  band,  format);
			return liveConcert;
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

		public String[][] getAvailableMovie() {

			boolean rented = false;
			int row = 0;
			String[] columnNames = new String[] { "Movie ID", "Title", "Director", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			String query = "Select * FROM movies WHERE rented = '" + rented + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {

					data[row][0] = rs.getString("movieID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("director");
					data[row][3] = rs.getString("genre");
					data[row][4] = rs.getString("format");
					data[row][5] = rs.getString("price");

					row++;

				}

			} catch (Exception e) {

			}

			return data;

		}

		public String[][] getRentedMovie() {

			boolean rented = false;
			int row = 0;
			String[] columnNames = new String[] { "Music ID", "Title", "Singer", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			String query = "Select * FROM music WHERE rented = '" + rented + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {

					data[row][0] = rs.getString("musicID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("singer");
					data[row][3] = rs.getString("genre");
					data[row][4] = rs.getString("format");
					data[row][5] = rs.getString("price");

					row++;

				}

			} catch (Exception e) {

			}

			return data;

		}
		
		public Movies searchMovieTitle(String movieTitle) {

			ResultSet rs = null;
			int movieID = 0;
			String title = "";
			String director = "";
			String genre = "";
			String format = "";
			double price = 0;
			int yearOfRelease = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM movies WHERE  title = '" + movieTitle + "' AND rented = '" + rented +  "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					movieID = Integer.parseInt(rs.getString("movieID"));
					yearOfRelease = Integer.parseInt(rs.getString("yearOfRelease"));
					title = rs.getString("title");
					genre = rs.getString("genre");
					director = rs.getString("director");
					price = Double.parseDouble(rs.getString("price"));
					format = rs.getString("format");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Title you are looking for is not available at the moment");
			}

			 Movies movie = new Movies(yearOfRelease, title,  genre,  price,  director,  format);
			return movie;
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

		public String[][] getAvailableMusic() {

			boolean rented = false;
			int row = 0;
			String[] columnNames = new String[] { "Music ID", "Title", "Singer", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			String query = "Select * FROM music WHERE rented = '" + rented + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {

					data[row][0] = rs.getString("musicID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("singer");
					data[row][3] = rs.getString("genre");
					data[row][4] = rs.getString("format");
					data[row][5] = rs.getString("price");

					row++;

				}

			} catch (Exception e) {

			}

			return data;

		}

		public String[][] getRentedMusic() {

			boolean rented = false;
			int row = 0;
			String[] columnNames = new String[] { "Music ID", "Title", "Singer", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			String query = "Select * FROM music WHERE rented = '" + rented + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {

					data[row][0] = rs.getString("musicID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("singer");
					data[row][3] = rs.getString("genre");
					data[row][4] = rs.getString("format");
					data[row][5] = rs.getString("price");

					row++;

				}

			} catch (Exception e) {

			}

			return data;

		}

		public Music searchMusicTitle(String musicTitle) {

			ResultSet rs = null;
			int musicID = 0;
			String title = "";
			String singer = "";
			String genre = "";
			String format = "";
			double price = 0;
			int yearOfRelease = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM music WHERE title = '" + musicTitle + "' AND rented = '" + rented +  "'";
				rs = conn.executeQuery(query);
				

				while (rs.next()) {
					musicID = Integer.parseInt(rs.getString("musicID"));
					yearOfRelease = Integer.parseInt(rs.getString("yearOfRelease"));
					title = rs.getString("title");
					genre = rs.getString("genre");
					singer = rs.getString("singer");
					price = Double.parseDouble(rs.getString("price"));
					format = rs.getString("format");
				}
			} catch (Exception e) {
				System.out.println("Title you are looking for is not available at the moment");
			}

			 Music music = new Music(yearOfRelease, title, genre, price, singer, format);
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
				JOptionPane.showMessageDialog(null, "Something went wrong");
			}

			query = "INSERT INTO loyaltyCard (numberOfPoints, customerID) " + "VALUES ( '" + cardPoints + "', '" + id
					+ "');";

			conn.ExecuteSet(query);

		}

		public Customer getCustomer(String email) {

			String fName = "";
			String lName = "";
			String phoneNumber = "";
			String plan = "";
			String cardNumber = "";
			String customerID ="";

			String query = "SELECT * FROM customer WHERE email = '" + email + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					customerID = rs.getString("customerID");
					fName = rs.getString("fName");
					lName = rs.getString("lName");
					phoneNumber = rs.getString("phoneNumber");
					plan = rs.getString("plan");
					cardNumber = rs.getString("cardNumber");
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Something went wrong");
			}

			Customer customer = new Customer(fName, lName, phoneNumber, email, plan, cardNumber);

			return customer;
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
			JOptionPane.showMessageDialog(null, "Something went wrong");
		}

		query = "SELECT numberOfPoints FROM loyaltyCard WHERE loyaltyCardID = '" + id + "'";
		rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				cardPoints = rs.getInt("numberOfPoints");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong");
		}

		return cardPoints;

	}

}
