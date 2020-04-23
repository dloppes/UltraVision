package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			 * loyaltyCardID and cardPoints and display it on the screen in Order Details.
			 */
			this.RentTitlesView.setCustomerIDTextField(customer.getCustomerID());

			String cardID = Integer.toString(queries.getLoyaltyCardID(customer.getEmail()));
			this.RentTitlesView.setLoyaltyCardID(cardID);

			String cardPoints = Integer.toString(queries.getCardPoints(customer.getEmail()));
			this.RentTitlesView.setCardPointsBalance(cardPoints);

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
				Queries.musicClass counter = queries.new musicClass();
				int musicRentedCounter = counter.numberOfMusicRented(customer);

				if (musicRentedCounter == 4) {
					JOptionPane.showMessageDialog(null,
							"Sorry. You already have reached the limit amount of Titles that can be rented per customer!");
				}

				else if (musicRentedCounter < 4) {
					/* method to insert the movie Object into database */
					counter.UpdateMusicToRented(music, customer);
					counter.InsertIntoMusicRentedTable(music, customer);

				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Sorry you are not allowed to rent this Title. In order to do so update your plan");
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

				Queries.movieClass counter = queries.new movieClass();
				int movieRentedCounter = counter.numberOfMovieRented(customer);

				if (movieRentedCounter == 4) {
					JOptionPane.showMessageDialog(null,
							"Sorry. You already have reached the limit amount of Titles that can be rented per customer!");
				}

				else if (movieRentedCounter < 4) {
					/* method to insert the movie Object into database */
					counter.UpdateMovieToRented(movie, customer);
					counter.InsertIntoMovieRentedTable(movie, customer);

				}

			} else {
				JOptionPane.showMessageDialog(null,
						"Sorry you are not allowed to rent this Title. In order to do so update your plan");
			}

			break;

		case "selectLiveConcert":
			boolean liveConcertValidator = customer.validateLiveConcertPlan(customer);
			if (liveConcertValidator == true) {
				/*
				 * method to verify how many titles user has registered as rented on his name.
				 * If it is == 4 he cannot rent anything anymore until he returns titles
				 */
				Queries.liveConcertClass counter = queries.new liveConcertClass();
				int liveConcertRentedCounter = counter.numberOfLiveConcertRented(customer);

				if (liveConcertRentedCounter == 4) {
					JOptionPane.showMessageDialog(null,
							"Sorry. You already have reached the limit amount of Titles that can be rented per customer!");
				}

				else if (liveConcertRentedCounter < 4) {
					/* method to insert the movie Object into database */
					counter.UpdateLiveConcertToRented(liveConcert, customer);
					counter.InsertIntoLiveConcertRentedTable(liveConcert, customer);

				}

			} else {
				JOptionPane.showMessageDialog(null,
						"Sorry you are not allowed to rent this Title. In order to do so update your plan");
			}

			break;

		case "selectTVBox":
			boolean tvBoxValidator = customer.validateTVBoxPlan(customer);
			if (tvBoxValidator == true) {
				/*
				 * method to verify how many titles user has registered as rented on his name.
				 * If it is == 4 he cannot rent anything anymore until he returns titles
				 */
				Queries.tvBoxClass counter = queries.new tvBoxClass();
				int TVBoxRentedCounter = counter.numberOfTVBoxRented(customer);

				if (TVBoxRentedCounter == 4) {
					JOptionPane.showMessageDialog(null,
							"Sorry. You already have reached the limit amount of Titles that can be rented per customer!");
				}

				else if (TVBoxRentedCounter < 4) {
					/* method to insert the movie Object into database */
					counter.UpdateTVBoxToRented(tvBox, customer);
					counter.InsertIntoTVBoxRentedTable(tvBox, customer);

				}

			} else {
				JOptionPane.showMessageDialog(null,
						"Sorry you are not allowed to rent this Title. In order to do so update your plan");
			}

			break;
		}
	}

}
