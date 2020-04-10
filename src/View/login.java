package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.LoginController;
import controller.menuController;
import model.Employee;
import model.userLogged;
import model.Employee.employeeLogin;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;

public class login implements ActionListener {

	JPanel contentPanel;
	JTextField username;
	JPasswordField passwordField;
	//private loginController controller;
	
	// https://www.javatpoint.com/java-jtextarea
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new login();
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					login frame = new login();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public login() {
		
		JFrame loginView = new JFrame();

//		controller = new loginController();
		
		JTextArea area=new JTextArea();  
	    area.setBounds(20,75,250,200);  
	    loginView.add(area);

		loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginView.setBounds(100, 100, 605, 366);
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

		username = new JTextField(20);
		lblUser.setLabelFor(username);
		username.setBounds(162, 149, 352, 38);
		contentPanel.add(username);
		username.setColumns(10);
		

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
		contentPanel.add(btnLogin);
		loginView.setLocationRelativeTo(null);
		loginView.setUndecorated(true);
		btnLogin.addActionListener(this);
		btnLogin.setActionCommand("login");
		
		loginView.setContentPane(contentPanel);
		loginView.validate();
		loginView.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text = username.getText();
//		employee = new Employee();
		String password = passwordField.getText();
//
//		Employee.employeeLogin eLogin = employee.new employeeLogin();
//
//		String username = Login.getUsername();
//		String password = Login.getPassword();
//
//		userLogged user = new userLogged(username, password);
//
//		if (e.getActionCommand().equals("login")) {
//
//			boolean login = eLogin.loginValidator(user);
//
//			if (login) {
//				new menuController();
//				this.Login.dispose();
//
//			}
//
//			else {
//				JOptionPane.showMessageDialog(null, "Username or password Incorrect, try again");
//
//			}
//
//		}
	}

	public String getUsername() {
		return username.getText();
	}

	public String getPassword() {
		return new String(passwordField.getPassword());
	}
}
