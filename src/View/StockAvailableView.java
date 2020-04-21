package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

import model.Queries;
import model.connection;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;

public class StockAvailableView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JFrame frame;
	public StockAvailableView() {

		new connection();

		frame = new JFrame();

		frame.setVisible(true);

		frame.setTitle("Available Stock");
		frame.setBounds(100, 100, 913, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(StockAvailableView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-125, -14, 497, 169);
		contentPane.add(lblNewLabel);

		JLabel lblAvailableTitles = new JLabel("AVAILABLE TITLES");
		lblAvailableTitles.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableTitles.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblAvailableTitles.setIcon(new ImageIcon(StockAvailableView.class.getResource("/img/available_icon..png")));
		lblAvailableTitles.setForeground(new Color(189, 183, 107));
		lblAvailableTitles.setBackground(new Color(0, 0, 0));
		lblAvailableTitles.setFont(new Font("Verdana", Font.BOLD, 22));
		lblAvailableTitles.setBounds(552, 44, 331, 45);
		contentPane.add(lblAvailableTitles);

		JLabel lblPleaseSelectThe = new JLabel("Please select the Title you would like to search for:");
		lblPleaseSelectThe.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lblPleaseSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectThe.setForeground(new Color(189, 183, 107));
		lblPleaseSelectThe.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPleaseSelectThe.setBounds(12, 133, 871, 51);
		contentPane.add(lblPleaseSelectThe);

		JButton btnMusic = new JButton("MUSIC");
		btnMusic.setBorder(new LineBorder(new Color(189, 183, 107), 1, true));
		btnMusic.setIcon(new ImageIcon(StockAvailableView.class.getResource("/img/music_menu_icon.png")));
		btnMusic.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnMusic.setBounds(29, 215, 163, 45);
		contentPane.add(btnMusic);
		btnMusic.addActionListener(this);
		btnMusic.setActionCommand("music");

		JButton btnMovie = new JButton("MOVIE");
		btnMovie.setIcon(new ImageIcon(StockAvailableView.class.getResource("/img/movies_menu_icon.png")));
		btnMovie.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnMovie.setBorder(new LineBorder(new Color(189, 183, 107), 1, true));
		btnMovie.setBounds(232, 215, 163, 45);
		contentPane.add(btnMovie);
		btnMovie.addActionListener(this);
		btnMovie.setActionCommand("movie");

		JButton btnTvBox = new JButton("TV BOX");
		btnTvBox.setIcon(new ImageIcon(StockAvailableView.class.getResource("/img/tvBox_menu_icon.png")));
		btnTvBox.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnTvBox.setBorder(new LineBorder(new Color(189, 183, 107), 1, true));
		btnTvBox.setBounds(441, 215, 163, 45);
		contentPane.add(btnTvBox);
		btnTvBox.addActionListener(this);
		btnTvBox.setActionCommand("TVBox");

		JButton btnLiveConcert = new JButton("LIVE CONCERT");
		btnLiveConcert.setIcon(new ImageIcon(StockAvailableView.class.getResource("/img/liveCOncert_menu_icon.png")));
		btnLiveConcert.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnLiveConcert.setBorder(new LineBorder(new Color(189, 183, 107), 1, true));
		btnLiveConcert.setBounds(638, 215, 245, 45);
		contentPane.add(btnLiveConcert);
		btnLiveConcert.addActionListener(this);
		btnLiveConcert.setActionCommand("liveConcert");

		frame.validate();
		frame.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent action) {

		if (action.getActionCommand().equals("music")) {

			String[] columnNames = new String[] { "Music ID", "Title", "Singer", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			Queries musicQuery = new Queries();
			Queries.musicClass innerMusic = musicQuery.new musicClass();

			data = innerMusic.getAvailableMusic();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 287, 871, 262);
			contentPane.add(scrollPane);

			table = new JTable(data, columnNames);
			scrollPane.setViewportView(table);

		}

		else if (action.getActionCommand().equals("movie")) {

			String[] columnNames = new String[] { "Movie ID", "Title", "Director", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			Queries movieQuery = new Queries();
			Queries.movieClass innerMovie = movieQuery.new movieClass();

			data = innerMovie.getAvailableMovie();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 287, 871, 262);
			contentPane.add(scrollPane);

			table = new JTable(data, columnNames);
			scrollPane.setViewportView(table);

		}

		else if (action.getActionCommand().equals("TVBox")) {
			String[] columnNames = new String[] { "Title ID", "Title", "Season", "Number of Disks", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			Queries tvBoxQuery = new Queries();
			Queries.tvBoxClass innerTVBox = tvBoxQuery.new tvBoxClass();

			data = innerTVBox.getAvailableTVBox();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 287, 871, 262);
			contentPane.add(scrollPane);

			table = new JTable(data, columnNames);
			scrollPane.setViewportView(table);

		}

		else if (action.getActionCommand().equals("liveConcert")) {
			String[] columnNames = new String[] { "Band ID", "Title", "Band", "Genre", "Format", "Price" };

			String[][] data = new String[100][columnNames.length];

			Queries liveConcertQuery = new Queries();
			Queries.liveConcertClass innerLiveConcert = liveConcertQuery.new liveConcertClass();

			data = innerLiveConcert.getAvailableLiveConcert();

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 287, 871, 262);
			contentPane.add(scrollPane);

			table = new JTable(data, columnNames);
			scrollPane.setViewportView(table);

		}
	}

}
