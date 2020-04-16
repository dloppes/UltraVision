package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.CustomerListView;
import View.DashboarView;

public class DashboardController implements ActionListener {

	DashboarView dashboardView;

	public DashboardController() {

		// menuView = new menuView(this);
		dashboardView = new DashboarView(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		}

	}

}
