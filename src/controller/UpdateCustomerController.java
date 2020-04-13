package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.UpdateCustomerView;
import model.Customer;

public class UpdateCustomerController implements ActionListener {

	UpdateCustomerView UpdateCustomerView;
	Customer customer;
	private String userID;

	public UpdateCustomerController(String userID) {

		this.userID = userID;
		this.UpdateCustomerView = new UpdateCustomerView(this, userID);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		String fName = UpdateCustomerView.getFirstName();
		String lName = UpdateCustomerView.getLastName();
		String email = UpdateCustomerView.getEmail();
		String cardNumber = UpdateCustomerView.getCardNumber();
		String plan = UpdateCustomerView.getPlan();
		int phoneNumber = UpdateCustomerView.getPhoneNumber();

		Customer customer = new Customer(fName, lName, phoneNumber, cardNumber, plan, email);

		Customer.updateCustomer updateCustomer = customer.new updateCustomer();

		boolean updatedCustomer = updateCustomer.updateCustomerDetails(customer, userID);

		if (updatedCustomer) {

			this.UpdateCustomerView.dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Something went wrong, please try again!");

		}

	}

}
