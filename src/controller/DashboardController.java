package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import View.StockAvailableView;
import View.CheckPointsView;
import View.CustomerListView;
import View.DashboarView;
import View.StockRentedView;

public class DashboardController implements ActionListener {

	DashboarView dashboardView;

	public DashboardController() {

		// menuView = new menuView(this);
		dashboardView = new DashboarView(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ac = e.getActionCommand();

		switch (ac) {
		case "newCustomer":
			try {
				new NewCustomerController();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			break;

		case "updateCustomer":
			new CustomerListView();
			break;

		case "newMusic":
			try {
				new NewMusicController();
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e3);
			}
			break;

		case "newMovie":
			try {
				new NewMovieController();
			} catch (ParseException e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			break;

		case "newLiveConcert":
			try {
				new NewLiveConcertController();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Oops. Something went wrong");
			}
			break;

		case "newTVBox":
			new NewTVBoxController();
			break;

		case "availableTitles":
			new StockAvailableView();
			break;

		case "rentedTitles":
			new StockRentedView();
			break;

		case "searchPoints":
			new CheckPointsController();
			break;
			
		case "rentTitles":
			new RentTitlesController();
			break;

		case "exit":
			System.exit(0);
			new LoginController();
		}

	}

}
