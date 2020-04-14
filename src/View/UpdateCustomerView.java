package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import model.Customer;
import model.Membership;

public class UpdateCustomerView extends JFrame {

	private UpdateCustomerController controllerInternalRef;
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lNameTextField;
	private JTextField emailTextField;
	private JTextField cardNumberTextField;
	private JTextField phoneNumberTextField;
	private String userID;
	private JComboBox planBox;
	private ResultSet rs;
	private connection conn;
	private Customer customer;

	public UpdateCustomerView(UpdateCustomerController controllerInternalRef, String userID) {

		this.controllerInternalRef = controllerInternalRef;
		this.userID = userID;

		getCustomerDetails(userID);

		components(controllerInternalRef, userID);

	}

	public Object getCustomerDetails(String userID) {

		String fName = "";
		String lName = "";
		String email = "";
		String cardNumber = "";
		String phoneNumber = "";
		String plan = "";

		try {
			conn = new connection();

			String query = "Select * FROM customer WHERE customerID = '" + userID + "'";
			rs = conn.executeQuery(query);

			while (rs.next()) {
				fName = rs.getString("fName");
				lName = rs.getString("lName");
				email = rs.getString("email");
				cardNumber = rs.getString("cardNumber");
				phoneNumber = rs.getString("phoneNumber");
				plan = rs.getString("plan");
			}
		} catch (Exception e) {
			System.out.println("SOmething went wrong");
		}

		customer = new Customer(fName, lName, email, cardNumber, phoneNumber, plan);

		return customer;

	}

	public void components(UpdateCustomerController controllerInternalRef, String userID) {

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
		txtpnNewCustomer.setText("Update Customer");
		txtpnNewCustomer.setBounds(394, 52, 234, 53);
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
		firstNameField.setText(customer.getfName());

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
		lNameTextField.setText(customer.getlName());

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
		emailTextField.setText(customer.getEmail());

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
		cardNumberTextField.setText(customer.getCardNumber());

		JLabel lblPlan = new JLabel("Plan:");
		lblPlan.setForeground(Color.WHITE);
		lblPlan.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPlan.setBackground(Color.WHITE);
		lblPlan.setBounds(118, 405, 58, 32);
		contentPane.add(lblPlan);

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
		phoneNumberTextField.setText(customer.getPhoneNumber());

		JButton updateButton = new JButton("Update");
		updateButton.setBorder(new LineBorder(Color.ORANGE, 1, true));
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		updateButton.setBounds(476, 525, 127, 38);
		updateButton.addActionListener((ActionListener) controllerInternalRef);
		updateButton.setActionCommand("update");
		contentPane.add(updateButton);

		planBox = new JComboBox();
		planBox.setModel(new DefaultComboBoxModel(Membership.values()));
		planBox.setBounds(188, 401, 415, 36);
		contentPane.add(planBox);

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
		String planTextField;
		planTextField = planBox.getSelectedItem().toString();
		return planTextField;
	}

	public String getPhoneNumber() {
		return phoneNumberTextField.getText();
	}
}