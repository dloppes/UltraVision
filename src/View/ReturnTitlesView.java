package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;

import model.Customer;
import model.Queries;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class ReturnTitlesView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JTable liveConcertTable;
	private JTextField returnDateLiveConcertTextField;
	private JTable TVBoxTable;
	private JTextField tvBoxReturnDateTextField;
	private JTextField MovieReturnDateTextField;
	private JTextField MusicReturnDateTextField;
	private JTable MovieTable;
	private JTable Musictable;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1_1;
	private JScrollPane scrollPane_1_2;

	public ReturnTitlesView() {

		JFrame frame = new JFrame();
		frame.setVisible(true);

		frame.setBounds(100, 100, 952, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-137, 0, 453, 157);
		lblNewLabel.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/logo3-removebg-preview.png")));
		contentPane.add(lblNewLabel);

		JLabel lblReturnTitles = new JLabel("RETURN TITLES");
		lblReturnTitles.setBounds(649, 52, 225, 47);
		lblReturnTitles.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblReturnTitles.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/titles.png")));
		lblReturnTitles.setFont(new Font("Verdana", Font.BOLD, 18));
		lblReturnTitles.setForeground(new Color(189, 183, 107));
		contentPane.add(lblReturnTitles);

		JLabel lblCustomerEmail = new JLabel("Customer email:");
		lblCustomerEmail.setBounds(32, 132, 166, 35);
		lblCustomerEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerEmail.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCustomerEmail.setForeground(new Color(189, 183, 107));
		contentPane.add(lblCustomerEmail);

		emailTextField = new JTextField();
		emailTextField.setBounds(215, 128, 505, 48);
		emailTextField.setFont(new Font("Verdana", Font.PLAIN, 16));
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 196, 505, 68);
		contentPane.add(scrollPane);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(742, 129, 132, 47);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/checkPoints_menu_icon.png")));
		contentPane.add(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.setActionCommand("search");

		JButton selectLiveConcertButton = new JButton("SELECT");
		selectLiveConcertButton.setBounds(742, 229, 132, 35);
		selectLiveConcertButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectLiveConcertButton.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/Sign-Select-icon.png")));
		contentPane.add(selectLiveConcertButton);
		selectLiveConcertButton.addActionListener((ActionListener) this);
		selectLiveConcertButton.setActionCommand("selectLiveConcert");

		JLabel liveConcertLabel = new JLabel("Live Concert");
		liveConcertLabel.setBounds(12, 199, 186, 50);
		liveConcertLabel.setHorizontalAlignment(SwingConstants.CENTER);
		liveConcertLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		liveConcertLabel.setForeground(new Color(189, 183, 107));
		liveConcertLabel.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/liveCOncert_menu_icon.png")));
		contentPane.add(liveConcertLabel);

		JLabel lblTvBox = new JLabel("TV Box");
		lblTvBox.setBounds(12, 291, 186, 50);
		lblTvBox.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/tvBox_menu_icon.png")));
		lblTvBox.setHorizontalAlignment(SwingConstants.CENTER);
		lblTvBox.setForeground(new Color(189, 183, 107));
		lblTvBox.setFont(new Font("Verdana", Font.BOLD, 17));
		contentPane.add(lblTvBox);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(215, 288, 505, 68);
		contentPane.add(scrollPane_1);

		returnDateLiveConcertTextField = new JTextField();
		returnDateLiveConcertTextField.setBounds(742, 194, 132, 29);
		returnDateLiveConcertTextField.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(returnDateLiveConcertTextField);
		returnDateLiveConcertTextField.setColumns(10);

		tvBoxReturnDateTextField = new JTextField();
		tvBoxReturnDateTextField.setBounds(742, 291, 132, 29);
		tvBoxReturnDateTextField.setFont(new Font("Verdana", Font.PLAIN, 15));
		tvBoxReturnDateTextField.setColumns(10);
		contentPane.add(tvBoxReturnDateTextField);

		JButton tvBoxSelectButton = new JButton("SELECT");
		tvBoxSelectButton.setBounds(742, 326, 132, 35);
		tvBoxSelectButton.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/Sign-Select-icon.png")));
		tvBoxSelectButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		tvBoxSelectButton.setActionCommand("select");
		contentPane.add(tvBoxSelectButton);
		tvBoxSelectButton.addActionListener((ActionListener) this);
		tvBoxSelectButton.setActionCommand("selectTVBox");

		JLabel lblMovie = new JLabel("Movie");
		lblMovie.setBounds(12, 387, 186, 50);
		lblMovie.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/movies_menu_icon.png")));
		lblMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovie.setForeground(new Color(189, 183, 107));
		lblMovie.setFont(new Font("Verdana", Font.BOLD, 17));
		contentPane.add(lblMovie);

		scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(215, 384, 505, 68);
		contentPane.add(scrollPane_1_1);

		MovieReturnDateTextField = new JTextField();
		MovieReturnDateTextField.setBounds(742, 387, 132, 29);
		MovieReturnDateTextField.setFont(new Font("Verdana", Font.PLAIN, 15));
		MovieReturnDateTextField.setColumns(10);
		contentPane.add(MovieReturnDateTextField);

		JButton movieSelectButton = new JButton("SELECT");
		movieSelectButton.setBounds(742, 422, 132, 35);
		movieSelectButton.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/Sign-Select-icon.png")));
		movieSelectButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		movieSelectButton.setActionCommand("select");
		contentPane.add(movieSelectButton);
		movieSelectButton.addActionListener((ActionListener) this);
		movieSelectButton.setActionCommand("selectMovie");

		JLabel MusicLabel = new JLabel("Music");
		MusicLabel.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/music_menu_icon.png")));
		MusicLabel.setBounds(12, 482, 186, 50);
		MusicLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MusicLabel.setForeground(new Color(189, 183, 107));
		MusicLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		contentPane.add(MusicLabel);

		scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(215, 479, 505, 68);
		contentPane.add(scrollPane_1_2);

		MusicReturnDateTextField = new JTextField();
		MusicReturnDateTextField.setBounds(742, 482, 132, 29);
		MusicReturnDateTextField.setFont(new Font("Verdana", Font.PLAIN, 15));
		MusicReturnDateTextField.setColumns(10);
		contentPane.add(MusicReturnDateTextField);

		JButton musicSelectButton = new JButton("SELECT");
		musicSelectButton.setIcon(new ImageIcon(ReturnTitlesView.class.getResource("/img/Sign-Select-icon.png")));
		musicSelectButton.setBounds(742, 517, 132, 35);
		musicSelectButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		musicSelectButton.setActionCommand("select");
		contentPane.add(musicSelectButton);
		musicSelectButton.addActionListener((ActionListener) this);
		musicSelectButton.setActionCommand("selectMusic");

		frame.validate();
		frame.repaint();
	}

	public String getMovieReturnDate() {
		return MovieReturnDateTextField.getText();
	}

	public String getLiveConcertReturnDate() {
		return returnDateLiveConcertTextField.getText();

	}

	public String getMusicReturnDate() {
		return MusicReturnDateTextField.getText();
	}

	public String getTVBoxReturnDate() {
		return tvBoxReturnDateTextField.getText();
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		/*
		 * when search is clicked it will call a method that will search into the
		 * database and returns a String of 2Darray
		 */

		Queries query = new Queries();
		Queries.customerClass customerInner = query.new customerClass();
		Queries.tvBoxClass tvBoxInner = query.new tvBoxClass();
		Queries.liveConcertClass liveConcertInner = query.new liveConcertClass();
		Queries.movieClass movieInner = query.new movieClass();
		Queries.musicClass musicInner = query.new musicClass();

		if (action.getActionCommand().equals("search")) {

			Customer customer = customerInner.getCustomer(emailTextField.getText());

			LocalDate todaysDate = LocalDate.now();
			DateTimeFormatter dateFormatted = DateTimeFormatter
					.ofPattern("dd-MM-yyyy"); /*
												 * formatting the text to look similar to Europe Standard
												 */
			tvBoxReturnDateTextField.setText(todaysDate.format(dateFormatted)); // then passing the value formatted to
																				// the date field
			MovieReturnDateTextField.setText(todaysDate.format(dateFormatted));
			MusicReturnDateTextField.setText(todaysDate.format(dateFormatted));
			returnDateLiveConcertTextField.setText(todaysDate.format(dateFormatted));

			/* Populate TVBox table */

			String[] tvBoxColumnNames = new String[] { "Title ID", "Title", "Rented Date" };

			String[][] tvBoxData = new String[100][tvBoxColumnNames.length];

			tvBoxData = tvBoxInner.getAllRentedTVBoxByCustomer(customer.getCustomerID());

			TVBoxTable = new JTable(tvBoxData, tvBoxColumnNames);
			scrollPane_1.setViewportView(TVBoxTable);

			/* Populates LiveConcert Table */

			String[] liveConcertColumnNames = new String[] { "Band ID", "Title", "Rented Date" };

			String[][] liveConcertData = new String[100][liveConcertColumnNames.length];

			liveConcertData = liveConcertInner.getAllRentedLiveConcertByCustomer(customer.getCustomerID());
			liveConcertTable = new JTable(liveConcertData, liveConcertColumnNames);
			scrollPane.setViewportView(liveConcertTable);

			/* Populates Movie Table */

			String[] movieColumnNames = new String[] { "Movie ID", "Title", "Rented Date" };

			String[][] movieData = new String[100][movieColumnNames.length];

			movieData = movieInner.getAllRentedMovieByCustomer(customer.getCustomerID());
			MovieTable = new JTable(movieData, movieColumnNames);
			scrollPane_1_1.setViewportView(MovieTable);

			/* Populates Music Table */

			String[] musicColumnNames = new String[] { "Music ID", "Title", "Rented Date" };

			String[][] musicData = new String[100][musicColumnNames.length];

			musicData = musicInner.getAllRentedMusicByCustomer(customer.getCustomerID());

			Musictable = new JTable(musicData, musicColumnNames);
			scrollPane_1_2.setViewportView(Musictable);

		}
		if (action.getActionCommand().equals("selectMusic")) {

			int row = Musictable.getSelectedRow();
			String musicID = Musictable.getValueAt(row, 0).toString();

			boolean returnDateInserted = musicInner.updateReturnDate(musicID, this.getMusicReturnDate());
			boolean titleAvailableAgain = musicInner.UpdateMusicToAvailable(musicID);

			if (returnDateInserted == true && titleAvailableAgain == true) {
				JOptionPane.showMessageDialog(null, "Thank you for returning Titles");
			}

			else {
				JOptionPane.showMessageDialog(null, "Something went wrong!");
			}
		}

		if (action.getActionCommand().equals("selectTVBox")) {
			int row = TVBoxTable.getSelectedRow();
			String tvBoxID = TVBoxTable.getValueAt(row, 0).toString();

			boolean returnDateInserted = tvBoxInner.updateReturnDate(tvBoxID, this.tvBoxReturnDateTextField.getText());
			boolean titleAvailableAgain = tvBoxInner.UpdateTVBoxToAvailable(tvBoxID);

			if (returnDateInserted == true && titleAvailableAgain == true) {
				JOptionPane.showMessageDialog(null, "Thank you for returning Titles");
			}

			else {
				JOptionPane.showMessageDialog(null, "Something went wrong!");
			}

		}
		if (action.getActionCommand().equals("selectLiveConcert")) {
			int row = liveConcertTable.getSelectedRow();
			String liveConcertID = liveConcertTable.getValueAt(row, 0).toString();

			boolean returnDateInserted = liveConcertInner.updateReturnDate(liveConcertID,
					this.getLiveConcertReturnDate());
			boolean titleAvailableAgain = liveConcertInner.UpdateLiveConcertToAvailable(liveConcertID);

			if (returnDateInserted == true && titleAvailableAgain == true) {
				JOptionPane.showMessageDialog(null, "Thank you for returning Titles");

			}

			else {
				JOptionPane.showMessageDialog(null, "Something went wrong!");
			}

		}
		if (action.getActionCommand().equals("selectMovie")) {
			int row = MovieTable.getSelectedRow();
			String movieID = MovieTable.getValueAt(row, 0).toString();

			boolean returnDateInserted = movieInner.updateReturnDate(movieID, this.getMovieReturnDate());
			boolean titleAvailableAgain = movieInner.UpdateMovieToAvailable(movieID);

			if (returnDateInserted == true && titleAvailableAgain == true) {
				JOptionPane.showMessageDialog(null, "Thank you for returning Titles");
			}

			else {
				JOptionPane.showMessageDialog(null, "Something went wrong!");
			}

		}

	}
}
