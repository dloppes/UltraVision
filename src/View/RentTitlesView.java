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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class RentTitlesView extends JFrame {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JTextField musiTitleTextField;
	private JTextField movieTitleTextField;
	private JTextField TVBoxTitleTextField;
	private JTextField liveConcertTextField;

	public RentTitlesView() {
		
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		frame.setTitle("Rent TItles");
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1086, 917);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-137, 0, 458, 141);
		contentPane.add(lblNewLabel);
		
		JLabel lblRentMusic = new JLabel("RENT TITLES");
		lblRentMusic.setBackground(new Color(255, 255, 255));
		lblRentMusic.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/credit-card-icon.png")));
		lblRentMusic.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentMusic.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblRentMusic.setForeground(new Color(189, 183, 107));
		lblRentMusic.setFont(new Font("Verdana", Font.BOLD, 20));
		lblRentMusic.setBounds(776, 40, 280, 54);
		contentPane.add(lblRentMusic);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		comboBox.setBounds(12, 194, 626, 54);
		contentPane.add(comboBox);
		
		JButton selectMusicButton = new JButton("SELECT");
		selectMusicButton.setForeground(new Color(128, 128, 0));
		selectMusicButton.setBackground(new Color(255, 255, 240));
		selectMusicButton.setFont(new Font("Verdana", Font.BOLD, 17));
		selectMusicButton.setBounds(650, 209, 104, 31);
		contentPane.add(selectMusicButton);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		emailTextField.setBounds(211, 794, 427, 43);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblCustomerEmail = new JLabel("Customer Email:");
		lblCustomerEmail.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblCustomerEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerEmail.setForeground(new Color(189, 183, 107));
		lblCustomerEmail.setFont(new Font("Verdana", Font.BOLD, 18));
		lblCustomerEmail.setBounds(12, 794, 181, 43);
		contentPane.add(lblCustomerEmail);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		btnSearch.setForeground(new Color(128, 128, 0));
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 17));
		btnSearch.setBackground(new Color(255, 255, 240));
		btnSearch.setBounds(650, 795, 104, 43);
		contentPane.add(btnSearch);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(189, 183, 107));
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTitle.setBounds(235, 138, 142, 43);
		contentPane.add(lblTitle);
		
		musiTitleTextField = new JTextField();
		musiTitleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		musiTitleTextField.setColumns(10);
		musiTitleTextField.setBounds(389, 138, 249, 43);
		contentPane.add(musiTitleTextField);
		
		JLabel lblMusic = new JLabel("MUSIC");
		lblMusic.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/music_menu_icon.png")));
		lblMusic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusic.setForeground(new Color(189, 183, 107));
		lblMusic.setFont(new Font("Verdana", Font.BOLD, 20));
		lblMusic.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblMusic.setBackground(Color.WHITE);
		lblMusic.setBounds(12, 132, 189, 54);
		contentPane.add(lblMusic);
		
		JButton searchMusicButton = new JButton("");
		searchMusicButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchMusicButton.setForeground(new Color(128, 128, 0));
		searchMusicButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchMusicButton.setBackground(new Color(255, 255, 240));
		searchMusicButton.setBounds(650, 138, 104, 43);
		contentPane.add(searchMusicButton);
		
		JLabel lblNewLabel_1 = new JLabel("--------------------------------------------------------------------------");
		lblNewLabel_1.setForeground(new Color(189, 183, 107));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setBounds(13, 261, 741, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMovie = new JLabel("MOVIE");
		lblMovie.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/movies_menu_icon.png")));
		lblMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovie.setForeground(new Color(189, 183, 107));
		lblMovie.setFont(new Font("Verdana", Font.BOLD, 20));
		lblMovie.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblMovie.setBackground(Color.WHITE);
		lblMovie.setBounds(12, 302, 189, 54);
		contentPane.add(lblMovie);
		
		JLabel lblTitle_1 = new JLabel("Title:");
		lblTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_1.setForeground(new Color(189, 183, 107));
		lblTitle_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle_1.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTitle_1.setBounds(235, 308, 142, 43);
		contentPane.add(lblTitle_1);
		
		movieTitleTextField = new JTextField();
		movieTitleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		movieTitleTextField.setColumns(10);
		movieTitleTextField.setBounds(389, 308, 249, 43);
		contentPane.add(movieTitleTextField);
		
		JButton searchMovieButton = new JButton("");
		searchMovieButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchMovieButton.setForeground(new Color(128, 128, 0));
		searchMovieButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchMovieButton.setBackground(new Color(255, 255, 240));
		searchMovieButton.setBounds(650, 308, 104, 43);
		contentPane.add(searchMovieButton);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Verdana", Font.PLAIN, 24));
		comboBox_1.setBounds(12, 364, 626, 54);
		contentPane.add(comboBox_1);
		
		JButton selectMovieButton = new JButton("SELECT");
		selectMovieButton.setForeground(new Color(128, 128, 0));
		selectMovieButton.setFont(new Font("Verdana", Font.BOLD, 17));
		selectMovieButton.setBackground(new Color(255, 255, 240));
		selectMovieButton.setBounds(650, 379, 104, 31);
		contentPane.add(selectMovieButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("--------------------------------------------------------------------------");
		lblNewLabel_1_1.setForeground(new Color(189, 183, 107));
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(13, 431, 741, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblTvBox = new JLabel("TV BOX");
		lblTvBox.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/tvBox_menu_icon.png")));
		lblTvBox.setHorizontalAlignment(SwingConstants.CENTER);
		lblTvBox.setForeground(new Color(189, 183, 107));
		lblTvBox.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTvBox.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTvBox.setBackground(Color.WHITE);
		lblTvBox.setBounds(12, 455, 189, 54);
		contentPane.add(lblTvBox);
		
		JLabel lblTitle_2 = new JLabel("Title:");
		lblTitle_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_2.setForeground(new Color(189, 183, 107));
		lblTitle_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle_2.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTitle_2.setBounds(235, 461, 142, 43);
		contentPane.add(lblTitle_2);
		
		TVBoxTitleTextField = new JTextField();
		TVBoxTitleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		TVBoxTitleTextField.setColumns(10);
		TVBoxTitleTextField.setBounds(389, 461, 249, 43);
		contentPane.add(TVBoxTitleTextField);
		
		JButton searchTVBoxButton = new JButton("");
		searchTVBoxButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchTVBoxButton.setForeground(new Color(128, 128, 0));
		searchTVBoxButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchTVBoxButton.setBackground(new Color(255, 255, 240));
		searchTVBoxButton.setBounds(650, 461, 104, 43);
		contentPane.add(searchTVBoxButton);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Verdana", Font.PLAIN, 24));
		comboBox_2.setBounds(12, 517, 626, 54);
		contentPane.add(comboBox_2);
		
		JButton selectTVBoxButton = new JButton("SELECT");
		selectTVBoxButton.setForeground(new Color(128, 128, 0));
		selectTVBoxButton.setFont(new Font("Verdana", Font.BOLD, 17));
		selectTVBoxButton.setBackground(new Color(255, 255, 240));
		selectTVBoxButton.setBounds(650, 532, 104, 31);
		contentPane.add(selectTVBoxButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("--------------------------------------------------------------------------");
		lblNewLabel_1_2.setForeground(new Color(189, 183, 107));
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(13, 584, 741, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblLiveConcert = new JLabel("LIVE CONCERT");
		lblLiveConcert.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/liveCOncert_menu_icon.png")));
		lblLiveConcert.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveConcert.setForeground(new Color(189, 183, 107));
		lblLiveConcert.setFont(new Font("Verdana", Font.BOLD, 15));
		lblLiveConcert.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblLiveConcert.setBackground(Color.WHITE);
		lblLiveConcert.setBounds(12, 611, 189, 54);
		contentPane.add(lblLiveConcert);
		
		JLabel lblTitle_3 = new JLabel("Title:");
		lblTitle_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_3.setForeground(new Color(189, 183, 107));
		lblTitle_3.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle_3.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTitle_3.setBounds(235, 617, 142, 43);
		contentPane.add(lblTitle_3);
		
		liveConcertTextField = new JTextField();
		liveConcertTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		liveConcertTextField.setColumns(10);
		liveConcertTextField.setBounds(389, 617, 249, 43);
		contentPane.add(liveConcertTextField);
		
		JButton searchTitleButton = new JButton("");
		searchTitleButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchTitleButton.setForeground(new Color(128, 128, 0));
		searchTitleButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchTitleButton.setBackground(new Color(255, 255, 240));
		searchTitleButton.setBounds(650, 617, 104, 43);
		contentPane.add(searchTitleButton);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Verdana", Font.PLAIN, 24));
		comboBox_3.setBounds(12, 678, 626, 54);
		contentPane.add(comboBox_3);
		
		JButton selectLiveConcertButton = new JButton("SELECT");
		selectLiveConcertButton.setForeground(new Color(128, 128, 0));
		selectLiveConcertButton.setFont(new Font("Verdana", Font.BOLD, 17));
		selectLiveConcertButton.setBackground(new Color(255, 255, 240));
		selectLiveConcertButton.setBounds(650, 688, 104, 31);
		contentPane.add(selectLiveConcertButton);
		
		JLabel lblNewLabel_1_3 = new JLabel("--------------------------------------------------------------------------");
		lblNewLabel_1_3.setForeground(new Color(189, 183, 107));
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(13, 745, 741, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblOrderDetails = new JLabel("ORDER DETAILS:");
		lblOrderDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderDetails.setForeground(new Color(189, 183, 107));
		lblOrderDetails.setFont(new Font("Verdana", Font.BOLD, 20));
		lblOrderDetails.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblOrderDetails.setBackground(Color.WHITE);
		lblOrderDetails.setBounds(787, 154, 258, 54);
		contentPane.add(lblOrderDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(189, 183, 107), 2));
		separator.setFont(new Font("Verdana", Font.PLAIN, 18));
		separator.setForeground(new Color(189, 183, 107));
		separator.setBounds(778, 138, 280, 699);
		contentPane.add(separator);
		
		JLabel customerIdLabel = new JLabel("Customer ID:");
		customerIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerIdLabel.setForeground(new Color(189, 183, 107));
		customerIdLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		customerIdLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		customerIdLabel.setBounds(788, 253, 150, 37);
		contentPane.add(customerIdLabel);
		
		JTextArea customerIDTextField = new JTextArea();
		customerIDTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		customerIDTextField.setBounds(947, 253, 98, 37);
		contentPane.add(customerIDTextField);
		
		JLabel rentedDateLabel = new JLabel("Rented Date:");
		rentedDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rentedDateLabel.setForeground(new Color(189, 183, 107));
		rentedDateLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		rentedDateLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		rentedDateLabel.setBounds(789, 439, 150, 37);
		contentPane.add(rentedDateLabel);
		
		JTextArea rentedDateTextField = new JTextArea();
		rentedDateTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		rentedDateTextField.setBounds(951, 439, 95, 37);
		contentPane.add(rentedDateTextField);
		
		JLabel returnDateLabel = new JLabel("Return Date:");
		returnDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		returnDateLabel.setForeground(new Color(189, 183, 107));
		returnDateLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		returnDateLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		returnDateLabel.setBounds(790, 508, 150, 37);
		contentPane.add(returnDateLabel);
		
		JTextArea returnDateTextField = new JTextArea();
		returnDateTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		returnDateTextField.setBounds(952, 508, 95, 37);
		contentPane.add(returnDateTextField);
		
		JLabel loyaltyCardIDLabel = new JLabel("Loyalty Card ID:");
		loyaltyCardIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loyaltyCardIDLabel.setForeground(new Color(189, 183, 107));
		loyaltyCardIDLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		loyaltyCardIDLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		loyaltyCardIDLabel.setBounds(787, 319, 150, 37);
		contentPane.add(loyaltyCardIDLabel);
		
		JTextArea loyaltyCardIDTextField = new JTextArea();
		loyaltyCardIDTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		loyaltyCardIDTextField.setBounds(949, 319, 95, 37);
		contentPane.add(loyaltyCardIDTextField);
		
		JLabel cardPointsEarnedLabel = new JLabel("Card Points Earned:");
		cardPointsEarnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardPointsEarnedLabel.setForeground(new Color(189, 183, 107));
		cardPointsEarnedLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		cardPointsEarnedLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		cardPointsEarnedLabel.setBounds(788, 775, 150, 37);
		contentPane.add(cardPointsEarnedLabel);
		
		JTextArea cardPointsEarnedTextField = new JTextArea();
		cardPointsEarnedTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		cardPointsEarnedTextField.setBounds(950, 775, 95, 37);
		contentPane.add(cardPointsEarnedTextField);
		
		JLabel cardPointsBalanceLabel = new JLabel("Card Points Balance:");
		cardPointsBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardPointsBalanceLabel.setForeground(new Color(189, 183, 107));
		cardPointsBalanceLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		cardPointsBalanceLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		cardPointsBalanceLabel.setBounds(789, 380, 150, 37);
		contentPane.add(cardPointsBalanceLabel);
		
		JTextArea cardPointsBalanceTextField = new JTextArea();
		cardPointsBalanceTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		cardPointsBalanceTextField.setBounds(951, 380, 95, 37);
		contentPane.add(cardPointsBalanceTextField);
		
		JButton payButton = new JButton("   PAY");
		payButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/credit-card-icon.png")));
		payButton.setForeground(new Color(128, 128, 0));
		payButton.setFont(new Font("Verdana", Font.BOLD, 22));
		payButton.setBackground(new Color(255, 255, 240));
		payButton.setBounds(876, 663, 167, 56);
		contentPane.add(payButton);
		
		JLabel totalLabel = new JLabel("Total:");
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setForeground(new Color(189, 183, 107));
		totalLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		totalLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		totalLabel.setBounds(789, 578, 150, 37);
		contentPane.add(totalLabel);
		
		JTextArea totalTextField = new JTextArea();
		totalTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		totalTextField.setBounds(951, 578, 95, 37);
		contentPane.add(totalTextField);
		
		frame.validate();
		frame.repaint();
	}
}
