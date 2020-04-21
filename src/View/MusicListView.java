package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import model.connection;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class MusicListView extends JFrame implements ActionListener{

	private JPanel contentPane;

	private connection conn;
	private JComboBox<Object> musicListComboBox;
	private ResultSet rs;
	private JFrame frame;
	public String selectedMusicID;
	

	public MusicListView() {
		
		frame = new JFrame();
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 657, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoLabel = new JLabel("New label");
		logoLabel.setIcon(new ImageIcon(MusicListView.class.getResource("/img/logo3-removebg-preview.png")));
		logoLabel.setBounds(-127, 0, 458, 145);
		contentPane.add(logoLabel);
		
		JLabel movieLabel = new JLabel("     MUSIC LIST");
		movieLabel.setForeground(Color.WHITE);
		movieLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		movieLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		movieLabel.setBackground(Color.BLACK);
		movieLabel.setBounds(407, 40, 204, 59);
		contentPane.add(movieLabel);
		
		musicListComboBox = new JComboBox<Object>();
		musicListComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		musicListComboBox.setBounds(37, 172, 448, 38);
		contentPane.add(musicListComboBox);
		
		JButton selectButton = new JButton("Select");
		selectButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		selectButton.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		selectButton.setActionCommand("select");
		selectButton.setBounds(497, 172, 114, 38);
		contentPane.add(selectButton);
		selectButton.addActionListener(this);
		selectButton.setActionCommand("select");
		
		frame.validate();
		frame.repaint();
	}
	
	public void populateComboBox() {

		conn = new connection();

		String query = "Select * FROM music";
		rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				try {
					musicListComboBox.addItem(
							rs.getString("musicID") + " " + rs.getString("title") + " " + rs.getString("singer"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		try {
			selectedMusicID = musicListComboBox.getSelectedItem().toString();
			selectedMusicID = selectedMusicID.split(" ")[0];

			String query = "Select * FROM music WHERE musicID = '" + selectedMusicID + "'";
			rs = conn.executeQuery(query);

			while (rs.next()) {
				rs.getString("yearOfRelease");
				rs.getString("title");
				rs.getString("genre");
				rs.getString("singer");
				rs.getString("price");
				rs.getString("format");

			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerListView.class.getName()).log(Level.SEVERE, null, ex);
		}

		String action = ae.getActionCommand();
		
		if(action.equals("select")) {
			frame.dispose();
			
		}
	}

}
