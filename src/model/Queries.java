package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Daniel Lopes
 *
 *         Queries is as the name suggests a class that contains all the methods
 *         that requires connections with the database. It has been divided by
 *         inner class in order to facilitate the location of methods when
 *         searching for them.
 */
public class Queries {

	public class tvBoxClass {

		/* TV Box inner class for queries */
		connection conn = new connection();

		public boolean insertNewTVBox(TVBox tvBox) {

			boolean newTVBox = false;

			String query = "INSERT INTO TVBox (season, title, numberOfDisks, rented, price, format) " + "VALUES ( '"
					+ tvBox.getSeason() + "', '" + tvBox.getTitle() + "', '" + tvBox.getNumberOfDisks() + "', '"
					+ tvBox.rented + "', '" + tvBox.getPrice() + "', '" + tvBox.getFormat() + "');";

			newTVBox = conn.ExecuteSet(query);

			return newTVBox;
		}

		public boolean UpdateTVBoxToAvailable(String id) {

			/*
			 * This method changes the value of the field rented in the database to false,
			 * which means then that the specific title is available again for rental.
			 */

			boolean updatedTVBox = false;
			String query = "UPDATE TVBox SET rented = '" + false + "' WHERE titleID = '" + id + "'";
			if (updatedTVBox = conn.ExecuteSet(query))
				;
			{
				updatedTVBox = true;
			}
			return updatedTVBox;
		}

		public boolean updateReturnDate(String id, String date) {

			/*
			 * This method adds a date to the table rentedTVBox
			 */

			boolean updatedRentedTVBox = false;

			String query = "UPDATE rentedTVBox SET returnDate = '" + date + "' WHERE titleID = '" + id + "'";
			if (updatedRentedTVBox = conn.ExecuteSet(query))
				;
			{
				updatedRentedTVBox = true;
			}

			return updatedRentedTVBox;
		}

