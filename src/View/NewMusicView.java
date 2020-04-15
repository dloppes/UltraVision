package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;

import controller.NewMusicController;
import interfaces.Format;
import interfaces.MusicGenres;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class NewMusicView extends JFrame {

	private JPanel contentPane;
	private JTextField titleTextField;
	private JTextField yearOfReleaseTextField;
	private JComboBox genreComboBox;
	private JComboBox formatComboBox;
	private JComboBox priceComboBox;
	private NewMusicController controllerInternalRef;
	private JTextField singerTextField;

	
	public NewMusicView(NewMusicController controllerInternalRef) {
		
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		
		frame.setTitle("New Music");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 651, 605);
		contentPane = new JPanel();
		contentPane.setName("");
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(NewMusicView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-124, 0, 487, 144);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewMusic = new JLabel("New Music");
		lblNewMusic.setIcon(new ImageIcon(NewMusicView.class.getResource("/img/music_menu_icon.png")));
		lblNewMusic.setForeground(new Color(189, 183, 107));
		lblNewMusic.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewMusic.setBounds(423, 45, 180, 48);
		contentPane.add(lblNewMusic);
		
		JLabel lblTitle = new JLabel("          Title");
		lblTitle.setBorder(new LineBorder(new Color(222, 184, 135), 3, true));
		lblTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(12, 157, 180, 31);
		contentPane.add(lblTitle);
		
		JLabel lblGenre = new JLabel("          Genre");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Verdana", Font.BOLD, 18));
		lblGenre.setBorder(new LineBorder(new Color(222, 184, 135), 3, true));
		lblGenre.setBounds(12, 267, 180, 31);
		contentPane.add(lblGenre);
		
		JLabel lblYearOfRelease = new JLabel(" Year Of Release");
		lblYearOfRelease.setForeground(Color.WHITE);
		lblYearOfRelease.setFont(new Font("Verdana", Font.BOLD, 18));
		lblYearOfRelease.setBorder(new LineBorder(new Color(222, 184, 135), 3, true));
		lblYearOfRelease.setBounds(12, 315, 180, 31);
		contentPane.add(lblYearOfRelease);
		
		JLabel lblFormat = new JLabel("        Format");
		lblFormat.setForeground(Color.WHITE);
		lblFormat.setFont(new Font("Verdana", Font.BOLD, 18));
		lblFormat.setBorder(new LineBorder(new Color(222, 184, 135), 3, true));
		lblFormat.setBounds(12, 374, 180, 31);
		contentPane.add(lblFormat);
		
		JLabel lblPrice = new JLabel("          Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPrice.setBorder(new LineBorder(new Color(222, 184, 135), 3, true));
		lblPrice.setBounds(12, 433, 180, 31);
		contentPane.add(lblPrice);
		
		titleTextField = new JTextField();
		titleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		titleTextField.setBounds(222, 157, 361, 31);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		genreComboBox = new JComboBox();
		genreComboBox.setModel(new DefaultComboBoxModel(MusicGenres.values()));
		genreComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		genreComboBox.setBounds(222, 263, 361, 35);
		contentPane.add(genreComboBox);
		
		yearOfReleaseTextField = new JTextField();
		yearOfReleaseTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		yearOfReleaseTextField.setBounds(222, 315, 361, 31);
		contentPane.add(yearOfReleaseTextField);
		yearOfReleaseTextField.setColumns(10);
		
		formatComboBox = new JComboBox();
		formatComboBox.setModel(new DefaultComboBoxModel(Format.values()));
		formatComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		formatComboBox.setBounds(222, 374, 361, 31);
		contentPane.add(formatComboBox);
		
		priceComboBox = new JComboBox();
		priceComboBox.setModel(new DefaultComboBoxModel(new String[] {"2.00", "3.50", "5.00", "7.50", "10.00"}));
		priceComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		priceComboBox.setBounds(222, 433, 361, 31);
		contentPane.add(priceComboBox);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBorder(new LineBorder(new Color(189, 183, 107), 5, true));
		btnCreate.setFont(new Font("Verdana", Font.BOLD, 20));
		btnCreate.setBounds(430, 497, 153, 48);
		contentPane.add(btnCreate);
		btnCreate.addActionListener((ActionListener)controllerInternalRef);
		btnCreate.setActionCommand("create");
		
		JLabel lblSinger = new JLabel("          Singer");
		lblSinger.setForeground(Color.WHITE);
		lblSinger.setFont(new Font("Verdana", Font.BOLD, 18));
		lblSinger.setBorder(new LineBorder(new Color(222, 184, 135), 3, true));
		lblSinger.setBounds(12, 209, 180, 31);
		contentPane.add(lblSinger);
		
		singerTextField = new JTextField();
		singerTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		singerTextField.setColumns(10);
		singerTextField.setBounds(222, 209, 361, 31);
		contentPane.add(singerTextField);
		
		frame.validate();
		frame.repaint();
	}
	
	public String getTitle() {
		return  titleTextField.getText();
		
	}
	
	public String getGenre() {
		 String genreTextField = genreComboBox.getSelectedItem().toString();
			return genreTextField;
		
	}
	
	public int getYearOfRelease() {
		int year = Integer.parseInt(yearOfReleaseTextField.getText());
		return year;
		
	}
	
	public String getFormat() {
		String formatTextField = formatComboBox.getSelectedItem().toString();
		return formatTextField;
		
	}
	
	public double getPrice() {
		String priceTextField = priceComboBox.getSelectedItem().toString();
		double price = Double.parseDouble(priceTextField);
		return price;
		
	}
	
	public String getSinger() {
		return singerTextField.getText();
	}
	
	
}
