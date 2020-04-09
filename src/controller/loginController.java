package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.loginView;
import model.Employee;
import model.userLogged;
import model.connection;

public class loginController implements ActionListener {

	
	loginView loginView;
	Employee employee;

	public loginController() {
	
		loginView = new loginView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		employee = new Employee();

		Employee.employeeLogin eLogin = employee.new employeeLogin();

		String username = loginView.getUsername();
		String password = loginView.getPassword();

		userLogged user = new userLogged(username, password);

		if (e.getActionCommand().equals("login")) {

			boolean login = eLogin.loginValidator(user);

			if (login) {
				new menuController();
				this.loginView.dispose();

			}

			else {
				JOptionPane.showMessageDialog(null, "Username or password Incorrect, try again");

			}

		}
	}

}
