package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import View.NewLiveConcertView;
import model.LiveConcert;
import model.Queries;

/**
 * 
 * @author Daniel Lopes
 *
 *         This class is responsible for creating a new Live Concert object. It
 *         has access to the LiveConcertView and Queries Model
 */
public class NewLiveConcertController implements ActionListener {

	NewLiveConcertView NewLiveConcertView;

	public NewLiveConcertController() throws ParseException {

		this.NewLiveConcertView = new NewLiveConcertView(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		/*
		 * The information that the user types in the screen text field is retrieved and
		 * saved within those variables. After storing them in the variable I can use
		 * each variable to create my Live Concert object *
		 */

		String title = this.NewLiveConcertView.getTitle();
		String band = this.NewLiveConcertView.getBand();
		String genre = this.NewLiveConcertView.getGenre();
		int yearOfRelease = this.NewLiveConcertView.getYearOfRelease();
		String format = this.NewLiveConcertView.getFormat();
		double price = this.NewLiveConcertView.getPrice();

		LiveConcert liveConcert = new LiveConcert(yearOfRelease, title, genre, price, band, format);

		String action = ae.getActionCommand();

		if (action.equals("create")) {

			Queries liveConcertQueries = new Queries(); // instance of the Queries

			Queries.liveConcertClass innerLiveConcert = liveConcertQueries.new liveConcertClass(); /*
																									 * instance of the
																									 * inner class
																									 * within Live
																									 * Concert Class
																									 */

			boolean newLiveConcert = innerLiveConcert
					.insertNewLiveConcert(liveConcert); /*
														 * accessing the method that is in Live Concert class
														 */

			if (newLiveConcert) {
				this.NewLiveConcertView.dispose();
				JOptionPane.showMessageDialog(null,
						"New Live Concert " + liveConcert.getTitle() + " Successfully Created!");
			}

		}
	}

}
