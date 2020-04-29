package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.NewTVBoxView;
import model.Queries;
import model.TVBox;

/**
 * 
 * @author Daniel Lopes
 * 
 *         Controller created to gather the information from New Music View
 *         class and Queries, so that I new TVBox object is created and insert
 *         into the database
 *
 */
public class NewTVBoxController implements ActionListener {

	NewTVBoxView NewTVBoxView;

	public NewTVBoxController() {

		this.NewTVBoxView = new NewTVBoxView(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		/*
		 * The information that the user types in the screen text field is retrieved and
		 * saved within those variables. After storing them in the variable I can use
		 * each variable to create my TVBox object *
		 */

		String title = this.NewTVBoxView.getTitle();
		int season = this.NewTVBoxView.getSeason();
		int numberOfDisks = this.NewTVBoxView.getNumberOfDisks();
		double price = this.NewTVBoxView.getPrice();
		String format = this.NewTVBoxView.getFormat();

		TVBox tvBox = new TVBox(title, season, numberOfDisks, price, format);

		String action = ae.getActionCommand();

		if (action.equals("create")) {

			Queries tvBoxQuery = new Queries(); // instance of Query in order to access its methods and inner classes

			Queries.tvBoxClass innerTVBox = tvBoxQuery.new tvBoxClass(); // accessing TVBox inner class

			boolean newTVBox = innerTVBox.insertNewTVBox(tvBox); /*
																	 * within music Inner class accessing the method to
																	 * insert new TVBox that receives a music object
																	 */

			if (newTVBox) {
				this.NewTVBoxView.dispose();
				JOptionPane.showMessageDialog(null, "TV Box " + tvBox.getTitle() + " sucessfully Registered!");
			}
		}

	}

}
