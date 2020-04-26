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

		Queries queries = new Queries();

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
			DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // formatting the text to look
																							// similar to Europe
																							// Standard
			this.RentTitlesView.setRentedDate(todaysDate.format(dateFormatted)); // then passing the value formatted to
																					// the date field

			double initialTotal = 0;
			this.RentTitlesView.setTotalTextField(initialTotal);

			double initialDiscount = 0;
			this.RentTitlesView.setDiscountTextField(initialDiscount);

			this.RentTitlesView.setCreditCardNumber(customer.getCardNumber());

			break;

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

		case "selectMusic":

			boolean musicPlanValidator = customer.validateMusicPlan(customer);
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

					boolean updateMusic = musicQuery.UpdateMusicToRented(music, customer);
					if (updateMusic == true) {

						String date = this.RentTitlesView.getRentedDateTextField().getText();

						musicQuery.InsertIntoMusicRentedTable(music, customer, date);

						if (this.RentTitlesView.getCardPointsBalance().equals("100")) {
							this.RentTitlesView.setDiscountTextField(customer.totalDiscount());
						}

						discount = Double.parseDouble(this.RentTitlesView.getDiscountTextField().getText());
						double price = Double.parseDouble(this.RentTitlesView.getTotalTextField().getText());
						double newTotal = customer.totalToPay(music.getPrice(), price, discount);
						this.RentTitlesView.setTotalTextField(newTotal);

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Sorry you are not allowed to rent this Title. In order to do so update your plan");
				}
			}

			break;

		case "selectMovie":

			boolean moviePlanValidator = customer.validateMoviePlan(customer);

			// validating customer plan (VL)
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
				} else {
					JOptionPane.showMessageDialog(null,
							"Sorry you are not allowed to rent this Title. In order to do so update your plan");
				}
			}

			break;

		case "selectLiveConcert":
			boolean liveConcertValidator = customer.validateLiveConcertPlan(customer);
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
				} else {
					JOptionPane.showMessageDialog(null,
							"Sorry you are not allowed to rent this Title. In order to do so update your plan");
				}
			}

			break;

		case "selectTVBox":
			boolean tvBoxValidator = customer.validateTVBoxPlan(customer);
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
				} else {
					JOptionPane.showMessageDialog(null,
							"Sorry you are not allowed to rent this Title. In order to do so update your plan");
				}
			}

			break;

		case "pay":
			if (this.RentTitlesView.getDiscountTextField().getText().equals("0.0")) {

				int pointsEarned = customer.totalPointsEarned();
				this.RentTitlesView.setCardPointsEarnedTextField(pointsEarned);

				Queries.loyaltyCard loyaltyPoints = queries.new loyaltyCard();
				loyaltyPoints.insertPointsLoyaltyCard(pointsEarned, customer);

				ImageIcon image = new ImageIcon(RentTitlesController.class.getResource("/img/shopping-bag-icon.png"));
				JOptionPane.showMessageDialog(null,
						"Thank you for shopping with us! Don`t forget to bring the items back in 3 days!", "Thanks",
						JOptionPane.INFORMATION_MESSAGE, image);

			}
			break;
		}

	}

}
