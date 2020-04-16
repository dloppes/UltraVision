package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CheckPointsView extends JFrame {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JTextField totalOfPointsTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckPointsView frame = new CheckPointsView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckPointsView() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 492);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		emailTextField.setBounds(172, 164, 444, 47);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblTotalOfPoints = new JLabel(" Total of Points:");
		lblTotalOfPoints.setForeground(Color.WHITE);
		lblTotalOfPoints.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTotalOfPoints.setBorder(new LineBorder(new Color(189, 183, 107), 2, true));
		lblTotalOfPoints.setBounds(172, 352, 178, 47);
		contentPane.add(lblTotalOfPoints);
		
		totalOfPointsTextField = new JTextField();
		totalOfPointsTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		totalOfPointsTextField.setBounds(377, 352, 239, 47);
		contentPane.add(totalOfPointsTextField);
		totalOfPointsTextField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(CheckPointsView.class.getResource("/img/checkPoints_menu_icon.png")));
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 20));
		btnSearch.setBounds(441, 243, 175, 53);
		contentPane.add(btnSearch);
	}

}
