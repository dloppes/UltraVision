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

import controller.NewLiveConcertController;
import interfaces.Format;
import interfaces.MusicGenres;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

/**
 * 
 * @author Daniel Lopes
 *
 *         New Live Concert class, that receives New Live Concert controller passed
 *         onto.
 */

public class NewLiveConcertView extends JFrame {

	private JPanel contentPane;
	private JTextField titleTextField;
	private JTextField bandTextField;
	private JFormattedTextField yearOfReleaseTextField;
	private JComboBox<Object> genreComboBox;
	private JComboBox<Object> formatComboBox;
	private JComboBox<Object> priceComboBox;
	private NewLiveConcertController controllerInternalRef;
	private MaskFormatter year;

	public NewLiveConcertView(NewLiveConcertController controllerInternalRef) throws ParseException {
		this.controllerInternalRef = controllerInternalRef;
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		
		frame.setTitle("New Live Concert");
		frame.setBounds(100, 100, 742, 635);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoLabel = new JLabel("New label");
		logoLabel.setIcon(new ImageIcon(NewLiveConcertView.class.getResource("/img/logo3-removebg-preview.png")));
		logoLabel.setBounds(-140, 0, 472, 136);
		contentPane.add(logoLabel);
		
		JLabel lblNewLiveConcert = new JLabel("NEW LIVE CONCERT");
		lblNewLiveConcert.setBorder(new LineBorder(new Color(189, 183, 107), 4, true));
		lblNewLiveConcert.setIcon(new ImageIcon(NewLiveConcertView.class.getResource("/img/liveCOncert_menu_icon.png")));
		lblNewLiveConcert.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLiveConcert.setForeground(Color.WHITE);
		lblNewLiveConcert.setBounds(414, 32, 298, 66);
		contentPane.add(lblNewLiveConcert);
		
		JLabel lblNewLabel_2 = new JLabel("             Title:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2.setBounds(12, 174, 212, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("            Band:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_1.setBounds(12, 234, 212, 42);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("             Genre:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_2.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_2.setBounds(12, 293, 212, 42);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("   Year of Release:");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_3.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_3.setBounds(12, 355, 212, 42);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("           Format:");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_4.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_4.setBounds(12, 414, 212, 42);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("             Price:");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_5.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_2_5.setBounds(12, 472, 212, 42);
		contentPane.add(lblNewLabel_2_5);
		
		titleTextField = new JTextField();
		titleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		titleTextField.setColumns(10);
		titleTextField.setBounds(244, 174, 468, 42);
		contentPane.add(titleTextField);
		
		bandTextField = new JTextField();
		bandTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		bandTextField.setColumns(10);
		bandTextField.setBounds(242, 234, 468, 42);
		contentPane.add(bandTextField);
		
		genreComboBox = new JComboBox<Object>();
		genreComboBox.setModel(new DefaultComboBoxModel<Object>(MusicGenres.values()));
		genreComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		genreComboBox.setBounds(244, 293, 466, 42);
		contentPane.add(genreComboBox);
		
		year = new MaskFormatter("####");
		yearOfReleaseTextField = new JFormattedTextField(year);
		yearOfReleaseTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		yearOfReleaseTextField.setColumns(10);
		yearOfReleaseTextField.setBounds(242, 355, 468, 42);
		contentPane.add(yearOfReleaseTextField);
		
		formatComboBox = new JComboBox<Object>();
		formatComboBox.setModel(new DefaultComboBoxModel<Object>(Format.values()));
		formatComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		formatComboBox.setBounds(244, 414, 466, 42);
		contentPane.add(formatComboBox);
		
		priceComboBox = new JComboBox<Object>();
		priceComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"1.00", "2.00", "2.50", "5.00", "7.50", "8.00", "10.00", "15.00", "18.00", "20.00"}));
		priceComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		priceComboBox.setBounds(244, 472, 468, 42);
		contentPane.add(priceComboBox);
		
		JButton createButton = new JButton("CREATE");
		createButton.setFont(new Font("Verdana", Font.BOLD, 20));
		createButton.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		createButton.setBounds(596, 533, 116, 42);
		contentPane.add(createButton);
		createButton.addActionListener((ActionListener) controllerInternalRef);
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
	
	public String getYearOfRelease() {
		return yearOfReleaseTextField.getText();
	
		
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
	
	public String getBand() {
		return bandTextField.getText();
	}
}
