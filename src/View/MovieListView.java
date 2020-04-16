package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MovieListView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieListView frame = new MovieListView();
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
	public MovieListView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoLabel = new JLabel("New label");
		logoLabel.setIcon(new ImageIcon(MovieListView.class.getResource("/img/logo3-removebg-preview.png")));
		logoLabel.setBounds(-132, 0, 458, 145);
		contentPane.add(logoLabel);
		
		JLabel movieListLabel = new JLabel("     MOVIE LIST");
		movieListLabel.setForeground(Color.WHITE);
		movieListLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		movieListLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		movieListLabel.setBackground(Color.BLACK);
		movieListLabel.setBounds(402, 40, 204, 59);
		contentPane.add(movieListLabel);
		
		JComboBox movieListComboBox = new JComboBox();
		movieListComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		movieListComboBox.setBounds(32, 172, 448, 38);
		contentPane.add(movieListComboBox);
		
		JButton selectButton = new JButton("Select");
		selectButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		selectButton.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		selectButton.setActionCommand("select");
		selectButton.setBounds(492, 172, 114, 38);
		contentPane.add(selectButton);
	}

}
