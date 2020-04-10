package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.LoginView;
import model.Employee;
import model.userLogged;

public class LoginController implements ActionListener {

//	loginView loginView;
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
//			loginview.contentPanel.setVisible(false);
			loginview.f.setVisible(false);
			new menuController();
			
		}

		else {
			JOptionPane.showMessageDialog(null, "Username or password Incorrect, try again");

		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
