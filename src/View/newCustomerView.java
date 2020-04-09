package View;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.newCustomerController;

public class newCustomerView extends JFrame {

	private newCustomerController controllerInternalRef;
	private JTextField fName;
	private JTextField lName;
	private JTextField email;
	private JTextField cardNumber;
	private JTextField plan;
	private JTextField phoneNumber;

	public newCustomerView(newCustomerController controller) {

		this.controllerInternalRef = controller;
		attributesSetter();
		components();
		validation();
	}

	// -------------------------------------------Attributes create a part to let it
	// nittier----------------------------------------------------------
	private void attributesSetter() {
		this.setVisible(true);
		this.setSize(340, 250);
		this.setTitle("New Admin");

	}

//------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------Components method create aside as well---------------------------------------------------------------        
	private void components() {

		JPanel p = new JPanel();
		this.add(p);

		fName = new JTextField(20);
		lName = new JTextField(20);
		email = new JTextField(20);
		phoneNumber = new JTextField(20);
		cardNumber = new JTextField(16);
		plan = new JTextField(15);

		JLabel cust_fName = new JLabel("First Name:");
		JLabel cust_lName = new JLabel("Last Name:");
		JLabel cust_email = new JLabel("Email:");
		JLabel cust_phone = new JLabel("Phone Number");
		JLabel cust_cardNumber = new JLabel("Card Number:");
		JLabel cust_plan = new JLabel("Membership Plan");

		JButton create = new JButton("Create"); // login button created
		create.addActionListener((ActionListener) controllerInternalRef); // adding button to action listener
		create.setActionCommand("create"); // setting the value that actives action command

		p.add(cust_fName);
		p.add(fName);
		p.add(cust_lName);
		p.add(lName);
		p.add(cust_email);
		p.add(email);
		p.add(cust_phone);
		p.add(phoneNumber);
		p.add(cust_cardNumber);
		p.add(cardNumber);
		p.add(cust_plan);
		p.add(plan);
		p.add(create);

	}

//------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------Validation method created to let it nittier----------------------------------------------------------        
	private void validation() {
		this.validate();
		this.repaint();
	}
//------------------------------------------------------------------------------------------------------------------------------------------------    

//--------------------------------------------------------------Get First Name--------------------------------------------------------------------       
	public String getFirstName() {
		return fName.getText();
	}

//--------------------------------------------------------------Get Last Name---------------------------------------------------------------------       
	public String getLastName() {
		return lName.getText();
	}

//------------------------------------------------------------------Get  email---------------------------------------------------------------------       
	public String getEmail() {
		return email.getText();
	}

//------------------------------------------------------------------Get  card Number---------------------------------------------------------------       
	public String getCardNumber() {
		return cardNumber.getText();
	}

//------------------------------------------------------------------Get  Plan---------------------------------------------------------------------       
	public String getPlan() {
		return plan.getText();
	}

	public int getPhoneNumber() {
		int number = Integer.parseInt(phoneNumber.getText());
		return number;
	}
}
