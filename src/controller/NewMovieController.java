package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.NewMovieView;
import model.Movies;
import model.Queries;

public class NewMovieController implements ActionListener {

	NewMovieView NewMovieView;

	public NewMovieController() {

		this.NewMovieView = new NewMovieView(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		String title = this.NewMovieView.getTitle();
		String director = this.NewMovieView.getDirector();
		String genre = this.NewMovieView.getGenre();
		int yearOfRelease = this.NewMovieView.getYearOfRelease();
		String format = this.NewMovieView.getFormat();
		double price = this.NewMovieView.getPrice();

		Movies movie = new Movies(yearOfRelease, title, genre, price, director, format);

		String action = ae.getActionCommand();

		if (action.equals("create")) {

			Queries movieQuery = new Queries();

			Queries.movieClass innerMovie = movieQuery.new movieClass();

			boolean newMovie = innerMovie.insertNewMovie(movie);

			if (newMovie) {
				this.NewMovieView.dispose();
				JOptionPane.showMessageDialog(null, "New Movie " + movie.getTitle() + " Successfully Created!");
			}
		}

	}

}
