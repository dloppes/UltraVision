package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.RentTitlesView;
import model.Queries;

public class RentTitlesController implements ActionListener {

	RentTitlesView RentTitlesView;

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

			this.RentTitlesView.getCustomerEmailComboBox().addItem(
					innerCustomer.getCustomer(email).getfName() + " " + innerCustomer.getCustomer(email).getlName());
			break;

		case "searchMusic":
			String musicTitle = this.RentTitlesView.getMusicTitleTextField();
			Queries.musicClass innerMusic = queries.new musicClass();

			this.RentTitlesView.getMusicComboBox()
					.addItem(innerMusic.searchMusicTitle(musicTitle).getTitle() + " | "
							+ innerMusic.searchMusicTitle(musicTitle).getSinger() + " | "
							+ innerMusic.searchMusicTitle(musicTitle).getFormat());

			break;

		case "searchMovie":
			String movieTitle = this.RentTitlesView.getMovieTitleTextField();
			Queries.movieClass innerMovie = queries.new movieClass();

			this.RentTitlesView.getMovieComboBox()
					.addItem(innerMovie.searchMovieTitle(movieTitle).getTitle() + " | "
							+ innerMovie.searchMovieTitle(movieTitle).getDirector() + " | "
							+ innerMovie.searchMovieTitle(movieTitle).getFormat());
			break;

		case "searchTVBox":
			String tvBoxTitle = this.RentTitlesView.getTVBoxTitleTextField();
			Queries.tvBoxClass innerTVBox = queries.new tvBoxClass();

			this.RentTitlesView.getLiveTVBox().addItem(innerTVBox.searchTVBoxTitle(tvBoxTitle).getTitle() + " | "
					+ innerTVBox.searchTVBoxTitle(tvBoxTitle).getFormat());
			break;

		case "searchLiveConcert":
			String liveTitle = this.RentTitlesView.getLiveConcertTextField();
			Queries.liveConcertClass innerLiveConcert = queries.new liveConcertClass();

			this.RentTitlesView.getLiveConcertComboBox()
					.addItem(innerLiveConcert.searchLiveConcertTitle(liveTitle).getTitle() + " | "
							+ innerLiveConcert.searchLiveConcertTitle(liveTitle).getBand() + " | "
							+ innerLiveConcert.searchLiveConcertTitle(liveTitle).getFormat());
			break;

		}

	}

}
