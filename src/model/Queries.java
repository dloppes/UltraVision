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
			String titleID = "";
			String title = "";
			String format = "";
			int numberOfDisks = 0;
			double price = 0;
			int season = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM TVBox WHERE  title = '" + tvBoxTitle + "' AND rented = '" + rented + "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					titleID = (rs.getString("titleID"));
					season = Integer.parseInt(rs.getString("season"));
					title = rs.getString("title");
					price = Double.parseDouble(rs.getString("price"));
					format = rs.getString("format");
					numberOfDisks = Integer.parseInt(rs.getString("numberOfDisks"));
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Title you are looking for is not available at the moment");
			}

			TVBox tvBox = new TVBox(title, season, numberOfDisks, price, titleID);
			return tvBox;
		}

		public boolean UpdateTVBoxToRented(TVBox tvBox, Customer customer) {
			boolean updatedTVBox = false;
			String query = "UPDATE TVBox SET rented = '" + true + "' WHERE titleID = '" + tvBox.getTitleID() + "'";
			updatedTVBox = conn.ExecuteSet(query);

			return updatedTVBox;

		}

		public boolean InsertIntoTVBoxRentedTable(TVBox tvBox, Customer customer, String rentedDate) {
			boolean newTVBoxRented = false;

			String query = "INSERT INTO rentedTVBox (titleID, customerID, rentedDate, returnDate) " + "VALUES ('"
					+ tvBox.getTitleID() + "','" + customer.getCustomerID() + "', '" + rentedDate + "');";

			newTVBoxRented = conn.ExecuteSet(query);

			return newTVBoxRented;

		}

		public int numberOfTVBoxRented(Customer customer) {
			ResultSet rs;
			int count = 0;

			String query = "SELECT COUNT(titleID) FROM rentedTVBox WHERE customerID = '" + customer.getCustomerID()
					+ "' AND returnDate = '" + null + "'";
			rs = conn.executeQuery(query);

			try {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Oops. Something went wrong!");
			}

			return count;
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
			String bandID = "";
			String title = "";
			String band = "";
			String genre = "";
			String format = "";
			double price = 0;
			int yearOfRelease = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM liveConcert WHERE  title = '" + liveTitle + "' AND rented = '" + rented
						+ "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					bandID = (rs.getString("bandID"));
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

			LiveConcert liveConcert = new LiveConcert(yearOfRelease, title, genre, price, band, format, bandID);
			return liveConcert;
		}

		public boolean UpdateLiveConcertToRented(LiveConcert liveConcert, Customer customer) {
			boolean updatedLiveConcert = false;
			String query = "UPDATE liveConcert SET rented = '" + true + "' WHERE bandID = '"
					+ liveConcert.getLiveConcertID() + "'";
			updatedLiveConcert = conn.ExecuteSet(query);

			return updatedLiveConcert;

		}

		public boolean InsertIntoLiveConcertRentedTable(LiveConcert liveConcert, Customer customer, String rentedDate) {
			boolean newLiveConcertRented = false;

			String query = "INSERT INTO rentedLiveConcert (bandID, customerID, rentedDate, returnDate) " + "VALUES ('"
					+ liveConcert.getLiveConcertID() + "','" + customer.getCustomerID() + "', '" + rentedDate + "');";

			newLiveConcertRented = conn.ExecuteSet(query);

			return newLiveConcertRented;

		}

		public int numberOfLiveConcertRented(Customer customer) {
			ResultSet rs;
			int count = 0;

			String query = "SELECT COUNT(bandID) FROM rentedLiveConcert WHERE customerID = '" + customer.getCustomerID()
					+ "' AND returnDate = '" + null + "'";
			rs = conn.executeQuery(query);

			try {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Oops. Something went wrong!");
			}

			return count;
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
			String movieID = "";
			String title = "";
			String director = "";
			String genre = "";
			String format = "";
			double price = 0;
			int yearOfRelease = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM movies WHERE  title = '" + movieTitle + "' AND rented = '" + rented + "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					movieID = (rs.getString("movieID"));
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

			Movies movie = new Movies(yearOfRelease, title, genre, price, director, format, movieID);
			return movie;
		}

		public boolean UpdateMovieToRented(Movies movie, Customer customer) {
			boolean updatedMovie = false;
			String query = "UPDATE movies SET rented = '" + true + "' WHERE movieID = '" + movie.getMovieID() + "'";
			updatedMovie = conn.ExecuteSet(query);

			return updatedMovie;

		}

		public boolean InsertIntoMovieRentedTable(Movies movie, Customer customer, String rentedDate) {
			boolean newMovieRented = false;

			String query = "INSERT INTO rentedMovie (movieID, customerID, rentedDate, returnDate) " + "VALUES ('"
					+ movie.getMovieID() + "','" + customer.getCustomerID() + "', '" + rentedDate + "');";

			newMovieRented = conn.ExecuteSet(query);

			return newMovieRented;

		}

		public int numberOfMovieRented(Customer customer) {
			ResultSet rs;
			int count = 0;

			String query = "SELECT COUNT(movieID) FROM rentedMovie WHERE customerID = '" + customer.getCustomerID()
					+ "' AND returnDate = '" + null + "'";
			rs = conn.executeQuery(query);

			try {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Oops. Something went wrong!");
			}

			return count;
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
			String musicID = "";
			String title = "";
			String singer = "";
			String genre = "";
			String format = "";
			double price = 0;
			int yearOfRelease = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM music WHERE title = '" + musicTitle + "' AND rented = '" + rented + "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					musicID = (rs.getString("musicID"));
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

			Music music = new Music(yearOfRelease, title, genre, price, singer, format, musicID);
			return music;
		}

		public boolean UpdateMusicToRented(Music music, Customer customer) {
			boolean updatedMusic = false;
			String query = "UPDATE music SET rented = '" + true + "' WHERE musicID = '" + music.getMusicID() + "'";
			updatedMusic = conn.ExecuteSet(query);

			return updatedMusic;

		}

		public boolean InsertIntoMusicRentedTable(Music music, Customer customer, String rentedDate) {
			boolean newMusicRented = false;

			String query = "INSERT INTO rentedMusic (musicID, customerID, rentedDate) " + "VALUES ('"
					+ music.getMusicID() + "','" + customer.getCustomerID() + "', '" + rentedDate + "');";

			newMusicRented = conn.ExecuteSet(query);

			return newMusicRented;

		}

		public int numberOfMusicRented(Customer customer) {
			ResultSet rs;
			int count = 0;

			String query = "SELECT COUNT(musicID) FROM rentedMusic WHERE customerID = '" + customer.getCustomerID()
					+ "' AND returnDate = '" + null + "'";
			rs = conn.executeQuery(query);

			try {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Oops. Something went wrong!");
			}

			return count;
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
			String customerID = "";

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

			Customer customer = new Customer(fName, lName, phoneNumber, email, plan, cardNumber, customerID);

			return customer;
		}

	}

	public class loyaltyCard {

		connection conn = new connection();

		public boolean insertPointsLoyaltyCard(int points, Customer customer) {

			int totalPoints = points + getCardPoints(customer.getEmail());
			boolean insertedCardPoints = false;

			String query = "UPDATE loyaltyCard SET numberOfPoints = '" + totalPoints + "' WHERE customerID='"
					+ customer.getCustomerID() + "';";
			insertedCardPoints = conn.ExecuteSet(query);

			return insertedCardPoints;

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

		query = "SELECT numberOfPoints FROM loyaltyCard WHERE customerID = '" + id + "'";
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

	public int getLoyaltyCardID(String email) {
		connection conn = new connection();

		int customerID = 0;
		int loyaltyCardID = 0;

		String query = "SELECT customerID FROM customer WHERE email = '" + email + "'";
		ResultSet rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				customerID = rs.getInt("customerID");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong");
		}

		query = "SELECT loyaltyCardID FROM loyaltyCard WHERE customerID = '" + customerID + "'";
		rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				loyaltyCardID = rs.getInt("loyaltyCardID");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong");
		}

		return loyaltyCardID;
	}

}
