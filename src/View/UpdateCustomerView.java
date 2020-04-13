package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.UpdateCustomerController;
import model.connection;

public class UpdateCustomerView extends JFrame {

	private UpdateCustomerController controllerInternalRef;
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lNameTextField;
	private JTextField emailTextField;
	private JTextField cardNumberTextField;
	private JTextField planTextField;
	private JTextField phoneNumberTextField;
	private String userID;

	public UpdateCustomerView(UpdateCustomerController controllerInternalRef, String userID) {

		this.controllerInternalRef = controllerInternalRef;
		this.userID = userID;
		components(controllerInternalRef, userID);

	}

	public void components(UpdateCustomerController controllerInternalRef, String userID) {

//		String fName = "";
//		String lName = "";
//		String email = "";
//		String cardNumber = "";
//		String plan = "";
//		int phoneNumber;

//		conn = new connection();
//
//		String query = "Select * FROM customer WHERE customerID = '" + userID + "'";
//		ResultSet rs = conn.executeQuery(query);


		JFrame frame = new JFrame();

		frame.setVisible(true);
		frame.setTitle("Update Customer");
		frame.setBounds(100, 100, 673, 623);

		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UpdateCustomerView.class.getResource("/img/logo3-removebg-preview.png")));
		lblNewLabel.setBounds(-136, 0, 458, 146);
		contentPane.add(lblNewLabel);

		JTextPane txtpnNewCustomer = new JTextPane();
		txtpnNewCustomer.setBorder(new LineBorder(new Color(189, 183, 107), 3, true));
		txtpnNewCustomer.setBackground(new Color(0, 0, 0));
		txtpnNewCustomer.setForeground(new Color(189, 183, 107));
		txtpnNewCustomer.setFont(new Font("Calibri", Font.BOLD, 30));
		txtpnNewCustomer.setText("  New Customer");
		txtpnNewCustomer.setBounds(413, 52, 215, 53);
		contentPane.add(txtpnNewCustomer);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Verdana", Font.BOLD, 18));
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBackground(Color.WHITE);
		lblFirstName.setBounds(48, 159, 128, 32);
		contentPane.add(lblFirstName);

		firstNameField = new JTextField(20);
		lblFirstName.setLabelFor(firstNameField);
		firstNameField.setBounds(188, 162, 415, 32);
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);
		//firstNameField.setText(fName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Verdana", Font.BOLD, 18));
		lblLastName.setBackground(Color.WHITE);
		lblLastName.setBounds(48, 222, 128, 32);
		contentPane.add(lblLastName);

		lNameTextField = new JTextField(50);
		lblLastName.setLabelFor(lNameTextField);
		lNameTextField.setColumns(10);
		lNameTextField.setBounds(188, 225, 415, 32);
		contentPane.add(lNameTextField);
		//lNameTextField.setText(lName);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(99, 284, 77, 32);
		contentPane.add(lblEmail);

		emailTextField = new JTextField(40);
		lblEmail.setLabelFor(emailTextField);
		emailTextField.setColumns(10);
		emailTextField.setBounds(188, 287, 415, 32);
		contentPane.add(emailTextField);
		//emailTextField.setText(email);

		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setForeground(Color.WHITE);
		lblCardNumber.setFont(new Font("Verdana", Font.BOLD, 18));
		lblCardNumber.setBackground(Color.WHITE);
		lblCardNumber.setBounds(23, 343, 153, 32);
		contentPane.add(lblCardNumber);

		cardNumberTextField = new JTextField(16);
		lblCardNumber.setLabelFor(cardNumberTextField);
		cardNumberTextField.setColumns(10);
		cardNumberTextField.setBounds(188, 346, 415, 32);
		contentPane.add(cardNumberTextField);
		//cardNumberTextField.setText(cardNumber);

		JLabel lblPlan = new JLabel("Plan:");
		lblPlan.setForeground(Color.WHITE);
		lblPlan.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPlan.setBackground(Color.WHITE);
		lblPlan.setBounds(118, 405, 58, 32);
		contentPane.add(lblPlan);

		planTextField = new JTextField(10);
		lblPlan.setLabelFor(planTextField);
		planTextField.setColumns(10);
		planTextField.setBounds(188, 408, 415, 32);
		contentPane.add(planTextField);
		//planTextField.setText(plan);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPhoneNumber.setBackground(Color.WHITE);
		lblPhoneNumber.setBounds(12, 464, 164, 32);
		contentPane.add(lblPhoneNumber);

		phoneNumberTextField = new JTextField(15);
		lblPhoneNumber.setLabelFor(phoneNumberTextField);
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(188, 467, 415, 32);
		contentPane.add(phoneNumberTextField);
		// phoneNumberTextField.setText(phoneNumber);

		JButton createButton = new JButton("Create");
		createButton.setBorder(new LineBorder(Color.ORANGE, 1, true));
		createButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		createButton.setBounds(476, 525, 127, 38);
		createButton.addActionListener((ActionListener) controllerInternalRef);
		createButton.setActionCommand("update");
		contentPane.add(createButton);

		frame.validate();
		frame.repaint();

	}

//------------------------------------------------------------------------------------------------------------------------------------------------    

//--------------------------------------------------------------Get First Name--------------------------------------------------------------------       
	public String getFirstName() {
		return firstNameField.getText();

	}

//--------------------------------------------------------------Get Last Name---------------------------------------------------------------------       
	public String getLastName() {
		return lNameTextField.getText();

	}

//------------------------------------------------------------------Get  email---------------------------------------------------------------------       
	public String getEmail() {
		return emailTextField.getText();
	}

//------------------------------------------------------------------Get  card Number---------------------------------------------------------------       
	public String getCardNumber() {
		return cardNumberTextField.getText();
	}

//------------------------------------------------------------------Get  Plan---------------------------------------------------------------------       
	public String getPlan() {
		return planTextField.getText();
	}

	public int getPhoneNumber() {
		int number = Integer.parseInt(phoneNumberTextField.getText());
		return number;
	}
}