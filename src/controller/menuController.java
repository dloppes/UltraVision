package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.menuView;

public class menuController implements ActionListener {

	menuView menuView;

	public menuController() {

		menuView = new menuView(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ac = e.getActionCommand();

		switch (ac) {
		case "newCustomer":
			new newCustomerController();
			break;
		}

	}

}
