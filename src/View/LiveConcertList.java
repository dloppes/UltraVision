package View;

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

public class LiveConcertList extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LiveConcertList frame = new LiveConcertList();
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
	public LiveConcertList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoLabel = new JLabel("New label");
		logoLabel.setIcon(new ImageIcon(LiveConcertList.class.getResource("/img/logo3-removebg-preview.png")));
		logoLabel.setBounds(-141, 0, 458, 145);
		contentPane.add(logoLabel);
		
		JLabel lblLiveConcertList = new JLabel("LIVE CONCERT LIST");
		lblLiveConcertList.setForeground(Color.WHITE);
		lblLiveConcertList.setFont(new Font("Verdana", Font.BOLD, 20));
		lblLiveConcertList.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblLiveConcertList.setBackground(Color.BLACK);
		lblLiveConcertList.setBounds(358, 40, 239, 59);
		contentPane.add(lblLiveConcertList);
		
		JComboBox<Object> liveConcertListComboBox = new JComboBox<Object>();
		liveConcertListComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		liveConcertListComboBox.setBounds(23, 172, 448, 38);
		contentPane.add(liveConcertListComboBox);
		
		JButton selectButton = new JButton("Select");
		selectButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		selectButton.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		selectButton.setActionCommand("select");
		selectButton.setBounds(483, 172, 114, 38);
		contentPane.add(selectButton);
	}

}
