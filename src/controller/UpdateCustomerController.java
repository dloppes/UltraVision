package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ParseException;

import javax.swing.JOptionPane;

import View.UpdateCustomerView;
import model.Customer;
import model.Queries;
import model.connection;
import model.Queries.updateCustomer;

/**
 * 
 * @author Daniel Lopes This class managers the update of a customer. The String
 *         ID is passed through the view. I access the database to search for
 *         the customer that has the got from my view. Once I have found the
 *         customer it calls method to update customer into my database
 */
public class UpdateCustomerController implements ActionListener {

	UpdateCustomerView UpdateCustomerView;
	Customer customer;
	private ResultSet rs;
	connection conn;
	private String userID;

	public UpdateCustomerController(String userID) throws ParseException {

		this.userID = userID;
		this.customer = getCustomerDetails(userID);
		this.UpdateCustomerView = new UpdateCustomerView(this, customer);

	}

	public Customer getCustomerDetails(String userID) {

		/* Searches for customer into the database with userID passed from view */

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

		customer = new Customer(fName, lName, phoneNumber, email, plan, cardNumber);

		return customer;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String ac = e.getActionCommand();
		if (ac.equals("update")) {

			String fName = UpdateCustomerView.getFirstName();
			String lName = UpdateCustomerView.getLastName();
			String email = UpdateCustomerView.getEmail();
			String cardNumber = UpdateCustomerView.getCardNumber();
			String plan = UpdateCustomerView.getPlan();
			String phoneNumber = UpdateCustomerView.getPhoneNumber();

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

				Queries newCustomerQuery = new Queries();

				updateCustomer updateDetails = newCustomerQuery.new updateCustomer(); // instance of the class

				boolean updatedCustomerBoolean = updateDetails.updateCustomerDetails(customer, userID); // method within
																										// the
																										// class to
																										// update
																										// customer

				if (updatedCustomerBoolean) {

					this.UpdateCustomerView.dispose();
					JOptionPane.showMessageDialog(null,
							customer.getfName() + " " + customer.getlName() + " Updated Successfuly!");

				} else {
					JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");

				}

			}
		}
	}

}
