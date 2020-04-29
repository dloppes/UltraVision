package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.CheckPointsView;
import View.TotalPointsView;
import model.Queries;

/**
 * @author Daniel Lopes
 * 
 *         The check Points Controller gets access to the CkeckPointsView,
 *         TotalPointsView and Queries in order to search for the total points
 *         the customer has in his Loyalty card the means how the search is
 *         proceeded is by getting the user email, which is search in the
 *         database and returned the information to the screen.
 */

public class CheckPointsController implements ActionListener {

	CheckPointsView CheckPointsView;
	TotalPointsView TotalPointsView;

	private String email;

	public CheckPointsController() {

		this.CheckPointsView = new CheckPointsView(this);

	}

	public int getTotalOfPoints(String email) {
		/*
		 * This method takes a String as parameter, calls another method which will take
		 * the String passed onto this method in order to return a integer the integer
		 * return from the Queries class is stored and returned in this method whenever
		 * this method is called.
		 */

		Queries searchQuery = new Queries(); // Instance of Query class

		/*
		 * accessing the getCardPoints method that takes a String as parameter and
		 * returns an integer (totalOfPoints)
		 */

		int totalOfPoints = searchQuery.getCardPoints(email);

		return totalOfPoints;

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String action = ae.getActionCommand();

		if (action.equals("search")) {

			this.email = this.CheckPointsView.getEmail();

			int numberOfPoints = getTotalOfPoints(email);

			this.TotalPointsView = new TotalPointsView(numberOfPoints);

		}
	}

}
