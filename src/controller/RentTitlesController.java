package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import View.RentTitlesView;
import model.Customer;
import model.LiveConcert;
import model.Movies;
import model.Music;
import model.Queries;
import model.TVBox;

/**
 * 
 * @author Daniel Lopes
 * 
 *         This controller gathers the information that comes from Rent Titles
 *         View and the result of Queries. Many tasks are managed on this screen
 *         such as summing up total to pay, credits earned, search for titles
 *         and search for customers.
 *
 */
public class RentTitlesController implements ActionListener {

	RentTitlesView RentTitlesView;
	private Customer customer;
	private Music music;
	private Movies movie;
	private TVBox tvBox;
	private LiveConcert liveConcert;

	public RentTitlesController() {

		this.RentTitlesView = new RentTitlesView(this);
	}

	@Override
	public void actionPerformed(ActionEvent action) {

		Queries queries = new Queries(); // Instance of Queries

		switch (action.getActionCommand()) {
		case "searchCustomer":
			String email = this.RentTitlesView.getEmailTextField();
			Queries.customerClass innerCustomer = queries.new customerClass();

			customer = innerCustomer.getCustomer(email);
			this.RentTitlesView.getCustomerEmailComboBox().addItem(customer.getfName() + " " + customer.getlName());
			break;

		case "selectCustomer":
			/*
			 * once customer is selected I can check in the system what is his ID,
			 * loyaltyCardID and cardPoints and display it on the screen in Order Details
			 * along with todays date.
			 */
			this.RentTitlesView.setCustomerIDTextField(customer.getCustomerID());

			String cardID = Integer.toString(queries.getLoyaltyCardID(customer.getEmail()));
			this.RentTitlesView.setLoyaltyCardID(cardID);

			String cardPoints = Integer.toString(queries.getCardPoints(customer.getEmail()));
			this.RentTitlesView.setCardPointsBalance(cardPoints);

			// using Java Library to bring today`s date to the screen.
			LocalDate todaysDate = LocalDate.now();
			DateTimeFormatter dateFormatted = DateTimeFormatter
					.ofPattern("dd-MM-yyyy"); /*
												 * formatting the text to look similar to Europe Standard
												 */
			this.RentTitlesView.setRentedDate(todaysDate.format(dateFormatted)); // then passing the value formatted to
																					// the date field

			double initialTotal = 0; // using initial value 0 as there is not title rented at this point.
			this.RentTitlesView.setTotalTextField(initialTotal);

			double initialDiscount = 0; // using initial discount 0 as well as there is no discount due at the beginning
										// of transaction.
			this.RentTitlesView.setDiscountTextField(initialDiscount);

			this.RentTitlesView.setCreditCardNumber(customer.getCardNumber()); // getting the information from the
																				// customer object and setting it on the
																				// screen

			break;

		/*
		 * the only validation for search is that the title is whether or not the title
		 * is available. further validations are available once it is selected
		 */
		case "searchMusic":
			String musicTitle = this.RentTitlesView.getMusicTitleTextField();
			Queries.musicClass innerMusic = queries.new musicClass();

			music = innerMusic.searchMusicTitle(musicTitle);
			this.RentTitlesView.getMusicComboBox()
					.addItem(music.getTitle() + " | " + music.getSinger() + " | " + music.getFormat());

			break;

		case "searchMovie":
			String movieTitle = this.RentTitlesView.getMovieTitleTextField();
			Queries.movieClass innerMovie = queries.new movieClass();

			movie = innerMovie.searchMovieTitle(movieTitle);
			this.RentTitlesView.getMovieComboBox()
					.addItem(movie.getTitle() + " | " + movie.getDirector() + " | " + movie.getFormat());
			break;

		case "searchTVBox":
			String tvBoxTitle = this.RentTitlesView.getTVBoxTitleTextField();
			Queries.tvBoxClass innerTVBox = queries.new tvBoxClass();

			tvBox = innerTVBox.searchTVBoxTitle(tvBoxTitle);
			this.RentTitlesView.getLiveTVBox().addItem(tvBox.getTitle() + " | " + tvBox.getFormat());
			break;

		case "searchLiveConcert":
			String liveTitle = this.RentTitlesView.getLiveConcertTextField();
			Queries.liveConcertClass innerLiveConcert = queries.new liveConcertClass();

			liveConcert = innerLiveConcert.searchLiveConcertTitle(liveTitle);
			this.RentTitlesView.getLiveConcertComboBox()
					.addItem(liveConcert.getTitle() + " | " + liveConcert.getBand() + " | " + liveConcert.getFormat());
			break;

		/*
		 * For selections there are a few validations that are necessary 1 - Check
		 * customer plan and title being rented 2 - check how many titles the customer
		 * has rented or if there is any to be returned. 3 - once the title limit per
		 * customer has been reached he is not allowed to rent anything else until he
		 * returns any.
		 */
		case "selectMusic":

			boolean musicPlanValidator = customer.validateMusicPlan(customer);
			if (musicPlanValidator == false) {

				/*
				 * Message to be shown on the screen in case the customer does not have the
				 * adequate plan that allows him to rent music
				 */
				JOptionPane.showMessageDialog(null,
						"Sorry you are not allowed to rent this Title. In order to do so update your plan");

			}

			if (musicPlanValidator == true) {
				/*
				 * method to verify how many titles user has registered as rented on his name.
				 * If it is == 4 he cannot rent anything anymore until he returns titles
				 */
				Queries.musicClass musicQuery = queries.new musicClass();
				int musicRentedCounter = customer.totalNumberOfTitlesRented(customer);

				if (musicRentedCounter == 4) {
					JOptionPane.showMessageDialog(null,
							"Sorry. You already have reached the limit amount of Titles that can be rented per customer!");
				}

				else if (musicRentedCounter < 4) {
					/* method to insert the movie Object into database */

					double discount = 0;

					/*
					 * Calling method to: 1 - update music rented field to true, therefore music is
					 * not available anymore for rent until its returned 2 - method to insert object
					 * selected into the rented music table 3 - check if the customer has reached
					 * 100 points in the field loyalty card points. If so concede a discount (free
					 * rental)
					 */
					boolean updateMusic = musicQuery.UpdateMusicToRented(music, customer);
					if (updateMusic == true) {

						String date = this.RentTitlesView.getRentedDateTextField().getText();

						musicQuery.InsertIntoMusicRentedTable(music, customer, date);

						if (this.RentTitlesView.getCardPointsBalance().equals("100")) { // method requires an boolean
																						// price to concede discount
							this.RentTitlesView.setDiscountTextField(
									customer.totalDiscount()); /*
																 * after value is retrieved it has been set in the
																 * discount field
																 */
						}

						discount = Double.parseDouble(this.RentTitlesView.getDiscountTextField().getText());
						double price = Double.parseDouble(this.RentTitlesView.getTotalTextField().getText());
						double newTotal = customer.totalToPay(music.getPrice(), price, discount);
						this.RentTitlesView.setTotalTextField(newTotal);

					}
				}
			}

			break;

		case "selectMovie":

			boolean moviePlanValidator = customer.validateMoviePlan(customer);

			// validating customer plan (VL)
			if (moviePlanValidator == false) {

				JOptionPane.showMessageDialog(null,
						"Sorry you are not allowed to rent this Title. In order to do so update your plan");
			}
			if (moviePlanValidator == true) {
				/*
				 * method to verify how many titles user has registered as rented on his name.
				 * If it is == 4 he cannot rent anything anymore until he returns titles
				 */
				// verifying the number of Items in the database that is under the customerID
				// and that has not been returned yet

				Queries.movieClass movieQuery = queries.new movieClass();
				int movieRentedCounter = customer.totalNumberOfTitlesRented(customer);

				if (movieRentedCounter == 4) {
					JOptionPane.showMessageDialog(null,
							"Sorry. You already have reached the limit amount of Titles that can be rented per customer!");
				}

				else if (movieRentedCounter < 4) {
					/* method to insert the movie Object into database */

					double discount = 0;

					/*
					 * Calling method to: 1 - update music rented field to true, therefore music is
					 * not available anymore for rent until its returned 2 - method to insert object
					 * selected into the rented movie table 3 - check if the customer has reached
					 * 100 points in the field loyalty card points. If so concede a discount (free
					 * rental)
					 */
					boolean updateMovie = movieQuery.UpdateMovieToRented(movie, customer);
					if (updateMovie == true) {

						String date = this.RentTitlesView.getRentedDateTextField().getText();

						movieQuery.InsertIntoMovieRentedTable(movie, customer, date);

						if (this.RentTitlesView.getCardPointsBalance().equals("100")) {
							this.RentTitlesView.setDiscountTextField(customer.totalDiscount());
						}

						discount = Double.parseDouble(this.RentTitlesView.getDiscountTextField().getText());
						double price = Double.parseDouble(this.RentTitlesView.getTotalTextField().getText());
						double newTotal = customer.totalToPay(movie.getPrice(), price, discount);
						this.RentTitlesView.setTotalTextField(newTotal);

					}
				}
			}

			break;

		case "selectLiveConcert":
			boolean liveConcertValidator = customer.validateLiveConcertPlan(customer);
			if (liveConcertValidator == false) {

				JOptionPane.showMessageDialog(null,
						"Sorry you are not allowed to rent this Title. In order to do so update your plan");
			}

			if (liveConcertValidator == true) {

				/*
				 * method to verify how many titles user has registered as rented on his name.
				 * If it is == 4 he cannot rent anything anymore until he returns titles
				 */
				Queries.liveConcertClass liveConcertQuery = queries.new liveConcertClass();
				int liveConcertRentedCounter = customer.totalNumberOfTitlesRented(customer);

				if (liveConcertRentedCounter == 4) {
					JOptionPane.showMessageDialog(null,
							"Sorry. You already have reached the limit amount of Titles that can be rented per customer!");
				}

				else if (liveConcertRentedCounter < 4) {
					/* method to insert the movie Object into database */

					double discount = 0;

					/*
					 * Calling method to: 1 - update music rented field to true, therefore music is
					 * not available anymore for rent until its returned 2 - method to insert object
					 * selected into the rented live concert table 3 - check if the customer has
					 * reached 100 points in the field loyalty card points. If so concede a discount
					 * (free rental)
					 */
					boolean updateLiveConcert = liveConcertQuery.UpdateLiveConcertToRented(liveConcert, customer);
					if (updateLiveConcert == true) {

						String date = this.RentTitlesView.getRentedDateTextField().getText();

						liveConcertQuery.InsertIntoLiveConcertRentedTable(liveConcert, customer, date);

						if (this.RentTitlesView.getCardPointsBalance().equals("100")) {
							this.RentTitlesView.setDiscountTextField(customer.totalDiscount());
						}

						discount = Double.parseDouble(this.RentTitlesView.getDiscountTextField().getText());
						double price = Double.parseDouble(this.RentTitlesView.getTotalTextField().getText());
						double newTotal = customer.totalToPay(liveConcert.getPrice(), price, discount);
						this.RentTitlesView.setTotalTextField(newTotal);

					}
				}
			}

			break;

		case "selectTVBox":
			boolean tvBoxValidator = customer.validateTVBoxPlan(customer);
			if (tvBoxValidator == false) {

				JOptionPane.showMessageDialog(null,
						"Sorry you are not allowed to rent this Title. In order to do so update your plan");
			}

			if (tvBoxValidator == true) {
				/*
				 * method to verify how many titles user has registered as rented on customer
				 * name. If it is == 4 he cannot rent anything anymore until he returns titles
				 */

				Queries.tvBoxClass TVBoxQuery = queries.new tvBoxClass();
				int TVBoxRentedCounter = customer.totalNumberOfTitlesRented(customer);

				if (TVBoxRentedCounter == 4) {
					JOptionPane.showMessageDialog(null,
							"Sorry. You already have reached the limit amount of Titles that can be rented per customer!");
				}

				else if (TVBoxRentedCounter < 4) {
					/* method to insert the movie Object into database */

					double discount = 0;

					/*
					 * Calling method to: 1 - update music rented field to true, therefore music is
					 * not available anymore for rent until its returned 2 - method to insert object
					 * selected into the rented TVBox table 3 - check if the customer has reached
					 * 100 points in the field loyalty card points. If so concede a discount (free
					 * rental)
					 */
					boolean updateTVBox = TVBoxQuery.UpdateTVBoxToRented(tvBox, customer);
					if (updateTVBox == true) {

						String date = this.RentTitlesView.getRentedDateTextField().getText();

						TVBoxQuery.InsertIntoTVBoxRentedTable(tvBox, customer, date);

						if (this.RentTitlesView.getCardPointsBalance().equals("100")) {
							this.RentTitlesView.setDiscountTextField(customer.totalDiscount());
						}

						discount = Double.parseDouble(this.RentTitlesView.getDiscountTextField().getText());
						double price = Double.parseDouble(this.RentTitlesView.getTotalTextField().getText());
						double newTotal = customer.totalToPay(tvBox.getPrice(), price, discount);
						this.RentTitlesView.setTotalTextField(newTotal);

					}
				}
			}

			break;

		case "pay":
			/*
			 * If field is 0.0 it means that the customer has not reached 100 points on his
			 * loyalty card yet. Therefore, ask the employee to insert how many points the
			 * customer earned in this transaction for each rental the customer earns 10
			 * points
			 */
			if (this.RentTitlesView.getDiscountTextField().getText().equals("0.0")) {

				int pointsEarned = customer.totalPointsEarned();
				this.RentTitlesView.setCardPointsEarnedTextField(pointsEarned);

				Queries.loyaltyCard loyaltyPoints = queries.new loyaltyCard();
				loyaltyPoints.insertPointsLoyaltyCard(pointsEarned,
						customer); /*
									 * method to insert the points earned into the database
									 */

				ImageIcon image = new ImageIcon(RentTitlesController.class.getResource("/img/shopping-bag-icon.png"));
				JOptionPane.showMessageDialog(null,
						"Thank you for shopping with us! Don`t forget to bring the items back in 3 days!", "Thanks",
						JOptionPane.INFORMATION_MESSAGE, image);

			}
			break;
		}

	}

}
