package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

import controller.CheckPointsController;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 
 * @author Daniel Lopes
 *
 *         This is the view class for the check points. It will have an email
 *         field that
 */
public class CheckPointsView extends JFrame {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JFrame frame;

	public CheckPointsView(CheckPointsController controllerInternalRef) {

		frame = new JFrame();

		frame.setVisible(true);

		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 648, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CheckPointsView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-130, 0, 473, 151);
		contentPane.add(lblNewLabel);

		JLabel lblLoyaltyCard = new JLabel("+ LOYALTY CARD");
		lblLoyaltyCard.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblLoyaltyCard.setForeground(new Color(189, 183, 107));
		lblLoyaltyCard.setFont(new Font("Verdana", Font.BOLD, 20));
		lblLoyaltyCard.setBounds(406, 53, 210, 39);
		contentPane.add(lblLoyaltyCard);

		JLabel lblEmail = new JLabel("     Email:");
		lblEmail.setBorder(new LineBorder(new Color(189, 183, 107), 2, true));
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(30, 164, 130, 47);
		contentPane.add(lblEmail);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		emailTextField.setBounds(172, 164, 444, 47);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);

		JButton searchButton = new JButton("Search");
		searchButton.setIcon(new ImageIcon(CheckPointsView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchButton.setFont(new Font("Verdana", Font.BOLD, 20));
		searchButton.setBounds(443, 255, 175, 53);
		contentPane.add(searchButton);
		searchButton.addActionListener((ActionListener) controllerInternalRef);
		searchButton.setActionCommand("search");

		frame.validate();
		frame.repaint();
	}

	public String getEmail() {
		return emailTextField.getText();
	}

}
