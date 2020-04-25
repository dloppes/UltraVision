package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controller.NewMovieController;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import interfaces.FilmGenres;
import interfaces.Format;
import javax.swing.JButton;

public class NewMovieView extends JFrame {

	private JPanel contentPane;
	private JTextField titleTextField;
	private JTextField directorTextField;
	private JFormattedTextField yearOfReleaseTextField;
	private JComboBox<Object> genreComboBox;
	private JComboBox <Object>formatComboBox;
	private JComboBox<Object> priceComboBox;
	private NewMovieController controllerInternalRef;
	private MaskFormatter year;
	

	public NewMovieView(NewMovieController controllerInternalRef) throws ParseException {
		
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		
		frame.setTitle("New Movie");
		frame.setBounds(100, 100, 742, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(NewMovieView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-130, 0, 456, 122);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NEW MOVIE");
		lblNewLabel_1.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_1.setIcon(new ImageIcon(NewMovieView.class.getResource("/img/movies_menu_icon.png")));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(498, 29, 204, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("             Title:");
		lblNewLabel_2.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2.setBounds(12, 148, 212, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("          Director:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_1.setBounds(12, 208, 212, 42);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("             Genre:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_2.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_2.setBounds(12, 267, 212, 42);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("   Year of Release:");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_3.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_3.setBounds(12, 329, 212, 42);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("           Format:");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_4.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_4.setBounds(12, 388, 212, 42);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("             Price:");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_5.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_5.setBounds(12, 446, 212, 42);
		contentPane.add(lblNewLabel_2_5);
		
		titleTextField = new JTextField();
		titleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		titleTextField.setBounds(236, 148, 468, 42);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		directorTextField = new JTextField();
		directorTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		directorTextField.setColumns(10);
		directorTextField.setBounds(234, 208, 468, 42);
		contentPane.add(directorTextField);
		
		genreComboBox = new JComboBox<Object>();
		genreComboBox.setModel(new DefaultComboBoxModel<Object>(FilmGenres.values()));
		genreComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		genreComboBox.setBounds(236, 267, 466, 42);
		contentPane.add(genreComboBox);
		
		year = new MaskFormatter("####");
		yearOfReleaseTextField = new JFormattedTextField(year);
		yearOfReleaseTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		yearOfReleaseTextField.setColumns(10);
		yearOfReleaseTextField.setBounds(234, 329, 468, 42);
		contentPane.add(yearOfReleaseTextField);
		
		formatComboBox = new JComboBox<Object>();
		formatComboBox.setModel(new DefaultComboBoxModel<Object>(Format.values()));
		formatComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		formatComboBox.setBounds(236, 388, 466, 42);
		contentPane.add(formatComboBox);
		
		priceComboBox = new JComboBox<Object>();
		priceComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"2.00", "3.50", "5.00", "7.50", "10.00"}));
		priceComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		priceComboBox.setBounds(236, 446, 468, 42);
		contentPane.add(priceComboBox);
		
		JButton createButton = new JButton("CREATE");
		createButton.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		createButton.setFont(new Font("Verdana", Font.BOLD, 20));
		createButton.setBounds(572, 516, 116, 42);
		contentPane.add(createButton);
		createButton.addActionListener((ActionListener)controllerInternalRef);
		createButton.setActionCommand("create");
		
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
	
	public String getDirector() {
		return directorTextField.getText();
	}
}
