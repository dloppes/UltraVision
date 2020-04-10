package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.login;
import View.loginView;
import model.Employee;
import model.userLogged;

public class LoginController {

//	loginView loginView;
//	login Loginview;
	Employee employee;

	public void login(String username, String password) {

		employee = new Employee();

		Employee.employeeLogin eLogin = employee.new employeeLogin();

		userLogged user = new userLogged(username, password);

		boolean login = eLogin.loginValidator(user);

		if (login) {
			new menuController();
			//Loginview

		}

		else {
			JOptionPane.showMessageDialog(null, "Username or password Incorrect, try again");

		}

	}

}
