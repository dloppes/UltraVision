package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import View.NewMovieView;
import model.Movies;
import model.Queries;

/**
 * 
 * @author Daniel Lopes
 * 
 *         This class is responsible for creating a new Live Concert object. It
 *         has access to the LiveConcertView and Queries Model
 *
 */
public class NewMovieController implements ActionListener {

	NewMovieView NewMovieView;

	public NewMovieController() throws ParseException {

		this.NewMovieView = new NewMovieView(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		/*
		 * The information that the user types in the screen text field is retrieved and
		 * saved within those variables. After storing them in the variable I can use
		 * each variable to create my movie object *
		 */

		String title = this.NewMovieView.getTitle();
		String director = this.NewMovieView.getDirector();
		String genre = this.NewMovieView.getGenre();
		int yearOfRelease = this.NewMovieView.getYearOfRelease();
		String format = this.NewMovieView.getFormat();
		double price = this.NewMovieView.getPrice();

		Movies movie = new Movies(yearOfRelease, title, genre, price, director, format);

		String action = ae.getActionCommand();

		if (action.equals("create")) {

			Queries movieQuery = new Queries(); // instance of Queries

			Queries.movieClass innerMovie = movieQuery.new movieClass(); /*
																			 * instance of the inner class within Live
																			 * Movie Class
																			 */

			boolean newMovie = innerMovie.insertNewMovie(movie);

			if (newMovie) {
				this.NewMovieView.dispose();
				JOptionPane.showMessageDialog(null, "New Movie " + movie.getTitle() + " Successfully Created!");
			}
		}

	}

}
