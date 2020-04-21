package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import controller.NewTVBoxController;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import interfaces.Format;

public class NewTVBoxView extends JFrame{

	private JPanel contentPane;
	private JTextField titleTextField;
	private JComboBox<Object> numberOfDisksComboBox;
	private JComboBox<Object> formatComboBox;
	private JComboBox<Object> priceComboBox;
	private JComboBox<Object> seasonComboBox;
	private NewTVBoxController controllerInternalRef;

	public NewTVBoxView(NewTVBoxController controllerInternalRef) {

		JFrame frame = new JFrame();
		frame.setVisible(true);

		frame.setBounds(100, 100, 742, 635);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(NewTVBoxView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-137, 13, 478, 121);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NEW TV BOX");
		lblNewLabel_1.setIcon(new ImageIcon(NewTVBoxView.class.getResource("/img/tvBox_menu_icon.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(502, 37, 210, 67);
		contentPane.add(lblNewLabel_1);

		JLabel titleLabel = new JLabel("             Title:");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		titleLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		titleLabel.setBounds(12, 165, 212, 42);
		contentPane.add(titleLabel);

		titleTextField = new JTextField();
		titleTextField.setFont(new Font("Verdana", Font.PLAIN, 18));
		titleTextField.setColumns(10);
		titleTextField.setBounds(236, 165, 468, 42);
		contentPane.add(titleTextField);

		JLabel seasonLabel = new JLabel("          Season:");
		seasonLabel.setForeground(Color.WHITE);
		seasonLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		seasonLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		seasonLabel.setBounds(12, 240, 212, 42);
		contentPane.add(seasonLabel);

		JLabel numberOfDisksLabel = new JLabel("   Number of Disks");
		numberOfDisksLabel.setForeground(Color.WHITE);
		numberOfDisksLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		numberOfDisksLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		numberOfDisksLabel.setBounds(12, 318, 212, 42);
		contentPane.add(numberOfDisksLabel);

		numberOfDisksComboBox = new JComboBox<Object>();
		numberOfDisksComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "1", "2", "3", "4", "5" }));
		numberOfDisksComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		numberOfDisksComboBox.setBounds(236, 318, 466, 42);
		contentPane.add(numberOfDisksComboBox);

		JLabel formatLabel = new JLabel("           Format:");
		formatLabel.setForeground(Color.WHITE);
		formatLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		formatLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		formatLabel.setBounds(12, 385, 212, 42);
		contentPane.add(formatLabel);

		formatComboBox = new JComboBox<Object>();
		formatComboBox.setModel(new DefaultComboBoxModel<Object>(Format.values()));
		formatComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		formatComboBox.setBounds(236, 385, 466, 42);
		contentPane.add(formatComboBox);

		JLabel priceLabel = new JLabel("             Price:");
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		priceLabel.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		priceLabel.setBounds(12, 458, 212, 42);
		contentPane.add(priceLabel);

		priceComboBox = new JComboBox<Object>();
		priceComboBox.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "2.00", "3.00", "5.00", "7.50", "9.00", "10.00", "15.00", "20.00" }));
		priceComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		priceComboBox.setBounds(236, 458, 468, 42);
		contentPane.add(priceComboBox);

		JButton createButton = new JButton("CREATE");
		createButton.setFont(new Font("Verdana", Font.BOLD, 20));
		createButton.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		createButton.setBounds(585, 533, 116, 42);
		contentPane.add(createButton);
		createButton.addActionListener((ActionListener)controllerInternalRef);
		createButton.setActionCommand("create");

		seasonComboBox = new JComboBox<Object>();
		seasonComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		seasonComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		seasonComboBox.setBounds(236, 240, 466, 42);
		contentPane.add(seasonComboBox);

		frame.validate();
		frame.repaint();
	}
	
	public String getTitle() {
		return  titleTextField.getText();
		
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
	
	public int getSeason() {
		String seasonTextField = seasonComboBox.getSelectedItem().toString();
		int season = Integer.parseInt(seasonTextField);
		return season;
	}
	
	public int getNumberOfDisks() {
		String numberOfDisksTextField = numberOfDisksComboBox.getSelectedItem().toString();
		int numberOfDisks = Integer.parseInt(numberOfDisksTextField);
		return numberOfDisks;
	}
}
