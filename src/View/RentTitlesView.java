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

import controller.RentTitlesController;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class RentTitlesView extends JFrame{

	private JPanel contentPane;
	private JTextField musicTitleTextField;
	private JTextField movieTitleTextField;
	private JTextField TVBoxTitleTextField;
	private JTextField liveConcertTextField;
	private JComboBox<Object> musicComboBox;
	private JComboBox<Object> customerEmailComboBox;
	private JComboBox<Object> movieComboBox;
	private JComboBox<Object> TVBoxComboBox;
	private JComboBox<Object> liveConcertComboBox;
	private RentTitlesController controllerInternalRef;
	private JTextField emailTextField;
	private JTextArea customerIDTextField;
	private JTextArea loyaltyCardIDTextField;
	private JTextArea cardPointsBalanceTextField;

	public RentTitlesView(RentTitlesController controllerInternalRef) {

		this.controllerInternalRef = controllerInternalRef;

		JFrame frame = new JFrame();

		frame.setVisible(true);
		frame.setTitle("Rent TItles");
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1089, 973);
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

		musicComboBox = new JComboBox<Object>();
		musicComboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		musicComboBox.setBounds(12, 375, 626, 54);
		contentPane.add(musicComboBox);

		JButton selectMusicButton = new JButton("SELECT");
		selectMusicButton.setForeground(new Color(128, 128, 0));
		selectMusicButton.setBackground(new Color(255, 255, 240));
		selectMusicButton.setFont(new Font("Verdana", Font.BOLD, 15));
		selectMusicButton.setBounds(650, 390, 104, 31);
		contentPane.add(selectMusicButton);
		selectMusicButton.addActionListener((ActionListener) this.controllerInternalRef);
		selectMusicButton.setActionCommand("selectMusic");

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(189, 183, 107));
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTitle.setBounds(235, 319, 142, 43);
		contentPane.add(lblTitle);

		musicTitleTextField = new JTextField();
		musicTitleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		musicTitleTextField.setColumns(10);
		musicTitleTextField.setBounds(389, 319, 249, 43);
		contentPane.add(musicTitleTextField);

		JLabel lblMusic = new JLabel("MUSIC");
		lblMusic.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/music_menu_icon.png")));
		lblMusic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusic.setForeground(new Color(189, 183, 107));
		lblMusic.setFont(new Font("Verdana", Font.BOLD, 20));
		lblMusic.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblMusic.setBackground(Color.WHITE);
		lblMusic.setBounds(12, 313, 189, 54);
		contentPane.add(lblMusic);

		JButton searchMusicButton = new JButton("");
		searchMusicButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchMusicButton.setForeground(new Color(128, 128, 0));
		searchMusicButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchMusicButton.setBackground(new Color(255, 255, 240));
		searchMusicButton.setBounds(650, 319, 104, 43);
		contentPane.add(searchMusicButton);
		searchMusicButton.addActionListener((ActionListener) this.controllerInternalRef);
		searchMusicButton.setActionCommand("searchMusic");

		JLabel lblNewLabel_1 = new JLabel("--------------------------------------------------------------------------");
		lblNewLabel_1.setForeground(new Color(189, 183, 107));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setBounds(13, 442, 741, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblMovie = new JLabel("MOVIE");
		lblMovie.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/movies_menu_icon.png")));
		lblMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovie.setForeground(new Color(189, 183, 107));
		lblMovie.setFont(new Font("Verdana", Font.BOLD, 20));
		lblMovie.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblMovie.setBackground(Color.WHITE);
		lblMovie.setBounds(12, 483, 189, 54);
		contentPane.add(lblMovie);

		JLabel searchMovieLabel = new JLabel("Title:");
		searchMovieLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchMovieLabel.setForeground(new Color(189, 183, 107));
		searchMovieLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		searchMovieLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		searchMovieLabel.setBounds(235, 489, 142, 43);
		contentPane.add(searchMovieLabel);

		movieTitleTextField = new JTextField();
		movieTitleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		movieTitleTextField.setColumns(10);
		movieTitleTextField.setBounds(389, 489, 249, 43);
		contentPane.add(movieTitleTextField);

		JButton searchMovieButton = new JButton("");
		searchMovieButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchMovieButton.setForeground(new Color(128, 128, 0));
		searchMovieButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchMovieButton.setBackground(new Color(255, 255, 240));
		searchMovieButton.setBounds(650, 489, 104, 43);
		contentPane.add(searchMovieButton);
		searchMovieButton.addActionListener((ActionListener) this.controllerInternalRef);
		searchMovieButton.setActionCommand("searchMovie");

		movieComboBox = new JComboBox<Object>();
		movieComboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		movieComboBox.setBounds(12, 545, 626, 54);
		contentPane.add(movieComboBox);

		JButton selectMovieButton = new JButton("SELECT");
		selectMovieButton.setForeground(new Color(128, 128, 0));
		selectMovieButton.setFont(new Font("Verdana", Font.BOLD, 15));
		selectMovieButton.setBackground(new Color(255, 255, 240));
		selectMovieButton.setBounds(650, 560, 104, 31);
		contentPane.add(selectMovieButton);
		selectMovieButton.addActionListener((ActionListener) this.controllerInternalRef);
		selectMovieButton.setActionCommand("selectMovie");

		JLabel lblNewLabel_1_1 = new JLabel(
				"--------------------------------------------------------------------------");
		lblNewLabel_1_1.setForeground(new Color(189, 183, 107));
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(13, 612, 741, 16);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblTvBox = new JLabel("TV BOX");
		lblTvBox.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/tvBox_menu_icon.png")));
		lblTvBox.setHorizontalAlignment(SwingConstants.CENTER);
		lblTvBox.setForeground(new Color(189, 183, 107));
		lblTvBox.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTvBox.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblTvBox.setBackground(Color.WHITE);
		lblTvBox.setBounds(12, 636, 189, 54);
		contentPane.add(lblTvBox);

		JLabel searchTVBoxLabel = new JLabel("Title:");
		searchTVBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchTVBoxLabel.setForeground(new Color(189, 183, 107));
		searchTVBoxLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		searchTVBoxLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		searchTVBoxLabel.setBounds(235, 642, 142, 43);
		contentPane.add(searchTVBoxLabel);

		TVBoxTitleTextField = new JTextField();
		TVBoxTitleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		TVBoxTitleTextField.setColumns(10);
		TVBoxTitleTextField.setBounds(389, 642, 249, 43);
		contentPane.add(TVBoxTitleTextField);

		JButton searchTVBoxButton = new JButton("");
		searchTVBoxButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchTVBoxButton.setForeground(new Color(128, 128, 0));
		searchTVBoxButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchTVBoxButton.setBackground(new Color(255, 255, 240));
		searchTVBoxButton.setBounds(650, 642, 104, 43);
		contentPane.add(searchTVBoxButton);
		searchTVBoxButton.addActionListener((ActionListener) this.controllerInternalRef);
		searchTVBoxButton.setActionCommand("searchTVBox");

		TVBoxComboBox = new JComboBox<Object>();
		TVBoxComboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		TVBoxComboBox.setBounds(12, 698, 626, 54);
		contentPane.add(TVBoxComboBox);

		JButton selectTVBoxButton = new JButton("SELECT");
		selectTVBoxButton.setForeground(new Color(128, 128, 0));
		selectTVBoxButton.setFont(new Font("Verdana", Font.BOLD, 15));
		selectTVBoxButton.setBackground(new Color(255, 255, 240));
		selectTVBoxButton.setBounds(650, 713, 104, 31);
		contentPane.add(selectTVBoxButton);
		selectTVBoxButton.addActionListener((ActionListener) this.controllerInternalRef);
		selectTVBoxButton.setActionCommand("selectTVBox");

		JLabel lblNewLabel_1_2 = new JLabel(
				"--------------------------------------------------------------------------");
		lblNewLabel_1_2.setForeground(new Color(189, 183, 107));
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(13, 765, 741, 16);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblLiveConcert = new JLabel("LIVE CONCERT");
		lblLiveConcert.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/liveCOncert_menu_icon.png")));
		lblLiveConcert.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveConcert.setForeground(new Color(189, 183, 107));
		lblLiveConcert.setFont(new Font("Verdana", Font.BOLD, 15));
		lblLiveConcert.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblLiveConcert.setBackground(Color.WHITE);
		lblLiveConcert.setBounds(12, 792, 189, 54);
		contentPane.add(lblLiveConcert);

		JLabel searchLiveConcertLabel = new JLabel("Title:");
		searchLiveConcertLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLiveConcertLabel.setForeground(new Color(189, 183, 107));
		searchLiveConcertLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		searchLiveConcertLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		searchLiveConcertLabel.setBounds(235, 798, 142, 43);
		contentPane.add(searchLiveConcertLabel);

		liveConcertTextField = new JTextField();
		liveConcertTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		liveConcertTextField.setColumns(10);
		liveConcertTextField.setBounds(389, 798, 249, 43);
		contentPane.add(liveConcertTextField);

		JButton searchLiveConcertButton = new JButton("");
		searchLiveConcertButton
				.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchLiveConcertButton.setForeground(new Color(128, 128, 0));
		searchLiveConcertButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchLiveConcertButton.setBackground(new Color(255, 255, 240));
		searchLiveConcertButton.setBounds(650, 798, 104, 43);
		contentPane.add(searchLiveConcertButton);
		searchLiveConcertButton.addActionListener((ActionListener) this.controllerInternalRef);
		searchLiveConcertButton.setActionCommand("searchLiveConcert");

		liveConcertComboBox = new JComboBox<Object>();
		liveConcertComboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		liveConcertComboBox.setBounds(12, 859, 626, 54);
		contentPane.add(liveConcertComboBox);

		JButton selectLiveConcertButton = new JButton("SELECT");
		selectLiveConcertButton.setForeground(new Color(128, 128, 0));
		selectLiveConcertButton.setFont(new Font("Verdana", Font.BOLD, 15));
		selectLiveConcertButton.setBackground(new Color(255, 255, 240));
		selectLiveConcertButton.setBounds(650, 869, 104, 31);
		contentPane.add(selectLiveConcertButton);
		selectLiveConcertButton.addActionListener((ActionListener) this.controllerInternalRef);
		selectLiveConcertButton.setActionCommand("selectLiveConcert");

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
		separator.setBounds(778, 138, 281, 775);
		contentPane.add(separator);

		JLabel customerIdLabel = new JLabel("Customer ID:");
		customerIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerIdLabel.setForeground(new Color(189, 183, 107));
		customerIdLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		customerIdLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		customerIdLabel.setBounds(788, 253, 150, 37);
		contentPane.add(customerIdLabel);

		customerIDTextField = new JTextArea();
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

		loyaltyCardIDTextField = new JTextArea();
		loyaltyCardIDTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		loyaltyCardIDTextField.setBounds(949, 319, 95, 37);
		contentPane.add(loyaltyCardIDTextField);

		JLabel cardPointsEarnedLabel = new JLabel("Card Points Earned:");
		cardPointsEarnedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardPointsEarnedLabel.setForeground(new Color(189, 183, 107));
		cardPointsEarnedLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		cardPointsEarnedLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		cardPointsEarnedLabel.setBounds(787, 850, 150, 37);
		contentPane.add(cardPointsEarnedLabel);

		JTextArea cardPointsEarnedTextField = new JTextArea();
		cardPointsEarnedTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		cardPointsEarnedTextField.setBounds(949, 850, 95, 37);
		contentPane.add(cardPointsEarnedTextField);

		JLabel cardPointsBalanceLabel = new JLabel("Card Points Balance:");
		cardPointsBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardPointsBalanceLabel.setForeground(new Color(189, 183, 107));
		cardPointsBalanceLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		cardPointsBalanceLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		cardPointsBalanceLabel.setBounds(789, 380, 150, 37);
		contentPane.add(cardPointsBalanceLabel);

		cardPointsBalanceTextField = new JTextArea();
		cardPointsBalanceTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		cardPointsBalanceTextField.setBounds(951, 380, 95, 37);
		contentPane.add(cardPointsBalanceTextField);

		JButton payButton = new JButton("   PAY");
		payButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/credit-card-icon.png")));
		payButton.setForeground(new Color(128, 128, 0));
		payButton.setFont(new Font("Verdana", Font.BOLD, 22));
		payButton.setBackground(new Color(255, 255, 240));
		payButton.setBounds(878, 739, 167, 56);
		contentPane.add(payButton);
		payButton.addActionListener((ActionListener) this.controllerInternalRef);
		payButton.setActionCommand("pay");

		JLabel totalLabel = new JLabel("Total:");
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalLabel.setForeground(new Color(189, 183, 107));
		totalLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		totalLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		totalLabel.setBounds(788, 659, 150, 37);
		contentPane.add(totalLabel);

		JTextArea totalTextField = new JTextArea();
		totalTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		totalTextField.setBounds(950, 659, 95, 37);
		contentPane.add(totalTextField);

		JLabel discountLabel = new JLabel("Discount:");
		discountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		discountLabel.setForeground(new Color(189, 183, 107));
		discountLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		discountLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		discountLabel.setBounds(787, 584, 150, 37);
		contentPane.add(discountLabel);

		JTextArea discountTextField = new JTextArea();
		discountTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		discountTextField.setBounds(949, 584, 95, 37);
		contentPane.add(discountTextField);

		JLabel lblCustomerEmail = new JLabel("Customer Email:");
		lblCustomerEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerEmail.setForeground(new Color(189, 183, 107));
		lblCustomerEmail.setFont(new Font("Verdana", Font.BOLD, 18));
		lblCustomerEmail.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblCustomerEmail.setBounds(12, 138, 181, 43);
		contentPane.add(lblCustomerEmail);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		emailTextField.setColumns(10);
		emailTextField.setBounds(211, 138, 427, 43);
		contentPane.add(emailTextField);

		customerEmailComboBox = new JComboBox<Object>();
		customerEmailComboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		customerEmailComboBox.setBounds(12, 196, 626, 54);
		contentPane.add(customerEmailComboBox);

		JButton searchEmailButton = new JButton("");
		searchEmailButton.setIcon(new ImageIcon(RentTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		searchEmailButton.setForeground(new Color(128, 128, 0));
		searchEmailButton.setFont(new Font("Verdana", Font.BOLD, 17));
		searchEmailButton.setBackground(new Color(255, 255, 240));
		searchEmailButton.setActionCommand("searchEmail");
		searchEmailButton.setBounds(650, 139, 104, 43);
		contentPane.add(searchEmailButton);
		searchEmailButton.addActionListener((ActionListener) controllerInternalRef);
		searchEmailButton.setActionCommand("searchCustomer");

		JButton selectCustomerButton = new JButton("SELECT");
		selectCustomerButton.setForeground(new Color(128, 128, 0));
		selectCustomerButton.setFont(new Font("Verdana", Font.BOLD, 15));
		selectCustomerButton.setBackground(new Color(255, 255, 240));
		selectCustomerButton.setBounds(650, 206, 104, 31);
		contentPane.add(selectCustomerButton);
		selectCustomerButton.addActionListener((ActionListener) controllerInternalRef);
		selectCustomerButton.setActionCommand("selectCustomer");

		JLabel lblNewLabel_1_3 = new JLabel(
				"--------------------------------------------------------------------------");
		lblNewLabel_1_3.setForeground(new Color(189, 183, 107));
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(14, 264, 741, 16);
		contentPane.add(lblNewLabel_1_3);

		frame.validate();
		frame.repaint();
	}
	
	public void setCardPointsBalance(String cardPoints) {
		this.cardPointsBalanceTextField.setText(cardPoints);
	}
	
	public void setLoyaltyCardID(String cardID) {
		this.loyaltyCardIDTextField.setText(cardID);
	}
	
	public void setCustomerIDTextField(String customerID) {
		this.customerIDTextField.setText(customerID);
	}

	public JComboBox<Object> getLiveTVBox() {
		return TVBoxComboBox;
	}

	public JComboBox<Object> getLiveConcertComboBox() {
		return liveConcertComboBox;
	}

	public JComboBox<Object> getMovieComboBox() {
		return movieComboBox;
	}

	public JComboBox<Object> getCustomerEmailComboBox() {
		return customerEmailComboBox;
	}

	public JComboBox<Object> getMusicComboBox() {
		return musicComboBox;
	}

	public void setMusicComboBox(JComboBox<Object> musicComboBox) {
		this.musicComboBox = musicComboBox;
	}

	public String getEmailTextField() {
		return emailTextField.getText();
	}

	public String getMusicTitleTextField() {
		return musicTitleTextField.getText();
	}

	public String getMovieTitleTextField() {
		return movieTitleTextField.getText();
	}

	public String getTVBoxTitleTextField() {
		return TVBoxTitleTextField.getText();
	}

	public String getLiveConcertTextField() {
		return liveConcertTextField.getText();
	}

}
