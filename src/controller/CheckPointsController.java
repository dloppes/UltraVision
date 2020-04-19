package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.CheckPointsView;
import View.TotalPointsView;
import model.Queries;

public class CheckPointsController implements ActionListener {

	CheckPointsView CheckPointsView;
	TotalPointsView TotalPointsView;

	private String email;

	public CheckPointsController() {

		this.CheckPointsView = new CheckPointsView(this);

	}

	public int getTotalOfPoints(String email) {

		Queries searchQuery = new Queries();

		int totalOfPoints = searchQuery.getCardPoints(email);

		return totalOfPoints;

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		String action = ae.getActionCommand();

		if (action.equals("search")) {

			this.email = this.CheckPointsView.getEmail();

			int numberOfPoints = getTotalOfPoints(email);

			this.TotalPointsView = new TotalPointsView(numberOfPoints);

		}
	}

}
