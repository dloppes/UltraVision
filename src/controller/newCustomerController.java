package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import View.NewCustomerView;
import model.Customer;
import model.Queries;
import model.Queries.customerClass;

/**
 * 
 * @author Daniel Lopes
 *
 *         This class is responsible for creating a new customer object. It has
 *         access to the NewCustomerViewand Queries Model
 */
public class NewCustomerController implements ActionListener {

	NewCustomerView newCustomerView;

	public NewCustomerController() throws ParseException {

		newCustomerView = new NewCustomerView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * The information that the user types in the screen text field is retrieved and
		 * saved within those variables. After storing them in the variable I can use
		 * each variable to create my customer object *
		 */

		String fName = newCustomerView.getFirstName();
		String lName = newCustomerView.getLastName();
		String email = newCustomerView.getEmail();
		String phoneNumber = newCustomerView.getPhoneNumber();
		String cardNumber = newCustomerView.getCardNumber();
		String plan = newCustomerView.getPlan();

		/*
		 * Validating new customer input: Checking if the field is not empty. Checking
		 * if fields First Name and Last Name are letters (no numbers allowed). Finally,
		 * checking if the field email contains a "@" which determines wether or not it
		 * is a valid email
		 */

		if (fName.isEmpty() == true || lName.isEmpty() == true || email.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Please make sure that fields are NOT EMPTY!");
		}

		else if (!fName.matches("[a-zA-z]+") || !lName.matches("[a-zA-z]+")) {

			JOptionPane.showMessageDialog(null, "Only letters allowed for fields First Name and Last Name");

		}

		else if (!email.contains("@")) {
			JOptionPane.showMessageDialog(null, "Please insert a valid email format");
		} else {

			Customer customer = new Customer(fName, lName, phoneNumber, email, plan, cardNumber);

			if (e.getActionCommand().equals("create")) {

				Queries newCustomerQuery = new Queries(); // instance of Queries Class

				customerClass newCustomer = newCustomerQuery.new customerClass(); // instance of the inner class
																					// Customer

				boolean newCustomerBoolean = newCustomer.insertNewCustomer(customer); // accessing a method within
																						// customer class

				if (newCustomerBoolean) {
					newCustomerView.dispose();
					newCustomer.newLoyaltyCard(customer);
					JOptionPane.showMessageDialog(null,
							"New Customer " + customer.getEmail() + " Successfully Created!");
				}
			}
		}
	}
}
