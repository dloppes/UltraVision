package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			new NewCustomerController();
			break;

		case "updateCustomer":
			new CustomerListView();
			break;

		case "newMusic":
			new NewMusicController();
			break;

		case "newMovie":
			new NewMovieController();
			break;

		case "newLiveConcert":
			new NewLiveConcertController();
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
