package controller;

import javax.swing.JOptionPane;

import View.LoginView;
import model.Employee;
import model.userLogged;

/**
 * 
 * @author Daniel Lopes
 * 
 *         Login that verifies if the employee credentials match the one in the
 *         database
 *
 */
public class LoginController {

	LoginView loginview;
	Employee employee;

	public LoginController() {
		loginview = new LoginView();
	}

	public void login(String username, String password) {

		employee = new Employee();

		Employee.employeeLogin eLogin = employee.new employeeLogin();

		userLogged user = new userLogged(username, password);

		boolean login = eLogin.loginValidator(user);

		if (login) {
		
			new DashboardController();

			
		}

		else {
			JOptionPane.showMessageDialog(null, "Username or password Incorrect, try again");

		}

	}

}