		public String[][] getAllRentedTVBoxByCustomer(String customerID) {

			int row = 0;

			String[] columnNames = new String[] { "Band ID", "Title", "Rented Date" };

			String[][] data = new String[100][columnNames.length];

			String query = "SELECT rentedTVBox.titleID, TVBox.title, rentedTVBox.rentedDate FROM rentedTVBox INNER JOIN TVBox on rentedTVBox.titleID = TVBox.titleID where returnDate is null and rentedTVBox.customerID = '"
					+ customerID + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					data[row][0] = rs.getString("titleID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("rentedDate");
					row++;

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

			return data;

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

			boolean rented = true;
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

			/*
			 * Gets a String title as parameter and searches in the database for the object
			 * that has the same title. I am returning the whole object
			 */

			ResultSet rs = null;
			String titleID = "";
			String title = "";
			String format = "";
			int numberOfDisks = 0;
			double price = 0;
			int season = 0;
			boolean rented = false;

			try {
				String query = "Select * FROM TVBox WHERE  title LIKE '%" + tvBoxTitle + "%' AND rented = '" + rented
						+ "'";
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

			TVBox tvBox = new TVBox(title, season, numberOfDisks, price, titleID, format);
			return tvBox;
		}

		public boolean UpdateTVBoxToRented(TVBox tvBox) {

			/*
			 * This method changes the value of the field rented in the database to true,
			 * which means then that the specific title has been rented
			 */

			boolean updatedTVBox = false;
			String query = "UPDATE TVBox SET rented = '" + true + "' WHERE titleID = '" + tvBox.getTitleID() + "'";
			updatedTVBox = conn.ExecuteSet(query);

			return updatedTVBox;

		}

		public boolean InsertIntoTVBoxRentedTable(TVBox tvBox, Customer customer, String rentedDate) {

			boolean newTVBoxRented = false;

			String query = "INSERT INTO rentedTVBox (titleID, customerID, rentedDate) " + "VALUES ('"
					+ tvBox.getTitleID() + "','" + customer.getCustomerID() + "', '" + rentedDate + "');";

			newTVBoxRented = conn.ExecuteSet(query);

			return newTVBoxRented;

		}

		public int numberOfTVBoxRented(Customer customer) {

			/*
			 * This method searches for the numbers of titles that has been rented to a
			 * specific customerID in the rentedTVBox table. It returns the result (sum of
			 * total).
			 */

			ResultSet rs;
			int count = 0;

			String query = "SELECT COUNT(titleID) FROM rentedTVBox WHERE customerID = '" + customer.getCustomerID()
					+ "' AND returnDate is null";
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

	/* Live Concert inner class for queries */
	public class liveConcertClass {

		connection conn = new connection();

		public boolean insertNewLiveConcert(LiveConcert liveConcert) {

			boolean newLiveConcert = false;

			String query = "INSERT INTO liveConcert (yearOfRelease, title, genre, rented, band, price, format) "
					+ "VALUES ( '" + liveConcert.getYearOfRelease() + "', '" + liveConcert.getTitle() + "', '"
					+ liveConcert.getGenre() + "', '" + liveConcert.rented + "', '" + liveConcert.getBand() + "', '"
					+ liveConcert.getPrice() + "' , '" + liveConcert.getFormat() + "');";

			newLiveConcert = conn.ExecuteSet(query);

			return newLiveConcert;
		}

		public boolean UpdateLiveConcertToAvailable(String id) {

			/*
			 * This method changes the value of the field rented in the database to false,
			 * which means then that the specific title is available again for rental.
			 */

			boolean updatedLiveConcert = false;
			String query = "UPDATE liveConcert SET rented = '" + false + "' WHERE bandID = '" + id + "'";
			if (updatedLiveConcert = conn.ExecuteSet(query))
				;
			{
				updatedLiveConcert = true;
			}
			return updatedLiveConcert;
		}

		public boolean updateReturnDate(String id, String date) {

			/*
			 * This method adds a date to the table rentedTVBox
			 */

			boolean updatedRentedLiveConcert = false;

			String query = "UPDATE rentedLiveConcert SET returnDate = '" + date + "' WHERE bandID = '" + id + "'";
			if (updatedRentedLiveConcert = conn.ExecuteSet(query))
				;
			{
				updatedRentedLiveConcert = true;
			}

			return updatedRentedLiveConcert;
		}

		public String[][] getAllRentedLiveConcertByCustomer(String customerID) {

			int row = 0;

			String[] columnNames = new String[] { "Band ID", "Title", "Rented Date" };

			String[][] data = new String[100][columnNames.length];

			String query = "SELECT rentedLiveConcert.bandID, liveConcert.title, rentedLiveConcert.rentedDate FROM rentedLiveConcert INNER JOIN liveConcert on rentedLiveConcert.bandID = liveConcert.bandID where returnDate is null and rentedLiveConcert.customerID = '"
					+ customerID + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					data[row][0] = rs.getString("bandID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("rentedDate");
					row++;

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

			return data;

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

			boolean rented = true;
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

			/*
			 * Gets a String title as parameter and searches in the database for the object
			 * that has the same title. I am returning the whole object
			 */

			ResultSet rs = null;
			String bandID = "";
			String title = "";
			String band = "";
			String genre = "";
			String format = "";
			double price = 0;
			String yearOfRelease = "";
			boolean rented = false;

			try {
				String query = "Select * FROM liveConcert WHERE  title LIKE '%" + liveTitle + "%' AND rented = '"
						+ rented + "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					bandID = (rs.getString("bandID"));
					yearOfRelease = (rs.getString("yearOfRelease"));
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

		public boolean UpdateLiveConcertToRented(LiveConcert liveConcert) {

			/*
			 * This method changes the value of the field rented in the database to true,
			 * which means then that the specific title has been rented
			 */

			boolean updatedLiveConcert = false;
			String query = "UPDATE liveConcert SET rented = '" + true + "' WHERE bandID = '"
					+ liveConcert.getLiveConcertID() + "'";
			updatedLiveConcert = conn.ExecuteSet(query);

			return updatedLiveConcert;

		}

		public boolean InsertIntoLiveConcertRentedTable(LiveConcert liveConcert, Customer customer, String rentedDate) {

			boolean newLiveConcertRented = false;

			String query = "INSERT INTO rentedLiveConcert (bandID, customerID, rentedDate) " + "VALUES ('"
					+ liveConcert.getLiveConcertID() + "','" + customer.getCustomerID() + "', '" + rentedDate + "');";

			newLiveConcertRented = conn.ExecuteSet(query);

			return newLiveConcertRented;

		}

		public int numberOfLiveConcertRented(Customer customer) {

			/*
			 * This method searches for the numbers of titles that has been rented to a
			 * specific customerID in the rentedLiveConcert table. It returns the result
			 * (sum of total).
			 */
			ResultSet rs;
			int count = 0;

			String query = "SELECT COUNT(bandID) FROM rentedLiveConcert WHERE customerID = '" + customer.getCustomerID()
					+ "' AND returnDate is null";
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

	/* Movie inner class for queries */

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

		public boolean UpdateMovieToAvailable(String id) {

			/*
			 * This method changes the value of the field rented in the database to false,
			 * which means then that the specific title is available again for rental.
			 */

			boolean updatedMovie = false;
			String query = "UPDATE movies SET rented = '" + false + "' WHERE movieID = '" + id + "'";
			if (updatedMovie = conn.ExecuteSet(query))
				;
			{
				updatedMovie = true;
			}
			return updatedMovie;
		}

		public boolean updateReturnDate(String id, String date) {

			/*
			 * This method adds a date to the table rentedTVBox
			 */

			boolean updatedRentedMovie = false;

			String query = "UPDATE rentedMovie SET returnDate = '" + date + "' WHERE movieID = '" + id + "'";
			if (updatedRentedMovie = conn.ExecuteSet(query))
				;
			{
				updatedRentedMovie = true;
			}

			return updatedRentedMovie;
		}

		public String[][] getAllRentedMovieByCustomer(String customerID) {

			int row = 0;

			String[] columnNames = new String[] { "Movie ID", "Title", "Rented Date" };

			String[][] data = new String[100][columnNames.length];

			String query = "SELECT rentedMovie.movieID, movies.title, rentedMovie.rentedDate FROM rentedMovie INNER JOIN movies on rentedMovie.movieID = movies.movieID where returnDate is null and rentedMovie.customerID = '"
					+ customerID + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					data[row][0] = rs.getString("movieID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("rentedDate");
					row++;

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

			return data;

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

			boolean rented = true;
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

		public Movies searchMovieTitle(String movieTitle) {

			/*
			 * Gets a String title as parameter and searches in the database for the object
			 * that has the same title. I am returning the whole object
			 */

			ResultSet rs = null;
			String movieID = "";
			String title = "";
			String director = "";
			String genre = "";
			String format = "";
			double price = 0;
			String yearOfRelease = "";
			boolean rented = false;

			try {
				String query = "Select * FROM movies WHERE  title LIKE '%" + movieTitle + "%' AND rented = '" + rented
						+ "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					movieID = (rs.getString("movieID"));
					yearOfRelease = (rs.getString("yearOfRelease"));
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

		public boolean UpdateMovieToRented(Movies movie) {

			/*
			 * This method changes the value of the field rented in the database to true,
			 * which means then that the specific title has been rented
			 */

			boolean updatedMovie = false;
			String query = "UPDATE movies SET rented = '" + true + "' WHERE movieID = '" + movie.getMovieID() + "'";
			updatedMovie = conn.ExecuteSet(query);

			return updatedMovie;

		}

		public boolean InsertIntoMovieRentedTable(Movies movie, Customer customer, String rentedDate) {
			boolean newMovieRented = false;

			String query = "INSERT INTO rentedMovie (movieID, customerID, rentedDate) " + "VALUES ('"
					+ movie.getMovieID() + "','" + customer.getCustomerID() + "', '" + rentedDate + "');";

			newMovieRented = conn.ExecuteSet(query);

			return newMovieRented;

		}

		public int numberOfMovieRented(Customer customer) {

			/*
			 * This method searches for the numbers of titles that has been rented to a
			 * specific customerID in the rentedMovie table. It returns the result (sum of
			 * total).
			 */

			ResultSet rs;
			int count = 0;

			String query = "SELECT COUNT(movieID) FROM rentedMovie WHERE customerID = '" + customer.getCustomerID()
					+ "' AND returnDate is null";
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

	/* Music inner class for queries */

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

		public boolean UpdateMusicToAvailable(String id) {

			/*
			 * This method changes the value of the field rented in the database to false,
			 * which means then that the specific title is available again for rental.
			 */

			boolean updatedMusic = false;
			String query = "UPDATE music SET rented = '" + false + "' WHERE musicID = '" + id + "'";
			if (updatedMusic = conn.ExecuteSet(query))
				;
			{
				updatedMusic = true;
			}
			return updatedMusic;
		}

		public boolean updateReturnDate(String id, String date) {

			/*
			 * This method adds a date to the table rentedTVBox
			 */

			boolean updatedRentedMusic = false;

			String query = "UPDATE rentedMusic SET returnDate = '" + date + "' WHERE musicID = '" + id + "'";
			if (updatedRentedMusic = conn.ExecuteSet(query))
				;
			{
				updatedRentedMusic = true;
			}

			return updatedRentedMusic;
		}

		public Music getMusicDetails(String musicID) {

			Music music;
			ResultSet rs;

			String yearOfRelease = "";
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
					yearOfRelease = (rs.getString("fName"));
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

		public String[][] getAllRentedMusicByCustomer(String customerID) {

			int row = 0;

			String[] columnNames = new String[] { "Music ID", "Title", "Rented Date" };

			String[][] data = new String[100][columnNames.length];

			String query = "SELECT rentedMusic.musicID, music.title, rentedMusic.rentedDate FROM rentedMusic INNER JOIN music on rentedMusic.musicID = music.musicID where returnDate is null and rentedMusic.customerID = '"
					+ customerID + "'";
			ResultSet rs = conn.executeQuery(query);

			try {
				while (rs.next()) {
					data[row][0] = rs.getString("musicID");
					data[row][1] = rs.getString("title");
					data[row][2] = rs.getString("rentedDate");
					row++;

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

			return data;

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

			boolean rented = true;
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

			/*
			 * Gets a String title as parameter and searches in the database for the object
			 * that has the same title. I am returning the whole object
			 */

			ResultSet rs = null;
			String musicID = "";
			String title = "";
			String singer = "";
			String genre = "";
			String format = "";
			double price = 0;
			String yearOfRelease = "";
			boolean rented = false;

			try {
				String query = "Select * FROM music WHERE title LIKE '%" + musicTitle + "%' AND rented = '" + rented
						+ "'";
				rs = conn.executeQuery(query);

				while (rs.next()) {
					musicID = (rs.getString("musicID"));
					yearOfRelease = (rs.getString("yearOfRelease"));
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

		public boolean UpdateMusicToRented(Music music) {

			/*
			 * This method changes the value of the field rented in the database to true,
			 * which means then that the specific title has been rented
			 */

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

			/*
			 * This method searches for the numbers of titles that has been rented to a
			 * specific customerID in the rentedMusic table. It returns the result (sum of
			 * total).
			 */

			ResultSet rs;
			int count = 0;

			String query = "SELECT COUNT(musicID) FROM rentedMusic WHERE customerID = '" + customer.getCustomerID()
					+ "' AND returnDate is null";
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

	/* Customer inner class for queries */
	public class customerClass {

		connection conn = new connection();

		public boolean insertNewCustomer(Customer customer) {

			boolean newCustomer = false;

			String query = "INSERT INTO customer (fName, lName, email, cardNumber, plan, phoneNumber) "
					+ "VALUES ( '" + customer.getfName() + "', '" + customer.getlName() + "', '" + customer.getEmail()
					+ "', '" + customer.getCardNumber() + "' , '" + customer.getPlan() + "', '"
					+ customer.getPhoneNumber() + "');";

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

			/*
			 * Searches for the customer once the email is given and return the whole object
			 * with its attributes
			 */

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

		public boolean resetPointsLoyaltyCard(int points, Customer customer) {

			boolean insertedCardPoints = false;

			String query = "UPDATE loyaltyCard SET numberOfPoints = '" + points + "' WHERE customerID='"
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

		/*
		 * This method has two mainly operations; 1 - search for customer that has the
		 * email given, and through email get the customer ID. 2 - Once I have the
		 * customer ID I search in the Loyalty Card table for the card that is
		 * associated with that customer ID. 3 - The value loyaltyCardPoints is stored
		 * in an integer and returned when this method is called.
		 */

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

		/*
		 * This method receives the customer email as parameter and searches for the
		 * customer ID in the system. Once it has it, the next step is to search the for
		 * the card ID in the table LOyalty Card that has the same customer ID
		 * associated to it. the integer cardID will be returned when the method is
		 * called. SO it can be displayed on the screen in the rental view.
		 */
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
