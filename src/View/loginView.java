package View;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controller.LoginController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
/**
 * 
 * @author Daniel Lopes
 *
 */
public class LoginView implements ActionListener {
	
	JPanel contentPane;
	JTextField usernameField;
	JPasswordField passwordField;
	LoginController loginController;

	
	public LoginView() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JTextArea area = new JTextArea();
		area.setBounds(20, 75, 250, 200);
		f.getContentPane().add(area);
		f.setBounds(100, 100, 605, 366);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(12, 0, 776, 136);
		contentPane.add(lblNewLabel);

		JLabel lblUser = new JLabel("USER:");
		lblUser.setBackground(new Color(255, 255, 255));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(90, 151, 60, 32);
		contentPane.add(lblUser);

		usernameField = new JTextField(20);
		usernameField.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblUser.setLabelFor(usernameField);
		usernameField.setBounds(162, 149, 352, 38);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(48, 228, 114, 32);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField(20);
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 18));
		passwordField.setBounds(162, 226, 352, 38);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(399, 296, 97, 25);
		btnLogin.addActionListener(this);
		btnLogin.setActionCommand("login");
		contentPane.add(btnLogin);

		f.setLocationRelativeTo(null);
		f.setUndecorated(true);

		f.setContentPane(contentPane);
		f.validate();
		f.repaint();

		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		loginController = new LoginController();

		if (e.getActionCommand().equals("login")) {

			String username = usernameField.getText();
			String password = passwordField.getText();

			loginController.login(username, password);

		}

	}

}