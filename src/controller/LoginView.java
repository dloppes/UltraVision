package controller;

import javax.swing.*;
import javax.swing.border.LineBorder;

import View.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class LoginView implements ActionListener {
	JPanel contentPanel;
	JTextField usernameField;
	JPasswordField passwordField;
	LoginController loginController;

	LoginView() {
		loginController = new LoginController();

		JFrame f = new JFrame();

		JTextArea area = new JTextArea();
		area.setBounds(20, 75, 250, 200);
		f.add(area);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 605, 366);

		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(12, 0, 776, 136);
		contentPanel.add(lblNewLabel);

		JLabel lblUser = new JLabel("USER:");
		lblUser.setBackground(new Color(255, 255, 255));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(90, 151, 60, 32);
		contentPanel.add(lblUser);

		usernameField = new JTextField(20);
		lblUser.setLabelFor(usernameField);
		usernameField.setBounds(162, 149, 352, 38);
		contentPanel.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(48, 228, 114, 32);
		contentPanel.add(lblPassword);

		passwordField = new JPasswordField(20);
		passwordField.setBounds(162, 226, 352, 38);
		contentPanel.add(passwordField);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(399, 296, 97, 25);
		btnLogin.addActionListener(this);
		btnLogin.setActionCommand("login");
		contentPanel.add(btnLogin);

		f.setLocationRelativeTo(null);
		f.setUndecorated(true);

		f.setContentPane(contentPanel);
		f.validate();
		f.repaint();

		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		// To keep this MVC, we have username and password here
		// BUT the view should not know about business logic.

		if (e.getActionCommand().equals("login")) {

			String username = usernameField.getText();
			String password = passwordField.getText();

			loginController.login(username, password);

		}

//    String words[]=text.split("\\s");  
//    l1.setText("Words: "+words.length);  
//    l2.setText("Characters: "+text.length());  
	}

	public static void main(String[] args) {
		new LoginView();
	}
}