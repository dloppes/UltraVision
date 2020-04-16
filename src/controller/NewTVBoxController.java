package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.NewTVBoxView;
import model.Queries;
import model.TVBox;

public class NewTVBoxController implements ActionListener {

	NewTVBoxView NewTVBoxView;

	public NewTVBoxController() {

		this.NewTVBoxView = new NewTVBoxView(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		String title = this.NewTVBoxView.getTitle();
		int season = this.NewTVBoxView.getSeason();
		int numberOfDisks = this.NewTVBoxView.getNumberOfDisks();
		double price = this.NewTVBoxView.getPrice();

		TVBox tvBox = new TVBox(title, season, numberOfDisks, price);

		String action = ae.getActionCommand();

		if (action.equals("create")) {

			Queries tvBoxQuery = new Queries();

			Queries.tvBoxClass innerTVBox = tvBoxQuery.new tvBoxClass();

			boolean newTVBox = innerTVBox.insertNewTVBox(tvBox);

			if (newTVBox) {
				this.NewTVBoxView.dispose();
				JOptionPane.showMessageDialog(null, "TV Box " + tvBox.getTitle() + " sucessfully Registered!");
			}
		}

	}

}
