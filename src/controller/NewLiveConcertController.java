package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import View.NewLiveConcertView;
import model.LiveConcert;
import model.Queries;

public class NewLiveConcertController implements ActionListener{
	
	NewLiveConcertView NewLiveConcertView;
	
	public NewLiveConcertController() throws ParseException {
		
		this.NewLiveConcertView = new NewLiveConcertView(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		String title = this.NewLiveConcertView.getTitle();
		String band = this.NewLiveConcertView.getBand();
		String genre = this.NewLiveConcertView.getGenre();
		int yearOfRelease = this.NewLiveConcertView.getYearOfRelease();
		String format = this.NewLiveConcertView.getFormat();
		double price = this.NewLiveConcertView.getPrice();
		
		LiveConcert liveConcert = new LiveConcert(yearOfRelease, title, genre, price, band, format);
		
		String action = ae.getActionCommand();
		
		if(action.equals("create")) {
		
		Queries liveConcertQueries = new Queries();
		
		Queries.liveConcertClass innerLiveConcert = liveConcertQueries.new liveConcertClass();
		
		boolean newLiveConcert = innerLiveConcert.insertNewLiveConcert(liveConcert);
		
		if(newLiveConcert) {
			this.NewLiveConcertView.dispose();
			JOptionPane.showMessageDialog(null,"New Live Concert " +  liveConcert.getTitle() +  " Successfully Created!");
		}
		
		}
	}

}
