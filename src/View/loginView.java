package View;

import java.awt.event.ActionListener;

//import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.loginController;
//import Controller.adminLoginController;
import interfaces.View;

public class loginView extends JFrame implements View {

	private JTextField username;
	private JPasswordField password;
	private loginController controllerInternalRef;

	public loginView(loginController controller) {
		
		this.controllerInternalRef = controller;
		attributeSetter();
		components();
		validation();
	}

	@Override
	public void attributeSetter() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		this.setSize(300, 300);
		this.setTitle("Welcome to UltraVision System!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void components() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel();
		this.add(p);

		JLabel user = new JLabel("Username:");
		username = new JTextField(20); // assigning size of text field tf1

		JLabel psw = new JLabel("Password:");
		password = new JPasswordField(20); // assigning size of text field tf2

		JButton login = new JButton("Login"); // login button created
		login.addActionListener((ActionListener) controllerInternalRef); // adding button to action listener
		login.setActionCommand("login");// setting the value that actives action command

		p.add(user); // adding JLabel "user" to the panel
		p.add(username); // adding text field "username" to the panel
		p.add(psw); // adding JLabel "psw" to the panel
		p.add(password); // adding text field "password" to the panel
		p.add(login); // adding button "submit" to the panel

	}

	@Override
	public void validation() {
		// TODO Auto-generated method stub
		this.validate();
		this.repaint();

	}

	public String getUsername() {
		return username.getText();
	}

	public String getPassword() {
		return new String(password.getPassword());
	}
}
